package com.exampletest.mobilestudiotest.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.core.Settings;
import com.exampletest.mobilestudiotest.core.SolidModeling;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.core.Tool;
import com.exampletest.mobilestudiotest.engine.Avatar;
import com.exampletest.mobilestudiotest.engine.ClothingCompositor;
import com.exampletest.mobilestudiotest.engine.Geometry;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import com.exampletest.mobilestudiotest.model.BrickColorV;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.DataModel;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.net.AssetFetcher;
import com.exampletest.mobilestudiotest.net.ImageLoader;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.render.MaterialTextures;
import com.exampletest.mobilestudiotest.render.StaticBatches;
import com.exampletest.mobilestudiotest.render.UnionMeshes;
import com.exampletest.mobilestudiotest.ui.ViewportView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: SceneRenderer.kt */
@Metadata(d1 = {"\u0000¶\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bg\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\u0018\u0000 °\u00032\u00020\u0001:\u0012¨\u0003©\u0003ª\u0003«\u0003¬\u0003\u00ad\u0003®\u0003¯\u0003°\u0003B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u008f\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u0091\u0001\u001a\u00020%2\b\u0010\u0092\u0001\u001a\u00030\u008b\u0001H\u0002J\u0013\u0010¢\u0001\u001a\u00030\u008b\u00012\u0007\u0010£\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010µ\u0001\u001a\u0002092\u0007\u0010¶\u0001\u001a\u00020IH\u0002JK\u0010·\u0001\u001a\u00030¸\u00012\u0007\u0010¶\u0001\u001a\u00020I2\u0007\u0010¹\u0001\u001a\u00020+2\u0007\u0010º\u0001\u001a\u00020\u00072\u0007\u0010»\u0001\u001a\u0002092\b\u0010¼\u0001\u001a\u00030½\u00012\b\u0010¾\u0001\u001a\u00030¿\u00012\u0007\u0010À\u0001\u001a\u000209H\u0002J\u001c\u0010Á\u0001\u001a\f\u0012\u0005\u0012\u00030¸\u0001\u0018\u00010Â\u00012\u0007\u0010¶\u0001\u001a\u00020IH\u0002J\t\u0010Æ\u0001\u001a\u00020\u0007H\u0002J\t\u0010Ç\u0001\u001a\u00020%H\u0002J\u0013\u0010È\u0001\u001a\u00020%2\b\u0010É\u0001\u001a\u00030Ê\u0001H\u0002J\u0013\u0010Ë\u0001\u001a\u00020%2\b\u0010É\u0001\u001a\u00030Ê\u0001H\u0002J\t\u0010Ì\u0001\u001a\u00020%H\u0002J\t\u0010Í\u0001\u001a\u00020%H\u0002J&\u0010Î\u0001\u001a\u00020%2\u0007\u0010Ï\u0001\u001a\u00020\u001b2\t\u0010Ð\u0001\u001a\u0004\u0018\u00010.2\u0007\u0010Ñ\u0001\u001a\u00020\u001bH\u0002J\f\u0010Ò\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002J\u0015\u0010×\u0001\u001a\u0005\u0018\u00010Õ\u00012\u0007\u0010Ø\u0001\u001a\u00020\u0007H\u0002J\u001e\u0010Ú\u0001\u001a\u0005\u0018\u00010Õ\u00012\u0007\u0010¶\u0001\u001a\u00020I2\u0007\u0010Ø\u0001\u001a\u00020\u0007H\u0002J\t\u0010Ü\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010ß\u0001\u001a\u00020%2\b\u0010à\u0001\u001a\u00030Õ\u0001H\u0002J\f\u0010á\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002J\u0012\u0010â\u0001\u001a\u0002092\u0007\u0010Ø\u0001\u001a\u00020\u0007H\u0002J!\u0010ã\u0001\u001a\u00020%2\n\u0010ä\u0001\u001a\u0005\u0018\u00010å\u00012\n\u0010æ\u0001\u001a\u0005\u0018\u00010ç\u0001H\u0016J\t\u0010è\u0001\u001a\u00020%H\u0002J'\u0010ë\u0001\u001a\u00020%2\n\u0010ä\u0001\u001a\u0005\u0018\u00010å\u00012\u0007\u0010ì\u0001\u001a\u00020\u00072\u0007\u0010í\u0001\u001a\u00020\u0007H\u0016J\u0015\u0010î\u0001\u001a\u00020%2\n\u0010ä\u0001\u001a\u0005\u0018\u00010å\u0001H\u0016J\u0018\u0010ø\u0001\u001a\u0005\u0018\u00010¿\u00012\n\u0010ù\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0002J\u0013\u0010ú\u0001\u001a\u00020\u001b2\b\u0010û\u0001\u001a\u00030¿\u0001H\u0002J$\u0010ü\u0001\u001a\u00020\u001b2\u0007\u0010ý\u0001\u001a\u00020\u001b2\u0007\u0010É\u0001\u001a\u00020\u001b2\u0007\u0010þ\u0001\u001a\u00020\u001bH\u0002J-\u0010ÿ\u0001\u001a\u00020%2\u0007\u0010ý\u0001\u001a\u00020+2\u0007\u0010É\u0001\u001a\u00020+2\u0007\u0010à\u0001\u001a\u00020\u001b2\u0007\u0010\u0080\u0002\u001a\u00020+H\u0002J\t\u0010\u0081\u0002\u001a\u00020%H\u0002J\u0012\u0010\u0082\u0002\u001a\u00020\r2\u0007\u0010\u0083\u0002\u001a\u00020\u0007H\u0002J\u0018\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0085\u00022\n\u0010\u0088\u0002\u001a\u0005\u0018\u00010¬\u0001H\u0002J\u001f\u0010\u008d\u0002\u001a\u0005\u0018\u00010½\u00012\u0007\u0010¶\u0001\u001a\u00020I2\b\u0010\u008e\u0002\u001a\u00030\u008f\u0002H\u0002J\u001f\u0010\u0090\u0002\u001a\u0005\u0018\u00010½\u00012\u0007\u0010¶\u0001\u001a\u00020I2\b\u0010\u008e\u0002\u001a\u00030\u008f\u0002H\u0002J\u0013\u0010\u0091\u0002\u001a\u00030½\u00012\u0007\u0010¶\u0001\u001a\u00020IH\u0002J$\u0010\u0092\u0002\u001a\u00020%2\u0007\u0010\u0093\u0002\u001a\u00020\r2\u0007\u0010\u0094\u0002\u001a\u00020\u00072\u0007\u0010\u0095\u0002\u001a\u00020\u0007H\u0002J\u001c\u0010\u0096\u0002\u001a\u00020%2\b\u0010\u008e\u0002\u001a\u00030\u008f\u00022\u0007\u0010\u0097\u0002\u001a\u00020.H\u0002J.\u0010\u0098\u0002\u001a\u0002092\b\u0010\u008e\u0002\u001a\u00030\u008f\u00022\u0007\u0010\u0099\u0002\u001a\u00020.2\u0007\u0010\u009a\u0002\u001a\u00020.2\u0007\u0010\u009b\u0002\u001a\u00020.H\u0002J%\u0010\u009c\u0002\u001a\u0002092\b\u0010\u008e\u0002\u001a\u00030\u008f\u00022\u0007\u0010\u0099\u0002\u001a\u00020.2\u0007\u0010\u009a\u0002\u001a\u00020.H\u0002J\u0016\u0010\u009d\u0002\u001a\u000f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u001b0\u008c\u0002H\u0002J\u001b\u0010£\u0002\u001a\u00020%2\u0007\u0010¤\u0002\u001a\u00020.2\u0007\u0010¥\u0002\u001a\u00020\u001bH\u0002J\t\u0010°\u0002\u001a\u00020%H\u0002J\t\u0010±\u0002\u001a\u000209H\u0002J\t\u0010²\u0002\u001a\u00020%H\u0002J\u0012\u0010³\u0002\u001a\u00020+2\u0007\u0010\u0093\u0002\u001a\u00020\u0007H\u0002J\u0012\u0010´\u0002\u001a\u00020+2\u0007\u0010\u0093\u0002\u001a\u00020\u0007H\u0002J\u001b\u0010µ\u0002\u001a\u00020\u001b2\u0007\u0010¶\u0001\u001a\u00020I2\u0007\u0010¶\u0002\u001a\u00020DH\u0002J\u0013\u0010¸\u0002\u001a\u00020%2\b\u0010\u0092\u0001\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010¹\u0002\u001a\u00020%2\u0007\u0010º\u0002\u001a\u000209H\u0002J\u0012\u0010Ä\u0002\u001a\u00020%2\u0007\u0010º\u0002\u001a\u000209H\u0002J@\u0010Å\u0002\u001a\u00020\r2\u0007\u0010¶\u0001\u001a\u00020I2\u0007\u0010Æ\u0002\u001a\u00020\u001b2\t\u0010Ç\u0002\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010¼\u0001\u001a\u00030½\u00012\f\b\u0002\u0010È\u0002\u001a\u0005\u0018\u00010¿\u0001H\u0002J\t\u0010ã\u0002\u001a\u00020%H\u0002J\u001d\u0010ä\u0002\u001a\u00020\u00072\t\u0010\u0088\u0002\u001a\u0004\u0018\u00010D2\u0007\u0010å\u0002\u001a\u000209H\u0002J\t\u0010ê\u0002\u001a\u000209H\u0002J%\u0010ë\u0002\u001a\u00020%2\u0007\u0010¶\u0001\u001a\u00020I2\b\u0010¼\u0001\u001a\u00030½\u00012\u0007\u0010Æ\u0002\u001a\u00020\u001bH\u0002J\u0016\u0010ì\u0002\u001a\u0004\u0018\u00010.2\t\u0010ý\u0001\u001a\u0004\u0018\u00010IH\u0002J$\u0010í\u0002\u001a\u00020%2\u0007\u0010ý\u0001\u001a\u00020.2\u0007\u0010É\u0001\u001a\u00020.2\u0007\u0010î\u0002\u001a\u00020\u001bH\u0002J\t\u0010ï\u0002\u001a\u00020%H\u0002J\u0019\u0010ð\u0002\u001a\t\u0012\u0004\u0012\u00020I0Â\u00012\u0007\u0010ý\u0001\u001a\u00020IH\u0002J\t\u0010ñ\u0002\u001a\u00020%H\u0002J\u001b\u0010ò\u0002\u001a\u00020\u00072\u0007\u0010ó\u0002\u001a\u00020J2\u0007\u0010å\u0002\u001a\u000209H\u0002J\u001d\u0010õ\u0002\u001a\u00020\u00072\t\u0010\u0088\u0002\u001a\u0004\u0018\u00010D2\u0007\u0010å\u0002\u001a\u000209H\u0002J&\u0010ö\u0002\u001a\u00030÷\u00022\b\u0010¼\u0001\u001a\u00030½\u00012\u0007\u0010ø\u0002\u001a\u00020\u00072\u0007\u0010ù\u0002\u001a\u00020\u001bH\u0002J\u0012\u0010ú\u0002\u001a\u00020\u00192\u0007\u0010û\u0002\u001a\u00020IH\u0002J\t\u0010ü\u0002\u001a\u00020%H\u0002J/\u0010\u0084\u0003\u001a\u00020%2\u0007\u0010\u0085\u0003\u001a\u00020I2\b\u0010¼\u0001\u001a\u00030½\u00012\u0007\u0010\u0086\u0003\u001a\u00020\u00072\b\u0010\u0087\u0003\u001a\u00030\u0081\u0003H\u0002J#\u0010\u0091\u0003\u001a\u0011\u0012\u0004\u0012\u000209\u0012\u0006\u0012\u0004\u0018\u00010J0\u008c\u00022\t\u0010\u0088\u0002\u001a\u0004\u0018\u00010DH\u0002J\"\u0010\u0092\u0003\u001a\u00020%2\u0007\u0010\u0093\u0003\u001a\u00020I2\u000e\u0010\u0094\u0003\u001a\t\u0012\u0004\u0012\u00020I0Â\u0001H\u0002J\t\u0010\u0095\u0003\u001a\u00020%H\u0002J\t\u0010\u0099\u0003\u001a\u00020%H\u0002J\u0014\u0010\u009a\u0003\u001a\u0004\u0018\u00010I2\u0007\u0010¶\u0001\u001a\u00020IH\u0002J\t\u0010\u009b\u0003\u001a\u00020%H\u0002J\u0012\u0010\u009c\u0003\u001a\u00020%2\u0007\u0010\u0093\u0002\u001a\u00020\rH\u0002J\t\u0010\u009e\u0003\u001a\u00020\u0007H\u0002J\t\u0010\u009f\u0003\u001a\u00020JH\u0002J\t\u0010 \u0003\u001a\u00020%H\u0002J\t\u0010¡\u0003\u001a\u00020%H\u0002J\u001b\u0010¢\u0003\u001a\u00020\u00072\u0007\u0010£\u0003\u001a\u00020\u00072\u0007\u0010¤\u0003\u001a\u00020DH\u0002J\u001b\u0010¥\u0003\u001a\u00020\u00072\u0007\u0010¦\u0003\u001a\u00020D2\u0007\u0010§\u0003\u001a\u00020DH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010B\u001a\u001e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00070Cj\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u0007`EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R:\u0010G\u001a\"\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020%\u0018\u00010HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020Q0PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010S\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020+0Cj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020+`EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u007f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0081\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0094\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0095\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009c\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u008b\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u009f\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u008b\u00010 \u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¡\u0001R\u0010\u0010¤\u0001\u001a\u00030¥\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010¦\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010¨\u0001\u001a\u00020\u001b2\u0007\u0010§\u0001\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b©\u0001\u0010\u001dR\u000f\u0010ª\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u00ad\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010®\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¯\u0001\u001a\u00030°\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020D0²\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020D0 \u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010´\u0001R\u000f\u0010Ã\u0001\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Ä\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010Å\u0001\u001a\u001e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00070Cj\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u0007`EX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010Ó\u0001\u001a\u0010\u0012\u0005\u0012\u00030Ô\u0001\u0012\u0005\u0012\u00030Õ\u00010PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Ö\u0001\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010Ù\u0001\u001a\u000f\u0012\u0004\u0012\u00020I\u0012\u0005\u0012\u00030Õ\u00010PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Û\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ý\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Þ\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010é\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ê\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ï\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ð\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ñ\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ò\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ó\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ô\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010õ\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ö\u0001\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010÷\u0001\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u0084\u0002\u001a \u0012\u0004\u0012\u00020\u0019\u0012\u0005\u0012\u00030\u0085\u00020Cj\u000f\u0012\u0004\u0012\u00020\u0019\u0012\u0005\u0012\u00030\u0085\u0002`EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0089\u0002\u001a\u000f\u0012\u0004\u0012\u00020I\u0012\u0005\u0012\u00030\u008a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000RS\u0010\u008b\u0002\u001aF\u0012\u0004\u0012\u00020D\u0012\u0018\u0012\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u008c\u00020Â\u00010Cj\"\u0012\u0004\u0012\u00020D\u0012\u0018\u0012\u0016\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u008c\u00020Â\u0001`EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0002\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0002\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010 \u0002\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¦\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010§\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¨\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010©\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ª\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010«\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¬\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u00ad\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010®\u0002\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0019\u0010¯\u0002\u001a\t\u0012\u0004\u0012\u00020D0 \u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010´\u0001R\u000f\u0010·\u0002\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010»\u0002\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¼\u0002\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010½\u0002\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¾\u0002\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¿\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010À\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Á\u0002\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Â\u0002\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ã\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010É\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ê\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ë\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ì\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Í\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Î\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ï\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ð\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ñ\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ò\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ó\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ô\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Õ\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ö\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010×\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ø\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ù\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ú\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Û\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ü\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ý\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Þ\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ß\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010à\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010á\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010â\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010æ\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020D0Cj\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020D`EX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010ç\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020D0Cj\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020D`EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010è\u0002\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010é\u0002\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010ô\u0002\u001a\u001e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D0Cj\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D`EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010ý\u0002\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u000f\u0010þ\u0002\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010ÿ\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0005\u0012\u00030\u0081\u00030\u0080\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0082\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0005\u0012\u00030\u0081\u00030\u0080\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0083\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0005\u0012\u00030\u0081\u00030\u0080\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0088\u0003\u001a\u001c\u0012\u0004\u0012\u00020D\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D0\u0080\u00030\u0089\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RV\u0010\u008a\u0003\u001aI\u0012\r\u0012\u000b \u008c\u0003*\u0004\u0018\u00010D0D\u0012\r\u0012\u000b \u008c\u0003*\u0004\u0018\u00010909 \u008c\u0003*#\u0012\r\u0012\u000b \u008c\u0003*\u0004\u0018\u00010D0D\u0012\r\u0012\u000b \u008c\u0003*\u0004\u0018\u00010909\u0018\u00010\u008b\u00030\u008b\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u008d\u0003\u001a\r \u008c\u0003*\u0005\u0018\u00010\u008e\u00030\u008e\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u008f\u0003\u001a\u000f\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020D0\u0080\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0090\u0003\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020D0PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0003\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0097\u0003\u001a\u0016\u0012\u0004\u0012\u00020D\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020I0Â\u00010\u0080\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0098\u0003\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0003\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006±\u0003"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/SceneRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "<init>", "(Lcom/exampletest/mobilestudiotest/core/Studio;)V", "lit", "", "line", "depthProg", "skyProg", "decalProg", "cube", "Lcom/exampletest/mobilestudiotest/render/Mesh;", "sphere", "cylinder", "cylinderY", "wedge", "corner", "head", "headFace", "quad", "screen", "boxLines", "lastNs", "", "fps", "", "getFps", "()F", "setFps", "(F)V", "fpsAcc", "fpsFrames", "time", "onFrame", "Lkotlin/Function0;", "", "getOnFrame", "()Lkotlin/jvm/functions/Function0;", "setOnFrame", "(Lkotlin/jvm/functions/Function0;)V", "model", "", "normal", "sunDir", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "zenith", "horizon", "sunColor", "fogColor", "fogStart", "fogEnd", "fogMode", "ambient", "exposure", "shadowsOn", "", "dayFactor", "shadowFbo", "shadowTex", "shadowSize", "shadowOk", "lightVP", "lightView", "lightProj", "textures", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "faceTex", "surfacePainter", "Lkotlin/Function4;", "Lcom/exampletest/mobilestudiotest/model/Instance;", "Landroid/graphics/Bitmap;", "getSurfacePainter", "()Lkotlin/jvm/functions/Function4;", "setSurfacePainter", "(Lkotlin/jvm/functions/Function4;)V", "surfaceTex", "Ljava/util/IdentityHashMap;", "Lcom/exampletest/mobilestudiotest/render/SceneRenderer$SurfaceTex;", "scratch", "matCache", "uVP", "uModel", "uNrm", "uColor", "uLight", "uCam", "uEmissive", "uGrid", "uSize", "uHorizon", "uZenith", "uSun", "uAmbient", "uFogColor", "uFog", "uMat", "uSurfA", "uSurfB", "uShadow", "uShadowOn", "uShadowTexel", "uShadowVP", "uExposure", "uTime", "uTruss", "aPos", "aNrm", "lVP", "lModel", "lColor", "laPos", "dVP", "dModel", "daPos", "sInvVP", "sCam", "sSun", "sZenith", "sHorizon", "sSunColor", "sTime", "sDay", "saPos", "cVP", "cModel", "cTex", "cTint", "cNormal", "cLight", "cSun", "cAmbient", "cUv", "caPos", "caUv", "litBasic", "Lcom/exampletest/mobilestudiotest/render/SceneRenderer$LitLocs;", "litAdv", "frames", "activeLit", "litLocs", "prog", "useLit", "l", "uMatTex", "uMatNrm", "uTexScale", "uHasNrm", "uSurfTex", "uHasSurfTex", "aUvB", "aCol", "aMatB", "aTan", "aBit", "litTex", "batchLit", "", "[Lcom/exampletest/mobilestudiotest/render/SceneRenderer$LitLocs;", "batchProgram", "kind", "frustum", "Lcom/exampletest/mobilestudiotest/render/Frustum;", "detailScale", "value", "quality", "getQuality", "qualityTimer", "lastModel", "", "closest", "nearPlane", "batches", "Lcom/exampletest/mobilestudiotest/render/StaticBatches;", "BATCH_CLASSES", "", "SURFACES", "[Ljava/lang/String;", "isBatchable", "p", "spec", "Lcom/exampletest/mobilestudiotest/render/BatchSpec;", "data", "stride", "isCube", "g", "Lcom/exampletest/mobilestudiotest/render/SceneRenderer$Geo;", TypedValues.Custom.S_COLOR, "Lcom/exampletest/mobilestudiotest/model/Color3;", "pending", "batchSpec", "", "FLOAT4_ZERO", "meshBatchProg", "mb", "meshBatchProgram", "useMeshBatch", "drawMeshBatch", "b", "Lcom/exampletest/mobilestudiotest/render/StaticBatches$Batch;", "drawBatch", "endBatches", "drawStaticBatches", "updateBatches", "dt", "shadowAt", "shadowR", "texturedLit", "matTexGpu", "Lcom/exampletest/mobilestudiotest/render/MaterialTextures$MatTex;", "Lcom/exampletest/mobilestudiotest/render/TexBind;", "modernMaterialsNow", "materialBind", "mat", "variantBinds", "texturesFor", "whiteTexId", "whiteTex", "surfTex", "aniso", "bindTextures", "t", "advancedLit", "needsAdvanced", "onSurfaceCreated", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "setupShadowMap", "surfW", "surfH", "onSurfaceChanged", "width", "height", "onDrawFrame", "slowAvg", "statTimer", "cpuAcc", "cpuN", "tSim", "tUpd", "tShadow", "tDraw", "noBatch", "c3", "v", "luma", "c", "smooth", "a", "x", "mix", "out", "updateLighting", "meshFor", "shape", "gpuMeshes", "Lcom/exampletest/mobilestudiotest/render/SceneRenderer$GpuMesh;", "meshEpoch", "fileMesh", "content", "unionGpu", "Lcom/exampletest/mobilestudiotest/render/SceneRenderer$UnionGpu;", "storedUnionGpu", "Lkotlin/Pair;", "storedUnionGeo", "cf", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "unionGeo", "geometry", "bind", "m", "posLoc", "nrmLoc", "setModel", "s", "visible", "size", "camPos", "fwd", "inView", "shadowFocus", "shadowValid", "lastLightVP", "lastShadowChange", "lastShadowMeshEpoch", "shadowAge", "renderShadowMap", "focus", "radius", "skyboxProg", "kVP", "kCam", "kRot", "kTex", "kTint", "kaPos", "kaUv", "skyboxMesh", "SKY_FACES", "setupSkybox", "drawSkybox", "drawSky", "material", "materialParams", "surf", "name", "frameShadows", "switchLit", "drawParts", "shadows", "tB", "tL", "tDec", "tTr", "nTr", "nLoose", "tClo", "tSg", "nSgRender", "setLitFrameUniforms", "drawPart", "alpha", "current", "colorOverride", "meshProg", "mVP", "mModel", "mNrm", "mColor", "mLight", "mSun", "mAmbient", "mTex", "mHasTex", "mShadow", "mShadowVP", "mShadowOn", "mShadowTexel", "mCam", "mFogColor", "mFog", "mExposure", "mTint", "mEmissive", "mHorizon", "mZenith", "maPos", "maNrm", "maUv", "meshFrame", "setupMeshProgram", "assetTexture", "repeat", "rawKeys", "rawKeysR", "canDownloadFrame", "canDownloadNow", "canDownload", "drawFileMesh", "attachmentWorld", "segment", "thick", "drawConstraints", "adorneeParts", "drawAdornments", "upload", "bmp", "repeatKeys", "textureFor", "faceQuad", "Lcom/exampletest/mobilestudiotest/render/SceneRenderer$FaceQuad;", "faceId", "lift", "signature", "sg", "drawSurfaceGuis", "TW", "TH", "torsoRegions", "", "Lcom/exampletest/mobilestudiotest/render/SceneRenderer$Region;", "rightLimbRegions", "leftLimbRegions", "drawTemplateFace", "part", "face", "r", "r15Tex", "Ljava/util/concurrent/ConcurrentHashMap;", "r15Pending", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "r15Pool", "Ljava/util/concurrent/ExecutorService;", "partTexOverride", "nextOverride", "clothingImage", "r15Clothing", "rig", "items", "drawClothing", "variantIndexAt", "variantIndex", "variantService", "refreshVariants", "variantFor", "drawDecals", "drawUvMesh", "gridTex", "gridTexture", "faceBitmap", "drawSelection", "drawHandles", "compile", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "src", "program", "vs", "fs", "SurfaceTex", "LitLocs", "Geo", "GpuMesh", "UnionGpu", "Draw", "FaceQuad", "Region", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SceneRenderer implements GLSurfaceView.Renderer {
    public static final long BASEPLATE_GRID_ID = 6372755229L;
    private static final String DECAL_FS = "\n#ifdef GL_FRAGMENT_PRECISION_HIGH\nprecision highp float;\n#else\nprecision mediump float;\n#endif\n\nvarying vec2 vUv;\nuniform sampler2D uTex; uniform vec4 uTint; uniform vec3 uNormal; uniform vec3 uLight; uniform vec3 uSun; uniform float uAmbient;\nvoid main() {\n  vec4 t = texture2D(uTex, vUv);\n  float diff = max(dot(normalize(uNormal), uLight), 0.0);\n  vec3 light = vec3(uAmbient) + uSun * diff;\n  gl_FragColor = vec4(t.rgb * uTint.rgb * light, t.a) * uTint.a;\n}";
    private static final String DECAL_VS = "\nuniform mat4 uVP; uniform mat4 uModel; uniform vec4 uUv;\nattribute vec3 aPos; attribute vec2 aUv;\nvarying vec2 vUv;\nvoid main() { vUv = aUv * uUv.xy + uUv.zw; gl_Position = uVP * uModel * vec4(aPos, 1.0); }";
    private static final String DEPTH_FS = "\n#ifdef GL_FRAGMENT_PRECISION_HIGH\nprecision highp float;\n#else\nprecision mediump float;\n#endif\n\nvoid main() {\n  vec4 enc = vec4(1.0, 255.0, 65025.0, 16581375.0) * gl_FragCoord.z;\n  enc = fract(enc);\n  enc -= enc.yzww * vec4(1.0 / 255.0, 1.0 / 255.0, 1.0 / 255.0, 0.0);\n  gl_FragColor = enc;\n}";
    private static final String DEPTH_VS = "\nuniform mat4 uVP; uniform mat4 uModel;\nattribute vec3 aPos;\nvoid main() { gl_Position = uVP * uModel * vec4(aPos, 1.0); }";
    private static final int GL_MAX_ANISOTROPY = 34047;
    private static final int GL_TEXTURE_MAX_ANISOTROPY = 34046;
    private static final String LINE_FS = "\nprecision mediump float;\nuniform vec4 uColor;\nvoid main() { gl_FragColor = uColor; }";
    private static final String LINE_VS = "\nuniform mat4 uVP; uniform mat4 uModel;\nattribute vec3 aPos;\nvoid main() { gl_Position = uVP * uModel * vec4(aPos, 1.0); }";
    private static final String LIT_FS = "\n#ifdef GL_FRAGMENT_PRECISION_HIGH\nprecision highp float;\n#else\nprecision mediump float;\n#endif\n\n#ifdef BATCH\nvarying vec3 vN; varying vec3 vW; varying vec4 vS; varying vec3 vA; varying vec4 vCol; varying vec4 vMat;\n#else\nvarying vec3 vN; varying vec3 vW; varying vec3 vL; varying vec3 vLN; varying vec4 vS;\n#endif\nuniform vec4 uColor; uniform vec3 uLight; uniform vec3 uCam; uniform float uEmissive;\nuniform float uGrid; uniform vec3 uSize; uniform vec3 uHorizon; uniform vec3 uZenith; uniform vec3 uSun;\nuniform float uAmbient; uniform vec3 uFogColor; uniform vec3 uFog; uniform vec4 uMat; uniform vec3 uSurfA; uniform vec3 uSurfB;\nuniform sampler2D uShadow; uniform float uShadowOn; uniform vec2 uShadowTexel; uniform float uExposure; uniform float uTime; uniform float uTruss;\nuniform sampler2D uSurfTex; uniform float uHasSurfTex;\n#ifdef TEXTURED\nvarying vec3 vT; varying vec3 vB;\nuniform sampler2D uMatTex; uniform sampler2D uMatNrm; uniform float uTexScale; uniform float uHasNrm;\n#endif\n\nfloat hash(vec2 p) { return fract(sin(dot(p, vec2(127.1, 311.7))) * 43758.5453); }\nvec2 hash2(vec2 p) { return fract(sin(vec2(dot(p, vec2(127.1, 311.7)), dot(p, vec2(269.5, 183.3)))) * 43758.5453); }\nfloat noise(vec2 p) {\n  vec2 i = floor(p); vec2 f = fract(p); f = f * f * (3.0 - 2.0 * f);\n  return mix(mix(hash(i), hash(i + vec2(1.0, 0.0)), f.x), mix(hash(i + vec2(0.0, 1.0)), hash(i + vec2(1.0, 1.0)), f.x), f.y);\n}\nfloat fbm(vec2 p) { return noise(p) * 0.5 + noise(p * 2.03 + 7.1) * 0.3 + noise(p * 4.1 + 3.3) * 0.2; }\n#ifdef ADVANCED\n// Cellular noise: x = distance to the nearest cell point, y = distance to the cell edge (approx).\nvec3 voro(vec2 x) {\n  vec2 n = floor(x); vec2 f = fract(x);\n  float d1 = 8.0; float d2 = 8.0; vec2 id = n;\n  for (int j = -1; j <= 1; j++) for (int i = -1; i <= 1; i++) {\n    vec2 g = vec2(float(i), float(j));\n    vec2 r = g + hash2(n + g) - f;\n    float d = dot(r, r);\n    if (d < d1) { d2 = d1; d1 = d; id = n + g; } else if (d < d2) { d2 = d; }\n  }\n  return vec3(sqrt(d1), sqrt(d2) - sqrt(d1), hash(id));\n}\n#endif\n// Roblox surface types on one face (sp = stud coordinates on the face, fsz = face size).\n// Roblox's stud look: a raised disc lit from the upper left with a soft shadow to the lower right.\nfloat studShade(vec2 f, float R) {\n  vec2 L = vec2(-0.62, 0.78);\n  float r = length(f);\n  float inside = smoothstep(R + 0.012, R - 0.012, r);\n  float rim = smoothstep(R - 0.09, R, r) * inside;\n  float side = dot(f / max(r, 0.001), L);\n  float shadow = smoothstep(R + 0.1, R, length(f + L * 0.05)) * (1.0 - inside);\n  return 1.0 + inside * 0.05 + rim * side * 0.22 - shadow * 0.2;\n}\nvec3 surface(vec3 c, float s, vec2 sp, vec2 fsz) {\n  if (s < 0.5 || s > 9.5) return c;\n  if (uHasSurfTex > 0.5 && s < 5.5) {\n    // Roblox's own surface textures: one 2x8-stud tile per type, shaded around grey 128\n    // (R = studs, G = weld/glue, B = inlet). Sampled with repeat (no fract) so mipmapping\n    // never sees a seam. s is the same for a whole face, so this branch is uniform per triangle.\n    vec2 st = vec2(sp.x * 0.5, -sp.y * 0.125);\n    vec3 t = texture2D(uSurfTex, st).rgb;\n    float k;\n    if (s < 2.5) k = t.g;\n    else if (s < 3.5) k = t.r;\n    else if (s < 4.5) k = t.b;\n    else { vec2 cell = floor(fract(st) * vec2(2.0, 8.0)); k = mod(cell.x + cell.y, 2.0) < 0.5 ? t.r : t.b; }\n    return c * (k * 2.0);\n  }\n  vec2 f = fract(sp) - 0.5; float r = length(f);\n  if (s > 2.5 && s < 3.5) { // Studs\n    c *= studShade(f, 0.29);\n  } else if (s > 3.5 && s < 4.5) { // Inlet: a sunken hole, shaded the opposite way\n    vec2 L = vec2(-0.62, 0.78);\n    float inside = smoothstep(0.302, 0.278, r);\n    float rim = smoothstep(0.2, 0.29, r) * inside;\n    c *= 1.0 - inside * 0.16 - rim * dot(f / max(r, 0.001), L) * 0.2 + smoothstep(0.36, 0.3, r) * (1.0 - inside) * 0.05;\n  } else if (s > 4.5 && s < 5.5) { // Universal: a stud with a hole in it\n    c *= studShade(f, 0.29) * (1.0 - smoothstep(0.14, 0.12, r) * 0.18);\n  } else if (s > 1.5 && s < 2.5) { // Weld: diagonal hatching\n    float l = fract((sp.x + sp.y) * 1.25);\n    c *= mix(1.0, 0.84, smoothstep(0.82, 0.88, l) * smoothstep(1.0, 0.94, l));\n  } else if (s > 0.5 && s < 1.5) { // Glue: grid of small crosses\n    vec2 g = abs(fract(sp * 2.0) - 0.5);\n    float cr = max(step(g.x, 0.05) * step(g.y, 0.22), step(g.y, 0.05) * step(g.x, 0.22));\n    c *= 1.0 - 0.14 * cr;\n  } else { // Hinge / Motor / SteppingMotor: a yellow joint in the middle of the face\n    float rr = length(sp - fsz * 0.5);\n    vec3 yellow = vec3(0.96, 0.8, 0.16);\n    if (s > 6.5) {\n      if (rr < 0.75) c = mix(c, vec3(0.45, 0.45, 0.47), smoothstep(0.75, 0.7, rr));\n      if (s > 7.5 && rr < 0.75 && rr > 0.5) { float a = atan(sp.y - fsz.y * 0.5, sp.x - fsz.x * 0.5); c *= 0.75 + 0.25 * step(0.5, fract(a * 1.273)); }\n    }\n    if (rr < 0.45) c = mix(c, yellow, smoothstep(0.45, 0.4, rr));\n  }\n  return c;\n}\nfloat unpackDepth(vec4 c) { return dot(c, vec4(1.0, 1.0 / 255.0, 1.0 / 65025.0, 1.0 / 16581375.0)); }\nfloat sampleShadow(vec2 uv, float z) { return z > unpackDepth(texture2D(uShadow, uv)) ? 0.0 : 1.0; }\nfloat shadowAt(float ndl) {\n  if (uShadowOn < 0.5 || ndl <= 0.0) return 1.0;\n  vec3 p = vS.xyz / vS.w * 0.5 + 0.5;\n  if (p.x <= 0.001 || p.x >= 0.999 || p.y <= 0.001 || p.y >= 0.999 || p.z >= 1.0) return 1.0;\n  float z = p.z - (0.0012 + 0.0035 * (1.0 - ndl));\n  vec2 t = uShadowTexel;\n  float s = sampleShadow(p.xy, z) * 2.0;\n  s += sampleShadow(p.xy + vec2(-t.x, -t.y), z);\n  s += sampleShadow(p.xy + vec2(t.x, -t.y), z);\n  s += sampleShadow(p.xy + vec2(-t.x, t.y), z);\n  s += sampleShadow(p.xy + vec2(t.x, t.y), z);\n  s /= 6.0;\n  vec2 e = min(p.xy, 1.0 - p.xy);\n  float fade = clamp(min(e.x, e.y) * 12.0, 0.0, 1.0);\n  return mix(1.0, s, fade);\n}\nvoid main() {\n  vec3 n = normalize(vN);\n  if (!gl_FrontFacing) n = -n;\n#ifdef BATCH\n  vec3 c = vCol.rgb; vec4 mat = vMat; float emis = vCol.a; float alpha = 1.0;\n  vec2 uv = vA.xy; vec2 fsz = vec2(1.0); float sf = vA.z;\n#else\n  vec3 c = uColor.rgb; vec4 mat = uMat; float emis = uEmissive; float alpha = uColor.a;\n  vec3 a = abs(vLN);\n  vec3 p = vL * uSize + uSize * 0.5;\n  bool yFace = a.y > a.x && a.y > a.z; bool xFace = !yFace && a.x > a.z;\n  vec2 uv = yFace ? p.xz : (xFace ? p.zy : p.xy);\n  vec2 fsz = yFace ? uSize.xz : (xFace ? uSize.zy : uSize.xy);\n  // Surface types (studs, inlets, welds, hinges...) on whichever face this is.\n  float sf = yFace ? (vLN.y > 0.0 ? uSurfA.y : uSurfB.y) : (xFace ? (vLN.x > 0.0 ? uSurfA.x : uSurfB.x) : (vLN.z > 0.0 ? uSurfA.z : uSurfB.z));\n  if (uTruss > 0.5) {\n    // Lattice: frame and diagonals per 2-stud cell; everything else is see-through.\n    vec2 cell = fract(uv / 2.0);\n    float e = min(min(cell.x, cell.y), min(1.0 - cell.x, 1.0 - cell.y));\n    float dg = min(abs(cell.x - cell.y), abs(cell.x + cell.y - 1.0));\n    if (e > 0.11 && dg > 0.07) discard;\n  }\n#endif\n  vec3 glow = vec3(0.0);\n  float type = mat.x;\n#ifdef TEXTURED\n  // Roblox material textures: the color map tints the part color; the normal map bends the light.\n  vec2 tuv = vec2(uv.x, -uv.y) * uTexScale;\n  c *= texture2D(uMatTex, tuv).rgb * 1.08;\n  if (uHasNrm > 0.5) {\n    vec3 tn = texture2D(uMatNrm, tuv).xyz * 2.0 - 1.0;\n    n = normalize(normalize(vT) * tn.x + normalize(vB) * tn.y + n * max(tn.z, 0.25));\n  }\n  type = 0.0;\n#endif\n  if (type > 0.5) {\n    float amt = mat.y; float sc = mat.z;\n#ifdef ADVANCED\n    if (type > 10.5) {\n      if (type < 11.5) { // Marble veins\n        float v = abs(sin((uv.x * 0.6 + uv.y * 0.25 + fbm(uv * 0.35) * 5.0) * 1.7));\n        c *= mix(0.8, 1.05, pow(v, 0.35)) + (noise(uv * 3.0) - 0.5) * 0.04;\n      } else if (type < 12.5) { // Slate / sandstone: layered plates\n        float layer = floor(uv.y * sc * 2.0 + fbm(uv * 0.3) * 2.5);\n        c *= 0.9 + hash(vec2(layer, 3.0)) * 0.16 + (noise(uv * 5.0) - 0.5) * amt;\n      } else if (type < 13.5) { // Cobblestone / pebble / basalt: cells with dark gaps\n        vec3 v = voro(uv * sc);\n        c *= mix(0.62, 0.92 + v.z * 0.16, smoothstep(0.03, 0.12, v.y)) * (1.0 - v.x * 0.12);\n      } else if (type < 14.5) { // Cracked lava: dark rock with glowing cracks\n        vec3 v = voro(uv * sc);\n        c *= 0.55 + fbm(uv * 1.5) * 0.25;\n        glow = vec3(1.0, 0.36, 0.05) * smoothstep(0.08, 0.0, v.y) * (0.7 + 0.3 * sin(uTime * 1.5 + v.z * 6.0));\n      } else if (type < 15.5) { // Corroded metal: rust patches\n        float rust = smoothstep(0.42, 0.66, fbm(uv * sc));\n        c = mix(c * (0.95 + (noise(uv * vec2(18.0, 0.8)) - 0.5) * 0.08), c * vec3(0.7, 0.42, 0.24) + vec3(0.14, 0.05, 0.0), rust * 0.8);\n      } else if (type < 16.5) { // Tiles (ceramic / pavement)\n        vec2 tf = fract(uv / sc); float grout = step(0.035, tf.x) * step(0.035, tf.y);\n        c *= mix(0.72, 1.0 + (hash(floor(uv / sc)) - 0.5) * amt * 2.0 + (noise(uv * 3.0) - 0.5) * 0.04, grout);\n      } else if (type < 17.5) { // Roof tiles / shingles: overlapping rows\n        float row = floor(uv.y / (0.8 * sc));\n        vec2 q = vec2(uv.x / sc + mod(row, 2.0) * 0.5, fract(uv.y / (0.8 * sc)));\n        float edge = smoothstep(0.0, 0.08, fract(q.x)) * smoothstep(1.0, 0.92, fract(q.x));\n        c *= (0.8 + 0.25 * q.y) * mix(0.82, 1.0, edge) * (0.94 + hash(vec2(floor(q.x), row)) * 0.12);\n      } else if (type < 18.5) { // Cardboard corrugation\n        c *= 0.95 + 0.05 * sin(uv.x * 22.0) + (noise(uv * 8.0) - 0.5) * 0.06;\n      } else if (type < 19.5) { // ForceField: moving bands\n        float s = sin((uv.x + uv.y) * 2.5 - uTime * 2.2) * 0.5 + 0.5;\n        c = c * (0.55 + 0.45 * s) + vec3(0.12) * s;\n      } else if (type < 20.5) { // Leather: small creased cells\n        vec3 v = voro(uv * 6.0);\n        c *= 0.9 + 0.1 * smoothstep(0.0, 0.12, v.y) + (v.z - 0.5) * 0.04;\n      } else if (type < 21.5) { // Carpet: dense fibres\n        c *= 0.9 + hash(floor(uv * 28.0)) * 0.12 + (noise(uv * 6.0) - 0.5) * 0.1;\n      } else if (type < 22.5) { // Asphalt: speckled\n        c *= 0.9 + (hash(floor(uv * 16.0)) - 0.5) * 0.25 + (noise(uv * 2.0) - 0.5) * 0.08;\n      } else if (type < 23.5) { // Concrete: blotchy with pores\n        c *= 1.0 + (fbm(uv * sc) - 0.5) * amt * 2.4 - step(0.985, hash(floor(uv * 20.0))) * 0.18;\n      } else if (type < 24.5) { // Granite: mixed grains\n        float g = hash(floor(uv * 12.0));\n        c *= 0.88 + g * 0.22 - step(0.9, g) * 0.3 + (fbm(uv * 1.5) - 0.5) * 0.1;\n      } else { // Sand / snow / salt: fine grain with sparkle\n        float g = hash(floor(uv * 30.0));\n        c *= 1.0 + (g - 0.5) * amt * 2.0 + (fbm(uv * sc) - 0.5) * 0.1;\n        c += vec3(step(0.996, g) * 0.15);\n      }\n    } else\n    if (type < 1.5) { c *= 1.0 + (noise(uv * 2.2) - 0.5) * amt * 2.0; }\n    else if (type < 2.5) {\n      float g = sin((uv.x * 1.3 + fbm(uv * vec2(0.35, 2.2)) * 4.0) * 5.0);\n      c *= 1.0 + g * amt * 0.6 - amt * 0.2;\n    } else if (type < 3.5) {\n      float plank = floor(uv.y);\n      float seamY = smoothstep(0.0, 0.05, fract(uv.y)) * smoothstep(1.0, 0.95, fract(uv.y));\n      float off = hash(vec2(plank, 3.0)) * 8.0;\n      float seamX = smoothstep(0.0, 0.04, fract((uv.x + off) / 6.0) * 6.0);\n      float g = sin((uv.x * 1.6 + fbm(vec2(uv.x * 0.3, uv.y * 3.0 + plank)) * 3.0) * 6.0);\n      c *= (0.9 + hash(vec2(plank, 1.0)) * 0.18) * (1.0 + g * amt * 0.35) * mix(0.72, 1.0, seamY * seamX);\n    } else if (type < 4.5) {\n      // Brick: running bond with light grey mortar, like Roblox's brick material.\n      vec2 b = vec2(uv.x / 1.6, uv.y / 0.66);\n      float row = floor(b.y);\n      b.x += mod(row, 2.0) * 0.5;\n      vec2 f = fract(b);\n      float mortar = smoothstep(0.05, 0.09, f.y) * smoothstep(0.025, 0.05, f.x) * smoothstep(1.0, 0.985, f.x);\n      vec3 brick = c * (0.9 + (hash(floor(b)) - 0.5) * amt * 2.2 + (noise(uv * 7.0) - 0.5) * 0.08);\n      vec3 grout = mix(vec3(dot(c, vec3(0.3, 0.59, 0.11))), vec3(0.82), 0.55);\n      c = mix(grout, brick, mortar);\n    } else if (type < 5.5) { c *= 1.0 + (fbm(uv * sc) - 0.5) * amt * 2.6; }\n    else if (type < 6.5) {\n      vec2 q = vec2(uv.x + uv.y, uv.x - uv.y) * 1.4;\n      vec2 f = fract(q) - 0.5;\n      float bump = smoothstep(0.18, 0.05, abs(f.x) * 0.35 + abs(f.y));\n      c *= 0.92 + bump * 0.22 + (noise(uv * 8.0) - 0.5) * 0.05;\n    } else if (type < 7.5) { c *= 1.0 + (noise(uv * vec2(24.0, 0.6)) - 0.5) * amt * 2.0; }\n    else if (type < 8.5) {\n      float f = fbm(uv * sc);\n      c *= 1.0 + (f - 0.5) * amt * 2.4 + (noise(uv * 9.0) - 0.5) * 0.05;\n      c.r += (noise(uv * 0.25) - 0.5) * 0.04;\n    } else if (type < 9.5) { c *= 1.0 + sin(uv.x * 30.0) * sin(uv.y * 30.0) * amt; }\n    else { c *= 1.0 + (fbm(uv * sc) - 0.5) * amt * 2.0; }\n#else\n    // Lean variant: plastic grain only (other materials use the ADVANCED program).\n    c *= 1.0 + (noise(uv * 2.2) - 0.5) * amt * 2.0;\n#endif\n  }\n  c = surface(c, sf, uv, fsz);\n#ifndef BATCH\n  if (uGrid > 0.5) {\n    vec2 f = abs(fract(uv / 4.0 + 0.5) - 0.5) * 4.0;\n    float d = min(f.x, f.y);\n    c *= mix(0.84, 1.0, smoothstep(0.04, 0.09, d));\n  }\n#endif\n  vec3 col;\n  if (emis > 0.5) {\n    col = c * 1.15 + vec3(0.06);\n  } else {\n    float ndl = dot(n, uLight);\n    float diff = max(ndl, 0.0);\n    float sh = shadowAt(ndl);\n    vec3 sky = mix(uHorizon, uZenith, 0.5);\n    vec3 amb = uAmbient * mix(vec3(0.82), mix(vec3(1.0), sky * 1.2, 0.35), 0.5 + 0.5 * n.y);\n    col = c * (amb + uSun * diff * sh);\n    vec3 v = normalize(uCam - vW);\n    vec3 h = normalize(uLight + v);\n    float spec = pow(max(dot(n, h), 0.0), 16.0 + mat.w * 80.0) * mat.w * sh;\n    col += uSun * spec * 0.6;\n    float fres = pow(1.0 - max(dot(n, v), 0.0), 4.0) * mat.w * 0.25;\n    col = mix(col, uZenith, fres);\n  }\n  col += glow;\n  col *= uExposure;\n  float dist = length(uCam - vW);\n  float fog;\n  if (uFog.z > 1.5) fog = (1.0 - exp(-dist * uFog.x)) * uFog.y;\n  else if (uFog.z > 0.5) fog = clamp((dist - uFog.x) / max(uFog.y - uFog.x, 1.0), 0.0, 1.0);\n  else fog = smoothstep(900.0, 5000.0, dist) * 0.7;\n  col = mix(col, uFogColor, fog);\n  gl_FragColor = vec4(col, alpha);\n}";
    private static final String LIT_VS = "\nuniform mat4 uVP; uniform mat4 uModel; uniform mat3 uNrm; uniform mat4 uShadowVP;\n#ifdef BATCH\n// Static batches: vertices are already in world space and carry the part's look.\nattribute vec3 aPos; attribute vec4 aNrm; attribute vec2 aUv; attribute vec4 aCol; attribute vec4 aMat;\nvarying vec3 vN; varying vec3 vW; varying vec4 vS; varying vec3 vA; varying vec4 vCol; varying vec4 vMat;\n#ifdef TEXTURED\nattribute vec3 aTan; attribute vec3 aBit;\nvarying vec3 vT; varying vec3 vB;\n#endif\nvoid main() {\n  vW = aPos; vN = aNrm.xyz;\n  vS = uShadowVP * vec4(aPos, 1.0);\n  vA = vec3(aUv, floor(aNrm.w * 127.0 + 0.5));\n  vCol = aCol;\n  vMat = vec4(aMat.x, aMat.y / 1000.0, aMat.z / 50.0, aMat.w / 120.0);\n#ifdef TEXTURED\n  vT = aTan; vB = aBit;\n#endif\n  gl_Position = uVP * vec4(aPos, 1.0);\n}\n#else\nattribute vec3 aPos; attribute vec3 aNrm;\nvarying vec3 vN; varying vec3 vW; varying vec3 vL; varying vec3 vLN; varying vec4 vS;\n#ifdef TEXTURED\nvarying vec3 vT; varying vec3 vB;\n#endif\nvoid main() {\n  vec4 w = uModel * vec4(aPos, 1.0);\n  vW = w.xyz; vN = uNrm * aNrm; vL = aPos; vLN = aNrm;\n  vS = uShadowVP * w;\n#ifdef TEXTURED\n  // World directions of the face's texture axes (same box projection the fragment shader uses).\n  vec3 an = abs(aNrm);\n  bool yF = an.y > an.x && an.y > an.z; bool xF = !yF && an.x > an.z;\n  vT = (uModel * vec4(yF ? vec3(1.0, 0.0, 0.0) : (xF ? vec3(0.0, 0.0, 1.0) : vec3(1.0, 0.0, 0.0)), 0.0)).xyz;\n  vB = (uModel * vec4(yF ? vec3(0.0, 0.0, 1.0) : vec3(0.0, 1.0, 0.0), 0.0)).xyz;\n#endif\n  gl_Position = uVP * w;\n}\n#endif";
    private static final String MESH_FS = "\n#ifdef GL_FRAGMENT_PRECISION_HIGH\nprecision highp float;\n#else\nprecision mediump float;\n#endif\nvarying vec3 vN; varying vec3 vW; varying vec2 vUv; varying vec4 vS;\nuniform vec4 uColor; uniform vec3 uTint; uniform vec3 uLight; uniform vec3 uSun; uniform float uAmbient; uniform vec3 uCam;\nuniform sampler2D uTex; uniform float uHasTex; uniform sampler2D uShadow; uniform float uShadowOn; uniform vec2 uShadowTexel;\nuniform vec3 uFogColor; uniform vec3 uFog; uniform float uExposure; uniform float uEmissive; uniform vec3 uHorizon; uniform vec3 uZenith;\nfloat unpackDepth(vec4 c) { return dot(c, vec4(1.0, 1.0 / 255.0, 1.0 / 65025.0, 1.0 / 16581375.0)); }\nfloat shadowAt(float ndl) {\n  if (uShadowOn < 0.5 || ndl <= 0.0) return 1.0;\n  vec3 p = vS.xyz / vS.w * 0.5 + 0.5;\n  if (p.x <= 0.001 || p.x >= 0.999 || p.y <= 0.001 || p.y >= 0.999 || p.z >= 1.0) return 1.0;\n  float z = p.z - (0.0015 + 0.004 * (1.0 - ndl));\n  vec2 t = uShadowTexel;\n  float s = (z > unpackDepth(texture2D(uShadow, p.xy)) ? 0.0 : 2.0);\n  s += (z > unpackDepth(texture2D(uShadow, p.xy + vec2(t.x, t.y))) ? 0.0 : 1.0);\n  s += (z > unpackDepth(texture2D(uShadow, p.xy - vec2(t.x, t.y))) ? 0.0 : 1.0);\n  return s / 4.0;\n}\n#ifdef BATCH\nvarying vec4 vCol;\n#endif\nvoid main() {\n  vec3 n = normalize(vN);\n  if (!gl_FrontFacing) n = -n;\n#ifdef BATCH\n  vec3 c = vCol.rgb; float a = 1.0; float emis = vCol.a; vec3 tint = vec3(1.0);\n#else\n  vec3 c = uColor.rgb; float a = uColor.a; float emis = uEmissive; vec3 tint = uTint;\n#endif\n  if (uHasTex > 0.5) {\n    vec4 t = texture2D(uTex, vUv);\n    // Texture over the part color (where the texture is see-through the color shows).\n    c = mix(c, t.rgb / max(t.a, 0.001), t.a);\n  }\n  c *= tint;\n  vec3 col;\n  if (emis > 0.5) col = c * 1.15;\n  else {\n    float ndl = dot(n, uLight);\n    float sh = shadowAt(ndl);\n    vec3 sky = mix(uHorizon, uZenith, 0.5);\n    vec3 amb = uAmbient * mix(vec3(0.82), mix(vec3(1.0), sky * 1.2, 0.35), 0.5 + 0.5 * n.y);\n    col = c * (amb + uSun * max(ndl, 0.0) * sh);\n  }\n  col *= uExposure;\n  float dist = length(uCam - vW);\n  float fog;\n  if (uFog.z > 1.5) fog = (1.0 - exp(-dist * uFog.x)) * uFog.y;\n  else if (uFog.z > 0.5) fog = clamp((dist - uFog.x) / max(uFog.y - uFog.x, 1.0), 0.0, 1.0);\n  else fog = smoothstep(900.0, 5000.0, dist) * 0.7;\n  gl_FragColor = vec4(mix(col, uFogColor, fog), a);\n}";
    private static final String MESH_VS = "\nuniform mat4 uVP; uniform mat4 uModel; uniform mat3 uNrm; uniform mat4 uShadowVP;\nvarying vec3 vN; varying vec3 vW; varying vec2 vUv; varying vec4 vS;\n#ifdef BATCH\nattribute vec3 aPos; attribute vec4 aNrm; attribute vec2 aUv; attribute vec4 aCol;\nvarying vec4 vCol;\nvoid main() {\n  vW = aPos; vN = aNrm.xyz; vUv = aUv; vS = uShadowVP * vec4(aPos, 1.0); vCol = aCol;\n  gl_Position = uVP * vec4(aPos, 1.0);\n}\n#else\nattribute vec3 aPos; attribute vec3 aNrm; attribute vec2 aUv;\nvoid main() {\n  vec4 w = uModel * vec4(aPos, 1.0);\n  vW = w.xyz; vN = uNrm * aNrm; vUv = aUv; vS = uShadowVP * w;\n  gl_Position = uVP * w;\n}\n#endif";
    private static final String PRECISION = "\n#ifdef GL_FRAGMENT_PRECISION_HIGH\nprecision highp float;\n#else\nprecision mediump float;\n#endif\n";
    private static final String SKYBOX_FS = "\nprecision mediump float;\nvarying vec2 vUv; uniform sampler2D uTex; uniform vec3 uTint;\nvoid main() { gl_FragColor = vec4(texture2D(uTex, vUv).rgb * uTint, 1.0); }";
    private static final String SKYBOX_VS = "\nuniform mat4 uVP; uniform vec3 uCam; uniform mat3 uRot;\nattribute vec3 aPos; attribute vec2 aUv; varying vec2 vUv;\nvoid main() {\n  vUv = aUv;\n  vec4 p = uVP * vec4(uCam + uRot * aPos * 400.0, 1.0);\n  gl_Position = vec4(p.xy, p.w * 0.9999, p.w);\n}";
    private static final String SKY_FS = "\n#ifdef GL_FRAGMENT_PRECISION_HIGH\nprecision highp float;\n#else\nprecision mediump float;\n#endif\n\nvarying vec2 vNdc;\nuniform mat4 uInvVP; uniform vec3 uCam; uniform vec3 uSunDir; uniform vec3 uZenith; uniform vec3 uHorizon;\nuniform vec3 uSunColor; uniform float uTime; uniform float uDay;\nfloat hash(vec2 p) { return fract(sin(dot(p, vec2(127.1, 311.7))) * 43758.5453); }\nfloat noise(vec2 p) {\n  vec2 i = floor(p); vec2 f = fract(p); f = f * f * (3.0 - 2.0 * f);\n  return mix(mix(hash(i), hash(i + vec2(1.0, 0.0)), f.x), mix(hash(i + vec2(0.0, 1.0)), hash(i + vec2(1.0, 1.0)), f.x), f.y);\n}\nfloat fbm(vec2 p) { float v = 0.0; float a = 0.5; for (int i = 0; i < 5; i++) { v += noise(p) * a; p = p * 2.02 + 3.7; a *= 0.5; } return v; }\nvoid main() {\n  vec4 far = uInvVP * vec4(vNdc, 1.0, 1.0);\n  vec3 dir = normalize(far.xyz / far.w - uCam);\n  float y = dir.y;\n  vec3 col = mix(uHorizon, uZenith, pow(clamp(y, 0.0, 1.0), 0.55));\n  if (y < 0.0) col = mix(uHorizon, uHorizon * 0.8, clamp(-y * 3.0, 0.0, 1.0));\n  float sd = max(dot(dir, uSunDir), 0.0);\n  col += uSunColor * (pow(sd, 900.0) * 3.0 + pow(sd, 60.0) * 0.18 + pow(sd, 6.0) * 0.08) * uDay;\n  if (y > 0.0) {\n    vec2 uv = dir.xz / (y + 0.12) * 1.6 + vec2(uTime * 0.004, uTime * 0.002);\n    float cl = smoothstep(0.52, 0.78, fbm(uv));\n    float fade = smoothstep(0.0, 0.25, y);\n    vec3 cloudCol = mix(vec3(0.55, 0.6, 0.7), vec3(1.0), 0.35 + 0.65 * uDay);\n    col = mix(col, cloudCol * (0.85 + 0.15 * sd), cl * fade * 0.85 * (0.3 + 0.7 * uDay));\n  }\n  if (uDay < 0.5 && y > 0.0) {\n    float st = step(0.997, hash(floor(dir.xz / (y + 0.3) * 300.0)));\n    col += vec3(st) * (1.0 - uDay * 2.0) * smoothstep(0.0, 0.3, y);\n  }\n  gl_FragColor = vec4(col, 1.0);\n}";
    private static final String SKY_VS = "\nattribute vec2 aPos; varying vec2 vNdc;\nvoid main() { vNdc = aPos; gl_Position = vec4(aPos, 0.9999, 1.0); }";
    private final Set<String> BATCH_CLASSES;
    private final float[] FLOAT4_ZERO;
    private final String[] SKY_FACES;
    private final String[] SURFACES;
    private final float TH;
    private final float TW;
    private int aBit;
    private int aCol;
    private int aMatB;
    private int aNrm;
    private int aPos;
    private int aTan;
    private int aUvB;
    private LitLocs activeLit;
    private float ambient;
    private float aniso;
    private final LitLocs[] batchLit;
    private final StaticBatches batches;
    private Mesh boxLines;
    private int cAmbient;
    private int cLight;
    private int cModel;
    private int cNormal;
    private int cSun;
    private int cTex;
    private int cTint;
    private int cUv;
    private int cVP;
    private int caPos;
    private int caUv;
    private int canDownloadFrame;
    private boolean canDownloadNow;
    private float closest;
    private Mesh corner;
    private float cpuAcc;
    private int cpuN;
    private Mesh cube;
    private Mesh cylinder;
    private Mesh cylinderY;
    private int dModel;
    private int dVP;
    private int daPos;
    private float dayFactor;
    private int decalProg;
    private int depthProg;
    private float detailScale;
    private float exposure;
    private int faceTex;
    private final float[] fogColor;
    private float fogEnd;
    private float fogMode;
    private float fogStart;
    private volatile float fps;
    private float fpsAcc;
    private int fpsFrames;
    private boolean frameShadows;
    private int frames;
    private final Frustum frustum;
    private final HashMap<Long, GpuMesh> gpuMeshes;
    private int gridTex;
    private Mesh head;
    private Mesh headFace;
    private final float[] horizon;
    private int kCam;
    private int kRot;
    private int kTex;
    private int kTint;
    private int kVP;
    private int kaPos;
    private int kaUv;
    private int lColor;
    private int lModel;
    private int lVP;
    private int laPos;
    private final float[] lastLightVP;
    private Object lastModel;
    private long lastNs;
    private long lastShadowChange;
    private int lastShadowMeshEpoch;
    private final Map<Integer, Region> leftLimbRegions;
    private final float[] lightProj;
    private final float[] lightVP;
    private final float[] lightView;
    private int line;
    private int lit;
    private LitLocs litAdv;
    private LitLocs litBasic;
    private LitLocs litTex;
    private int mAmbient;
    private int mCam;
    private int mColor;
    private int mEmissive;
    private int mExposure;
    private int mFog;
    private int mFogColor;
    private int mHasTex;
    private int mHorizon;
    private int mLight;
    private int mModel;
    private int mNrm;
    private int mShadow;
    private int mShadowOn;
    private int mShadowTexel;
    private int mShadowVP;
    private int mSun;
    private int mTex;
    private int mTint;
    private int mVP;
    private int mZenith;
    private int maNrm;
    private int maPos;
    private int maUv;
    private final HashMap<Integer, float[]> matCache;
    private final IdentityHashMap<MaterialTextures.MatTex, TexBind> matTexGpu;
    private final HashMap<String, Integer> mb;
    private int meshBatchProg;
    private int meshEpoch;
    private int meshFrame;
    private int meshProg;
    private final float[] model;
    private boolean modernMaterialsNow;
    private int nLoose;
    private int nSgRender;
    private int nTr;
    private float nearPlane;
    private IdentityHashMap<Instance, String> nextOverride;
    private boolean noBatch;
    private final float[] normal;
    private Function0<Unit> onFrame;
    private volatile Map<Instance, String> partTexOverride;
    private Mesh quad;
    private volatile float quality;
    private float qualityTimer;
    private final ConcurrentHashMap.KeySetView<String, Boolean> r15Pending;
    private final ExecutorService r15Pool;
    private final ConcurrentHashMap<String, Map<String, String>> r15Tex;
    private final HashMap<Long, String> rawKeys;
    private final HashMap<Long, String> rawKeysR;
    private final HashMap<String, String> repeatKeys;
    private final Map<Integer, Region> rightLimbRegions;
    private int sCam;
    private int sDay;
    private int sHorizon;
    private int sInvVP;
    private int sSun;
    private int sSunColor;
    private int sTime;
    private int sZenith;
    private int saPos;
    private Bitmap scratch;
    private Mesh screen;
    private int shadowAge;
    private int shadowFbo;
    private boolean shadowOk;
    private int shadowSize;
    private int shadowTex;
    private boolean shadowValid;
    private boolean shadowsOn;
    private int skyProg;
    private Mesh skyboxMesh;
    private int skyboxProg;
    private float slowAvg;
    private Mesh sphere;
    private float statTimer;
    private final HashMap<String, List<Pair<Mesh, Integer>>> storedUnionGpu;
    private final Studio studio;
    private final float[] sunColor;
    private Vector3 sunDir;
    private int surfH;
    private int surfTex;
    private int surfW;
    private Function4<? super Instance, ? super Float, ? super Float, ? super Bitmap, Unit> surfacePainter;
    private final IdentityHashMap<Instance, SurfaceTex> surfaceTex;
    private float tB;
    private float tClo;
    private float tDec;
    private float tDraw;
    private float tL;
    private float tSg;
    private float tShadow;
    private float tSim;
    private float tTr;
    private float tUpd;
    private final HashMap<String, Integer> textures;
    private float time;
    private final Map<Integer, Region> torsoRegions;
    private int uAmbient;
    private int uCam;
    private int uColor;
    private int uEmissive;
    private int uExposure;
    private int uFog;
    private int uFogColor;
    private int uGrid;
    private int uHasNrm;
    private int uHasSurfTex;
    private int uHorizon;
    private int uLight;
    private int uMat;
    private int uMatNrm;
    private int uMatTex;
    private int uModel;
    private int uNrm;
    private int uShadow;
    private int uShadowOn;
    private int uShadowTexel;
    private int uShadowVP;
    private int uSize;
    private int uSun;
    private int uSurfA;
    private int uSurfB;
    private int uSurfTex;
    private int uTexScale;
    private int uTime;
    private int uTruss;
    private int uVP;
    private int uZenith;
    private final IdentityHashMap<Instance, UnionGpu> unionGpu;
    private final IdentityHashMap<Instance, TexBind> variantBinds;
    private Map<String, ? extends List<? extends Instance>> variantIndex;
    private long variantIndexAt;
    private Instance variantService;
    private Mesh wedge;
    private int whiteTexId;
    private final float[] zenith;
    private static final Color3 NEGATE_COLOR = new Color3(0.93f, 0.33f, 0.45f);
    private static final String[] SIG_PROPS = {"Text", "Visible", "BackgroundColor3", "BackgroundTransparency", "TextColor3", "Image", "Size", "Position", "TextTransparency", "ImageTransparency", "Enabled"};

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SceneRenderer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/SceneRenderer$Draw;", "", "part", "Lcom/exampletest/mobilestudiotest/model/Instance;", "dist", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;F)V", "getPart", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getDist", "()F", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Draw {
        private final float dist;
        private final Instance part;

        public Draw(Instance part, float f) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.part = part;
            this.dist = f;
        }

        public final float getDist() {
            return this.dist;
        }

        public final Instance getPart() {
            return this.part;
        }
    }

    /* compiled from: SceneRenderer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/SceneRenderer$FaceQuad;", "", "local", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "w", "", "h", "normal", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "<init>", "(Lcom/exampletest/mobilestudiotest/model/CFrame;FFLcom/exampletest/mobilestudiotest/model/Vector3;)V", "getLocal", "()Lcom/exampletest/mobilestudiotest/model/CFrame;", "getW", "()F", "getH", "getNormal", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class FaceQuad {
        private final float h;
        private final CFrame local;
        private final Vector3 normal;
        private final float w;

        public FaceQuad(CFrame local, float f, float f2, Vector3 normal) {
            Intrinsics.checkNotNullParameter(local, "local");
            Intrinsics.checkNotNullParameter(normal, "normal");
            this.local = local;
            this.w = f;
            this.h = f2;
            this.normal = normal;
        }

        public final float getH() {
            return this.h;
        }

        public final CFrame getLocal() {
            return this.local;
        }

        public final Vector3 getNormal() {
            return this.normal;
        }

        public final float getW() {
            return this.w;
        }
    }

    /* compiled from: SceneRenderer.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR%\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018¨\u0006 "}, d2 = {"Lcom/exampletest/mobilestudiotest/render/SceneRenderer$Geo;", "", "mesh", "Lcom/exampletest/mobilestudiotest/render/Mesh;", "cf", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "scale", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "kind", "", "tex", "", "subs", "", "Lkotlin/Pair;", "Lcom/exampletest/mobilestudiotest/model/Color3;", "tint", "<init>", "(Lcom/exampletest/mobilestudiotest/render/Mesh;Lcom/exampletest/mobilestudiotest/model/CFrame;Lcom/exampletest/mobilestudiotest/model/Vector3;ILjava/lang/String;Ljava/util/List;Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "getMesh", "()Lcom/exampletest/mobilestudiotest/render/Mesh;", "getCf", "()Lcom/exampletest/mobilestudiotest/model/CFrame;", "getScale", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getKind", "()I", "getTex", "()Ljava/lang/String;", "getSubs", "()Ljava/util/List;", "getTint", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class Geo {
        private final CFrame cf;
        private final int kind;
        private final Mesh mesh;
        private final Vector3 scale;
        private final List<Pair<Mesh, Color3>> subs;
        private final String tex;
        private final Vector3 tint;

        public Geo(Mesh mesh, CFrame cf, Vector3 scale, int i, String str, List<Pair<Mesh, Color3>> list, Vector3 vector3) {
            Intrinsics.checkNotNullParameter(mesh, "mesh");
            Intrinsics.checkNotNullParameter(cf, "cf");
            Intrinsics.checkNotNullParameter(scale, "scale");
            this.mesh = mesh;
            this.cf = cf;
            this.scale = scale;
            this.kind = i;
            this.tex = str;
            this.subs = list;
            this.tint = vector3;
        }

        public /* synthetic */ Geo(Mesh mesh, CFrame cFrame, Vector3 vector3, int i, String str, List list, Vector3 vector32, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(mesh, cFrame, vector3, i, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? null : list, (i2 & 64) != 0 ? null : vector32);
        }

        public final CFrame getCf() {
            return this.cf;
        }

        public final int getKind() {
            return this.kind;
        }

        public final Mesh getMesh() {
            return this.mesh;
        }

        public final Vector3 getScale() {
            return this.scale;
        }

        public final List<Pair<Mesh, Color3>> getSubs() {
            return this.subs;
        }

        public final String getTex() {
            return this.tex;
        }

        public final Vector3 getTint() {
            return this.tint;
        }
    }

    /* compiled from: SceneRenderer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/SceneRenderer$GpuMesh;", "", "mesh", "Lcom/exampletest/mobilestudiotest/render/Mesh;", "center", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "size", "<init>", "(Lcom/exampletest/mobilestudiotest/render/Mesh;Lcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "getMesh", "()Lcom/exampletest/mobilestudiotest/render/Mesh;", "getCenter", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getSize", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class GpuMesh {
        private final Vector3 center;
        private final Mesh mesh;
        private final Vector3 size;

        public GpuMesh(Mesh mesh, Vector3 center, Vector3 size) {
            Intrinsics.checkNotNullParameter(mesh, "mesh");
            Intrinsics.checkNotNullParameter(center, "center");
            Intrinsics.checkNotNullParameter(size, "size");
            this.mesh = mesh;
            this.center = center;
            this.size = size;
        }

        public final Vector3 getCenter() {
            return this.center;
        }

        public final Mesh getMesh() {
            return this.mesh;
        }

        public final Vector3 getSize() {
            return this.size;
        }
    }

    /* compiled from: SceneRenderer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/SceneRenderer$LitLocs;", "", "prog", "", "locs", "", "<init>", "(I[I)V", "getProg", "()I", "getLocs", "()[I", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class LitLocs {
        private final int[] locs;
        private final int prog;

        public LitLocs(int i, int[] locs) {
            Intrinsics.checkNotNullParameter(locs, "locs");
            this.prog = i;
            this.locs = locs;
        }

        public final int[] getLocs() {
            return this.locs;
        }

        public final int getProg() {
            return this.prog;
        }
    }

    /* compiled from: SceneRenderer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/SceneRenderer$Region;", "", "x", "", "y", "w", "h", "flip", "", "<init>", "(FFFFZ)V", "getX", "()F", "getY", "getW", "getH", "getFlip", "()Z", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class Region {
        private final boolean flip;
        private final float h;
        private final float w;
        private final float x;
        private final float y;

        public Region(float f, float f2, float f3, float f4, boolean z) {
            this.x = f;
            this.y = f2;
            this.w = f3;
            this.h = f4;
            this.flip = z;
        }

        public /* synthetic */ Region(float f, float f2, float f3, float f4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, f3, f4, (i & 16) != 0 ? false : z);
        }

        public final boolean getFlip() {
            return this.flip;
        }

        public final float getH() {
            return this.h;
        }

        public final float getW() {
            return this.w;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }
    }

    /* compiled from: SceneRenderer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/SceneRenderer$SurfaceTex;", "", "tex", "", "w", "h", "sig", "", "checked", "", "used", "<init>", "(IIIJFF)V", "getTex", "()I", "setTex", "(I)V", "getW", "setW", "getH", "setH", "getSig", "()J", "setSig", "(J)V", "getChecked", "()F", "setChecked", "(F)V", "getUsed", "setUsed", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class SurfaceTex {
        private float checked;
        private int h;
        private long sig;
        private int tex;
        private float used;
        private int w;

        public SurfaceTex(int i, int i2, int i3, long j, float f, float f2) {
            this.tex = i;
            this.w = i2;
            this.h = i3;
            this.sig = j;
            this.checked = f;
            this.used = f2;
        }

        public final float getChecked() {
            return this.checked;
        }

        public final int getH() {
            return this.h;
        }

        public final long getSig() {
            return this.sig;
        }

        public final int getTex() {
            return this.tex;
        }

        public final float getUsed() {
            return this.used;
        }

        public final int getW() {
            return this.w;
        }

        public final void setChecked(float f) {
            this.checked = f;
        }

        public final void setH(int i) {
            this.h = i;
        }

        public final void setSig(long j) {
            this.sig = j;
        }

        public final void setTex(int i) {
            this.tex = i;
        }

        public final void setUsed(float f) {
            this.used = f;
        }

        public final void setW(int i) {
            this.w = i;
        }
    }

    /* compiled from: SceneRenderer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR#\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/SceneRenderer$UnionGpu;", "", "sig", "", "meshes", "", "Lkotlin/Pair;", "Lcom/exampletest/mobilestudiotest/render/Mesh;", "", "styles", "Lcom/exampletest/mobilestudiotest/core/SolidModeling$Style;", "<init>", "(JLjava/util/List;Ljava/util/List;)V", "getSig", "()J", "getMeshes", "()Ljava/util/List;", "getStyles", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    private static final class UnionGpu {
        private final List<Pair<Mesh, Integer>> meshes;
        private final long sig;
        private final List<SolidModeling.Style> styles;

        public UnionGpu(long j, List<Pair<Mesh, Integer>> meshes, List<SolidModeling.Style> styles) {
            Intrinsics.checkNotNullParameter(meshes, "meshes");
            Intrinsics.checkNotNullParameter(styles, "styles");
            this.sig = j;
            this.meshes = meshes;
            this.styles = styles;
        }

        public final List<Pair<Mesh, Integer>> getMeshes() {
            return this.meshes;
        }

        public final long getSig() {
            return this.sig;
        }

        public final List<SolidModeling.Style> getStyles() {
            return this.styles;
        }
    }

    public SceneRenderer(Studio studio) {
        Intrinsics.checkNotNullParameter(studio, "studio");
        this.studio = studio;
        this.model = new float[16];
        this.normal = new float[9];
        this.sunDir = new Vector3(0.45f, 0.8f, 0.35f).getUnit();
        this.zenith = new float[3];
        this.horizon = new float[3];
        this.sunColor = new float[3];
        this.fogColor = new float[3];
        this.fogEnd = 1.0E9f;
        this.ambient = 0.55f;
        this.exposure = 1.0f;
        this.shadowsOn = true;
        this.dayFactor = 1.0f;
        this.shadowSize = 2048;
        this.lightVP = new float[16];
        this.lightView = new float[16];
        this.lightProj = new float[16];
        this.textures = new HashMap<>();
        this.surfaceTex = new IdentityHashMap<>();
        this.matCache = new HashMap<>();
        this.uMatTex = -1;
        this.uMatNrm = -1;
        this.uTexScale = -1;
        this.uHasNrm = -1;
        this.uSurfTex = -1;
        this.uHasSurfTex = -1;
        this.aUvB = -1;
        this.aCol = -1;
        this.aMatB = -1;
        this.aTan = -1;
        this.aBit = -1;
        this.batchLit = new LitLocs[3];
        this.frustum = new Frustum();
        this.detailScale = 400.0f;
        this.quality = 1.0f;
        this.closest = 1.0f;
        this.nearPlane = 0.3f;
        this.batches = new StaticBatches(new SceneRenderer$batches$1(this));
        this.BATCH_CLASSES = SetsKt.setOf((Object[]) new String[]{"Part", "WedgePart", "CornerWedgePart", "SpawnLocation", "Seat", "VehicleSeat", "Platform", "SkateboardPlatform", "MeshPart", "UnionOperation", "IntersectOperation"});
        this.SURFACES = new String[]{"TopSurface", "BottomSurface", "FrontSurface", "BackSurface", "LeftSurface", "RightSurface"};
        this.FLOAT4_ZERO = new float[]{0.0f, 0.0f, 1.0f, 0.0f};
        this.mb = new HashMap<>();
        this.matTexGpu = new IdentityHashMap<>();
        this.modernMaterialsNow = true;
        this.variantBinds = new IdentityHashMap<>();
        this.surfW = 1;
        this.surfH = 1;
        this.gpuMeshes = new HashMap<>();
        this.meshEpoch = -1;
        this.unionGpu = new IdentityHashMap<>();
        this.storedUnionGpu = new HashMap<>();
        this.lastLightVP = new float[16];
        this.lastShadowChange = -1L;
        this.lastShadowMeshEpoch = -1;
        this.SKY_FACES = new String[]{"SkyboxFt", "SkyboxBk", "SkyboxRt", "SkyboxLf", "SkyboxUp", "SkyboxDn"};
        this.meshFrame = -1;
        this.rawKeys = new HashMap<>();
        this.rawKeysR = new HashMap<>();
        this.canDownloadFrame = -1;
        this.repeatKeys = new HashMap<>();
        this.TW = 585.0f;
        this.TH = 559.0f;
        this.torsoRegions = MapsKt.mapOf(TuplesKt.to(5, new Region(231.0f, 74.0f, 128.0f, 128.0f, false, 16, null)), TuplesKt.to(2, new Region(427.0f, 74.0f, 128.0f, 128.0f, false, 16, null)), TuplesKt.to(0, new Region(165.0f, 74.0f, 64.0f, 128.0f, false, 16, null)), TuplesKt.to(3, new Region(361.0f, 74.0f, 64.0f, 128.0f, false, 16, null)), TuplesKt.to(1, new Region(231.0f, 8.0f, 128.0f, 64.0f, true)), TuplesKt.to(4, new Region(231.0f, 204.0f, 128.0f, 64.0f, true)));
        this.rightLimbRegions = MapsKt.mapOf(TuplesKt.to(5, new Region(217.0f, 355.0f, 64.0f, 128.0f, false, 16, null)), TuplesKt.to(0, new Region(151.0f, 355.0f, 64.0f, 128.0f, false, 16, null)), TuplesKt.to(2, new Region(85.0f, 355.0f, 64.0f, 128.0f, false, 16, null)), TuplesKt.to(3, new Region(19.0f, 355.0f, 64.0f, 128.0f, false, 16, null)), TuplesKt.to(1, new Region(217.0f, 289.0f, 64.0f, 64.0f, true)), TuplesKt.to(4, new Region(217.0f, 485.0f, 64.0f, 64.0f, true)));
        this.leftLimbRegions = MapsKt.mapOf(TuplesKt.to(5, new Region(308.0f, 355.0f, 64.0f, 128.0f, false, 16, null)), TuplesKt.to(3, new Region(374.0f, 355.0f, 64.0f, 128.0f, false, 16, null)), TuplesKt.to(2, new Region(440.0f, 355.0f, 64.0f, 128.0f, false, 16, null)), TuplesKt.to(0, new Region(506.0f, 355.0f, 64.0f, 128.0f, false, 16, null)), TuplesKt.to(1, new Region(308.0f, 289.0f, 64.0f, 64.0f, true)), TuplesKt.to(4, new Region(308.0f, 485.0f, 64.0f, 64.0f, true)));
        this.r15Tex = new ConcurrentHashMap<>();
        this.r15Pending = ConcurrentHashMap.newKeySet();
        this.r15Pool = Executors.newSingleThreadExecutor();
        this.partTexOverride = MapsKt.emptyMap();
        this.nextOverride = new IdentityHashMap<>();
        this.variantIndex = MapsKt.emptyMap();
    }

    public static final /* synthetic */ List access$batchSpec(SceneRenderer sceneRenderer, Instance instance) {
        return sceneRenderer.batchSpec(instance);
    }

    public static final /* synthetic */ boolean access$isBatchable(SceneRenderer sceneRenderer, Instance instance) {
        return sceneRenderer.isBatchable(instance);
    }

    private final List<Instance> adorneeParts(Instance a) {
        Object obj = a.get("Adornee");
        Instance instance = obj instanceof Instance ? (Instance) obj : null;
        if (instance == null) {
            instance = Intrinsics.areEqual(a.getClassName(), "Highlight") ? a.getParent() : null;
        }
        if (instance == null) {
            return CollectionsKt.emptyList();
        }
        if (instance.isA("BasePart")) {
            return CollectionsKt.listOf(instance);
        }
        if (!instance.isA("Model") && !Intrinsics.areEqual(instance.getClassName(), "Folder")) {
            return CollectionsKt.emptyList();
        }
        List descendants$default = Instance.descendants$default(instance, null, 1, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : descendants$default) {
            Instance instance2 = (Instance) obj2;
            boolean z = false;
            if (instance2.isA("BasePart")) {
                Instance parent = instance2.getParent();
                if (!(parent != null && parent.isA("PartOperation"))) {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    private final LitLocs advancedLit() {
        LitLocs litLocs = this.litAdv;
        if (litLocs != null) {
            return litLocs;
        }
        if (this.frames < 30) {
            return null;
        }
        LitLocs litLocs2 = litLocs(program(LIT_VS, "#define ADVANCED 1\n\n#ifdef GL_FRAGMENT_PRECISION_HIGH\nprecision highp float;\n#else\nprecision mediump float;\n#endif\n\n#ifdef BATCH\nvarying vec3 vN; varying vec3 vW; varying vec4 vS; varying vec3 vA; varying vec4 vCol; varying vec4 vMat;\n#else\nvarying vec3 vN; varying vec3 vW; varying vec3 vL; varying vec3 vLN; varying vec4 vS;\n#endif\nuniform vec4 uColor; uniform vec3 uLight; uniform vec3 uCam; uniform float uEmissive;\nuniform float uGrid; uniform vec3 uSize; uniform vec3 uHorizon; uniform vec3 uZenith; uniform vec3 uSun;\nuniform float uAmbient; uniform vec3 uFogColor; uniform vec3 uFog; uniform vec4 uMat; uniform vec3 uSurfA; uniform vec3 uSurfB;\nuniform sampler2D uShadow; uniform float uShadowOn; uniform vec2 uShadowTexel; uniform float uExposure; uniform float uTime; uniform float uTruss;\nuniform sampler2D uSurfTex; uniform float uHasSurfTex;\n#ifdef TEXTURED\nvarying vec3 vT; varying vec3 vB;\nuniform sampler2D uMatTex; uniform sampler2D uMatNrm; uniform float uTexScale; uniform float uHasNrm;\n#endif\n\nfloat hash(vec2 p) { return fract(sin(dot(p, vec2(127.1, 311.7))) * 43758.5453); }\nvec2 hash2(vec2 p) { return fract(sin(vec2(dot(p, vec2(127.1, 311.7)), dot(p, vec2(269.5, 183.3)))) * 43758.5453); }\nfloat noise(vec2 p) {\n  vec2 i = floor(p); vec2 f = fract(p); f = f * f * (3.0 - 2.0 * f);\n  return mix(mix(hash(i), hash(i + vec2(1.0, 0.0)), f.x), mix(hash(i + vec2(0.0, 1.0)), hash(i + vec2(1.0, 1.0)), f.x), f.y);\n}\nfloat fbm(vec2 p) { return noise(p) * 0.5 + noise(p * 2.03 + 7.1) * 0.3 + noise(p * 4.1 + 3.3) * 0.2; }\n#ifdef ADVANCED\n// Cellular noise: x = distance to the nearest cell point, y = distance to the cell edge (approx).\nvec3 voro(vec2 x) {\n  vec2 n = floor(x); vec2 f = fract(x);\n  float d1 = 8.0; float d2 = 8.0; vec2 id = n;\n  for (int j = -1; j <= 1; j++) for (int i = -1; i <= 1; i++) {\n    vec2 g = vec2(float(i), float(j));\n    vec2 r = g + hash2(n + g) - f;\n    float d = dot(r, r);\n    if (d < d1) { d2 = d1; d1 = d; id = n + g; } else if (d < d2) { d2 = d; }\n  }\n  return vec3(sqrt(d1), sqrt(d2) - sqrt(d1), hash(id));\n}\n#endif\n// Roblox surface types on one face (sp = stud coordinates on the face, fsz = face size).\n// Roblox's stud look: a raised disc lit from the upper left with a soft shadow to the lower right.\nfloat studShade(vec2 f, float R) {\n  vec2 L = vec2(-0.62, 0.78);\n  float r = length(f);\n  float inside = smoothstep(R + 0.012, R - 0.012, r);\n  float rim = smoothstep(R - 0.09, R, r) * inside;\n  float side = dot(f / max(r, 0.001), L);\n  float shadow = smoothstep(R + 0.1, R, length(f + L * 0.05)) * (1.0 - inside);\n  return 1.0 + inside * 0.05 + rim * side * 0.22 - shadow * 0.2;\n}\nvec3 surface(vec3 c, float s, vec2 sp, vec2 fsz) {\n  if (s < 0.5 || s > 9.5) return c;\n  if (uHasSurfTex > 0.5 && s < 5.5) {\n    // Roblox's own surface textures: one 2x8-stud tile per type, shaded around grey 128\n    // (R = studs, G = weld/glue, B = inlet). Sampled with repeat (no fract) so mipmapping\n    // never sees a seam. s is the same for a whole face, so this branch is uniform per triangle.\n    vec2 st = vec2(sp.x * 0.5, -sp.y * 0.125);\n    vec3 t = texture2D(uSurfTex, st).rgb;\n    float k;\n    if (s < 2.5) k = t.g;\n    else if (s < 3.5) k = t.r;\n    else if (s < 4.5) k = t.b;\n    else { vec2 cell = floor(fract(st) * vec2(2.0, 8.0)); k = mod(cell.x + cell.y, 2.0) < 0.5 ? t.r : t.b; }\n    return c * (k * 2.0);\n  }\n  vec2 f = fract(sp) - 0.5; float r = length(f);\n  if (s > 2.5 && s < 3.5) { // Studs\n    c *= studShade(f, 0.29);\n  } else if (s > 3.5 && s < 4.5) { // Inlet: a sunken hole, shaded the opposite way\n    vec2 L = vec2(-0.62, 0.78);\n    float inside = smoothstep(0.302, 0.278, r);\n    float rim = smoothstep(0.2, 0.29, r) * inside;\n    c *= 1.0 - inside * 0.16 - rim * dot(f / max(r, 0.001), L) * 0.2 + smoothstep(0.36, 0.3, r) * (1.0 - inside) * 0.05;\n  } else if (s > 4.5 && s < 5.5) { // Universal: a stud with a hole in it\n    c *= studShade(f, 0.29) * (1.0 - smoothstep(0.14, 0.12, r) * 0.18);\n  } else if (s > 1.5 && s < 2.5) { // Weld: diagonal hatching\n    float l = fract((sp.x + sp.y) * 1.25);\n    c *= mix(1.0, 0.84, smoothstep(0.82, 0.88, l) * smoothstep(1.0, 0.94, l));\n  } else if (s > 0.5 && s < 1.5) { // Glue: grid of small crosses\n    vec2 g = abs(fract(sp * 2.0) - 0.5);\n    float cr = max(step(g.x, 0.05) * step(g.y, 0.22), step(g.y, 0.05) * step(g.x, 0.22));\n    c *= 1.0 - 0.14 * cr;\n  } else { // Hinge / Motor / SteppingMotor: a yellow joint in the middle of the face\n    float rr = length(sp - fsz * 0.5);\n    vec3 yellow = vec3(0.96, 0.8, 0.16);\n    if (s > 6.5) {\n      if (rr < 0.75) c = mix(c, vec3(0.45, 0.45, 0.47), smoothstep(0.75, 0.7, rr));\n      if (s > 7.5 && rr < 0.75 && rr > 0.5) { float a = atan(sp.y - fsz.y * 0.5, sp.x - fsz.x * 0.5); c *= 0.75 + 0.25 * step(0.5, fract(a * 1.273)); }\n    }\n    if (rr < 0.45) c = mix(c, yellow, smoothstep(0.45, 0.4, rr));\n  }\n  return c;\n}\nfloat unpackDepth(vec4 c) { return dot(c, vec4(1.0, 1.0 / 255.0, 1.0 / 65025.0, 1.0 / 16581375.0)); }\nfloat sampleShadow(vec2 uv, float z) { return z > unpackDepth(texture2D(uShadow, uv)) ? 0.0 : 1.0; }\nfloat shadowAt(float ndl) {\n  if (uShadowOn < 0.5 || ndl <= 0.0) return 1.0;\n  vec3 p = vS.xyz / vS.w * 0.5 + 0.5;\n  if (p.x <= 0.001 || p.x >= 0.999 || p.y <= 0.001 || p.y >= 0.999 || p.z >= 1.0) return 1.0;\n  float z = p.z - (0.0012 + 0.0035 * (1.0 - ndl));\n  vec2 t = uShadowTexel;\n  float s = sampleShadow(p.xy, z) * 2.0;\n  s += sampleShadow(p.xy + vec2(-t.x, -t.y), z);\n  s += sampleShadow(p.xy + vec2(t.x, -t.y), z);\n  s += sampleShadow(p.xy + vec2(-t.x, t.y), z);\n  s += sampleShadow(p.xy + vec2(t.x, t.y), z);\n  s /= 6.0;\n  vec2 e = min(p.xy, 1.0 - p.xy);\n  float fade = clamp(min(e.x, e.y) * 12.0, 0.0, 1.0);\n  return mix(1.0, s, fade);\n}\nvoid main() {\n  vec3 n = normalize(vN);\n  if (!gl_FrontFacing) n = -n;\n#ifdef BATCH\n  vec3 c = vCol.rgb; vec4 mat = vMat; float emis = vCol.a; float alpha = 1.0;\n  vec2 uv = vA.xy; vec2 fsz = vec2(1.0); float sf = vA.z;\n#else\n  vec3 c = uColor.rgb; vec4 mat = uMat; float emis = uEmissive; float alpha = uColor.a;\n  vec3 a = abs(vLN);\n  vec3 p = vL * uSize + uSize * 0.5;\n  bool yFace = a.y > a.x && a.y > a.z; bool xFace = !yFace && a.x > a.z;\n  vec2 uv = yFace ? p.xz : (xFace ? p.zy : p.xy);\n  vec2 fsz = yFace ? uSize.xz : (xFace ? uSize.zy : uSize.xy);\n  // Surface types (studs, inlets, welds, hinges...) on whichever face this is.\n  float sf = yFace ? (vLN.y > 0.0 ? uSurfA.y : uSurfB.y) : (xFace ? (vLN.x > 0.0 ? uSurfA.x : uSurfB.x) : (vLN.z > 0.0 ? uSurfA.z : uSurfB.z));\n  if (uTruss > 0.5) {\n    // Lattice: frame and diagonals per 2-stud cell; everything else is see-through.\n    vec2 cell = fract(uv / 2.0);\n    float e = min(min(cell.x, cell.y), min(1.0 - cell.x, 1.0 - cell.y));\n    float dg = min(abs(cell.x - cell.y), abs(cell.x + cell.y - 1.0));\n    if (e > 0.11 && dg > 0.07) discard;\n  }\n#endif\n  vec3 glow = vec3(0.0);\n  float type = mat.x;\n#ifdef TEXTURED\n  // Roblox material textures: the color map tints the part color; the normal map bends the light.\n  vec2 tuv = vec2(uv.x, -uv.y) * uTexScale;\n  c *= texture2D(uMatTex, tuv).rgb * 1.08;\n  if (uHasNrm > 0.5) {\n    vec3 tn = texture2D(uMatNrm, tuv).xyz * 2.0 - 1.0;\n    n = normalize(normalize(vT) * tn.x + normalize(vB) * tn.y + n * max(tn.z, 0.25));\n  }\n  type = 0.0;\n#endif\n  if (type > 0.5) {\n    float amt = mat.y; float sc = mat.z;\n#ifdef ADVANCED\n    if (type > 10.5) {\n      if (type < 11.5) { // Marble veins\n        float v = abs(sin((uv.x * 0.6 + uv.y * 0.25 + fbm(uv * 0.35) * 5.0) * 1.7));\n        c *= mix(0.8, 1.05, pow(v, 0.35)) + (noise(uv * 3.0) - 0.5) * 0.04;\n      } else if (type < 12.5) { // Slate / sandstone: layered plates\n        float layer = floor(uv.y * sc * 2.0 + fbm(uv * 0.3) * 2.5);\n        c *= 0.9 + hash(vec2(layer, 3.0)) * 0.16 + (noise(uv * 5.0) - 0.5) * amt;\n      } else if (type < 13.5) { // Cobblestone / pebble / basalt: cells with dark gaps\n        vec3 v = voro(uv * sc);\n        c *= mix(0.62, 0.92 + v.z * 0.16, smoothstep(0.03, 0.12, v.y)) * (1.0 - v.x * 0.12);\n      } else if (type < 14.5) { // Cracked lava: dark rock with glowing cracks\n        vec3 v = voro(uv * sc);\n        c *= 0.55 + fbm(uv * 1.5) * 0.25;\n        glow = vec3(1.0, 0.36, 0.05) * smoothstep(0.08, 0.0, v.y) * (0.7 + 0.3 * sin(uTime * 1.5 + v.z * 6.0));\n      } else if (type < 15.5) { // Corroded metal: rust patches\n        float rust = smoothstep(0.42, 0.66, fbm(uv * sc));\n        c = mix(c * (0.95 + (noise(uv * vec2(18.0, 0.8)) - 0.5) * 0.08), c * vec3(0.7, 0.42, 0.24) + vec3(0.14, 0.05, 0.0), rust * 0.8);\n      } else if (type < 16.5) { // Tiles (ceramic / pavement)\n        vec2 tf = fract(uv / sc); float grout = step(0.035, tf.x) * step(0.035, tf.y);\n        c *= mix(0.72, 1.0 + (hash(floor(uv / sc)) - 0.5) * amt * 2.0 + (noise(uv * 3.0) - 0.5) * 0.04, grout);\n      } else if (type < 17.5) { // Roof tiles / shingles: overlapping rows\n        float row = floor(uv.y / (0.8 * sc));\n        vec2 q = vec2(uv.x / sc + mod(row, 2.0) * 0.5, fract(uv.y / (0.8 * sc)));\n        float edge = smoothstep(0.0, 0.08, fract(q.x)) * smoothstep(1.0, 0.92, fract(q.x));\n        c *= (0.8 + 0.25 * q.y) * mix(0.82, 1.0, edge) * (0.94 + hash(vec2(floor(q.x), row)) * 0.12);\n      } else if (type < 18.5) { // Cardboard corrugation\n        c *= 0.95 + 0.05 * sin(uv.x * 22.0) + (noise(uv * 8.0) - 0.5) * 0.06;\n      } else if (type < 19.5) { // ForceField: moving bands\n        float s = sin((uv.x + uv.y) * 2.5 - uTime * 2.2) * 0.5 + 0.5;\n        c = c * (0.55 + 0.45 * s) + vec3(0.12) * s;\n      } else if (type < 20.5) { // Leather: small creased cells\n        vec3 v = voro(uv * 6.0);\n        c *= 0.9 + 0.1 * smoothstep(0.0, 0.12, v.y) + (v.z - 0.5) * 0.04;\n      } else if (type < 21.5) { // Carpet: dense fibres\n        c *= 0.9 + hash(floor(uv * 28.0)) * 0.12 + (noise(uv * 6.0) - 0.5) * 0.1;\n      } else if (type < 22.5) { // Asphalt: speckled\n        c *= 0.9 + (hash(floor(uv * 16.0)) - 0.5) * 0.25 + (noise(uv * 2.0) - 0.5) * 0.08;\n      } else if (type < 23.5) { // Concrete: blotchy with pores\n        c *= 1.0 + (fbm(uv * sc) - 0.5) * amt * 2.4 - step(0.985, hash(floor(uv * 20.0))) * 0.18;\n      } else if (type < 24.5) { // Granite: mixed grains\n        float g = hash(floor(uv * 12.0));\n        c *= 0.88 + g * 0.22 - step(0.9, g) * 0.3 + (fbm(uv * 1.5) - 0.5) * 0.1;\n      } else { // Sand / snow / salt: fine grain with sparkle\n        float g = hash(floor(uv * 30.0));\n        c *= 1.0 + (g - 0.5) * amt * 2.0 + (fbm(uv * sc) - 0.5) * 0.1;\n        c += vec3(step(0.996, g) * 0.15);\n      }\n    } else\n    if (type < 1.5) { c *= 1.0 + (noise(uv * 2.2) - 0.5) * amt * 2.0; }\n    else if (type < 2.5) {\n      float g = sin((uv.x * 1.3 + fbm(uv * vec2(0.35, 2.2)) * 4.0) * 5.0);\n      c *= 1.0 + g * amt * 0.6 - amt * 0.2;\n    } else if (type < 3.5) {\n      float plank = floor(uv.y);\n      float seamY = smoothstep(0.0, 0.05, fract(uv.y)) * smoothstep(1.0, 0.95, fract(uv.y));\n      float off = hash(vec2(plank, 3.0)) * 8.0;\n      float seamX = smoothstep(0.0, 0.04, fract((uv.x + off) / 6.0) * 6.0);\n      float g = sin((uv.x * 1.6 + fbm(vec2(uv.x * 0.3, uv.y * 3.0 + plank)) * 3.0) * 6.0);\n      c *= (0.9 + hash(vec2(plank, 1.0)) * 0.18) * (1.0 + g * amt * 0.35) * mix(0.72, 1.0, seamY * seamX);\n    } else if (type < 4.5) {\n      // Brick: running bond with light grey mortar, like Roblox's brick material.\n      vec2 b = vec2(uv.x / 1.6, uv.y / 0.66);\n      float row = floor(b.y);\n      b.x += mod(row, 2.0) * 0.5;\n      vec2 f = fract(b);\n      float mortar = smoothstep(0.05, 0.09, f.y) * smoothstep(0.025, 0.05, f.x) * smoothstep(1.0, 0.985, f.x);\n      vec3 brick = c * (0.9 + (hash(floor(b)) - 0.5) * amt * 2.2 + (noise(uv * 7.0) - 0.5) * 0.08);\n      vec3 grout = mix(vec3(dot(c, vec3(0.3, 0.59, 0.11))), vec3(0.82), 0.55);\n      c = mix(grout, brick, mortar);\n    } else if (type < 5.5) { c *= 1.0 + (fbm(uv * sc) - 0.5) * amt * 2.6; }\n    else if (type < 6.5) {\n      vec2 q = vec2(uv.x + uv.y, uv.x - uv.y) * 1.4;\n      vec2 f = fract(q) - 0.5;\n      float bump = smoothstep(0.18, 0.05, abs(f.x) * 0.35 + abs(f.y));\n      c *= 0.92 + bump * 0.22 + (noise(uv * 8.0) - 0.5) * 0.05;\n    } else if (type < 7.5) { c *= 1.0 + (noise(uv * vec2(24.0, 0.6)) - 0.5) * amt * 2.0; }\n    else if (type < 8.5) {\n      float f = fbm(uv * sc);\n      c *= 1.0 + (f - 0.5) * amt * 2.4 + (noise(uv * 9.0) - 0.5) * 0.05;\n      c.r += (noise(uv * 0.25) - 0.5) * 0.04;\n    } else if (type < 9.5) { c *= 1.0 + sin(uv.x * 30.0) * sin(uv.y * 30.0) * amt; }\n    else { c *= 1.0 + (fbm(uv * sc) - 0.5) * amt * 2.0; }\n#else\n    // Lean variant: plastic grain only (other materials use the ADVANCED program).\n    c *= 1.0 + (noise(uv * 2.2) - 0.5) * amt * 2.0;\n#endif\n  }\n  c = surface(c, sf, uv, fsz);\n#ifndef BATCH\n  if (uGrid > 0.5) {\n    vec2 f = abs(fract(uv / 4.0 + 0.5) - 0.5) * 4.0;\n    float d = min(f.x, f.y);\n    c *= mix(0.84, 1.0, smoothstep(0.04, 0.09, d));\n  }\n#endif\n  vec3 col;\n  if (emis > 0.5) {\n    col = c * 1.15 + vec3(0.06);\n  } else {\n    float ndl = dot(n, uLight);\n    float diff = max(ndl, 0.0);\n    float sh = shadowAt(ndl);\n    vec3 sky = mix(uHorizon, uZenith, 0.5);\n    vec3 amb = uAmbient * mix(vec3(0.82), mix(vec3(1.0), sky * 1.2, 0.35), 0.5 + 0.5 * n.y);\n    col = c * (amb + uSun * diff * sh);\n    vec3 v = normalize(uCam - vW);\n    vec3 h = normalize(uLight + v);\n    float spec = pow(max(dot(n, h), 0.0), 16.0 + mat.w * 80.0) * mat.w * sh;\n    col += uSun * spec * 0.6;\n    float fres = pow(1.0 - max(dot(n, v), 0.0), 4.0) * mat.w * 0.25;\n    col = mix(col, uZenith, fres);\n  }\n  col += glow;\n  col *= uExposure;\n  float dist = length(uCam - vW);\n  float fog;\n  if (uFog.z > 1.5) fog = (1.0 - exp(-dist * uFog.x)) * uFog.y;\n  else if (uFog.z > 0.5) fog = clamp((dist - uFog.x) / max(uFog.y - uFog.x, 1.0), 0.0, 1.0);\n  else fog = smoothstep(900.0, 5000.0, dist) * 0.7;\n  col = mix(col, uFogColor, fog);\n  gl_FragColor = vec4(col, alpha);\n}"));
        this.litAdv = litLocs2;
        return litLocs2;
    }

    private final int assetTexture(String content, boolean repeat) {
        String str;
        if (content != null && StringsKt.startsWith$default(content, Avatar.TEX_PREFIX, false, 2, (Object) null)) {
            Integer num = this.textures.get(content);
            if (num != null) {
                return num.intValue();
            }
            Bitmap texture = Avatar.INSTANCE.texture(content);
            if (texture == null) {
                return 0;
            }
            int upload = upload(texture, repeat);
            this.textures.put(content, Integer.valueOf(upload));
            return upload;
        }
        Long idOf = AssetFetcher.INSTANCE.idOf(content);
        if (idOf == null) {
            return textureFor(content, repeat);
        }
        long longValue = idOf.longValue();
        HashMap<Long, String> hashMap = repeat ? this.rawKeysR : this.rawKeys;
        Long valueOf = Long.valueOf(longValue);
        String str2 = hashMap.get(valueOf);
        if (str2 == null) {
            str = "raw:" + longValue + (repeat ? "#r" : "");
            hashMap.put(valueOf, str);
        } else {
            str = str2;
        }
        String str3 = str;
        Integer num2 = this.textures.get(str3);
        if (num2 != null) {
            return num2.intValue();
        }
        if (!canDownload()) {
            return textureFor(content, repeat);
        }
        Bitmap image = AssetFetcher.INSTANCE.image(longValue);
        if (image != null) {
            int upload2 = upload(image, repeat);
            this.textures.put(str3, Integer.valueOf(upload2));
            return upload2;
        }
        if (AssetFetcher.INSTANCE.imageFailed(longValue)) {
            return textureFor(content, repeat);
        }
        return 0;
    }

    private final Vector3 attachmentWorld(Instance a) {
        Instance parent;
        Vector3 zero;
        if (a != null && (parent = a.getParent()) != null) {
            if (!parent.isA("BasePart")) {
                parent = null;
            }
            if (parent != null) {
                CFrame cframe = PartData.INSTANCE.cframe(parent);
                Object obj = a.get("CFrame");
                CFrame cFrame = obj instanceof CFrame ? (CFrame) obj : null;
                if (cFrame == null || (zero = cFrame.getPosition()) == null) {
                    zero = Vector3.INSTANCE.getZERO();
                }
                return cframe.times(zero);
            }
        }
        return null;
    }

    private final LitLocs batchProgram(int kind) {
        String str;
        LitLocs litLocs = this.batchLit[kind];
        if (litLocs != null) {
            return litLocs;
        }
        switch (kind) {
            case 1:
                str = "#define ADVANCED 1\n";
                break;
            case 2:
                str = "#define TEXTURED 1\n";
                break;
            default:
                str = "";
                break;
        }
        String str2 = "#define BATCH 1\n" + str;
        LitLocs litLocs2 = litLocs(program(str2 + LIT_VS, str2 + LIT_FS));
        this.batchLit[kind] = litLocs2;
        return litLocs2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x018b, code lost:
    
        if (r4 == false) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<com.exampletest.mobilestudiotest.render.BatchSpec> batchSpec(com.exampletest.mobilestudiotest.model.Instance r38) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.SceneRenderer.batchSpec(com.exampletest.mobilestudiotest.model.Instance):java.util.List");
    }

    private final void bind(Mesh m, int posLoc, int nrmLoc) {
        GLES20.glBindBuffer(34962, m.getVbo());
        GLES20.glEnableVertexAttribArray(posLoc);
        GLES20.glVertexAttribPointer(posLoc, 3, 5126, false, m.getStride() * 4, 0);
        if (nrmLoc >= 0) {
            GLES20.glEnableVertexAttribArray(nrmLoc);
            GLES20.glVertexAttribPointer(nrmLoc, 3, 5126, false, m.getStride() * 4, 12);
        }
    }

    private final void bindTextures(TexBind t) {
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, t.getColor());
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, t.getNormal() != 0 ? t.getNormal() : t.getColor());
        GLES20.glActiveTexture(33984);
        GLES20.glUniform1f(this.uTexScale, t.getScale());
        GLES20.glUniform1f(this.uHasNrm, t.getNormal() != 0 ? 1.0f : 0.0f);
    }

    private final Color3 c3(Object v) {
        if (v instanceof Color3) {
            return (Color3) v;
        }
        return null;
    }

    private final boolean canDownload() {
        if (this.canDownloadFrame != this.frames) {
            this.canDownloadFrame = this.frames;
            Context app = this.studio.getApp();
            boolean z = true;
            if (RobloxApi.INSTANCE.isGuest(app)) {
                if (!(RobloxApi.INSTANCE.apiKey(app).length() > 0)) {
                    z = false;
                }
            }
            this.canDownloadNow = z;
        }
        return this.canDownloadNow;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        if ((com.exampletest.mobilestudiotest.net.RobloxApi.INSTANCE.apiKey(r0).length() > 0) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<java.lang.Boolean, android.graphics.Bitmap> clothingImage(java.lang.String r8) {
        /*
            r7 = this;
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            r2 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            if (r0 == 0) goto L13
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 != 0) goto L13
            r0 = r1
            goto L14
        L13:
            r0 = r2
        L14:
            r4 = 0
            if (r0 == 0) goto L1c
            kotlin.Pair r0 = kotlin.TuplesKt.to(r3, r4)
            return r0
        L1c:
            com.exampletest.mobilestudiotest.net.AssetFetcher r0 = com.exampletest.mobilestudiotest.net.AssetFetcher.INSTANCE
            java.lang.Long r0 = r0.idOf(r8)
            if (r0 == 0) goto L6a
            long r4 = r0.longValue()
            com.exampletest.mobilestudiotest.core.Studio r0 = r7.studio
            android.content.Context r0 = r0.getApp()
            com.exampletest.mobilestudiotest.net.RobloxApi r6 = com.exampletest.mobilestudiotest.net.RobloxApi.INSTANCE
            boolean r6 = r6.isGuest(r0)
            if (r6 == 0) goto L4a
            com.exampletest.mobilestudiotest.net.RobloxApi r6 = com.exampletest.mobilestudiotest.net.RobloxApi.INSTANCE
            java.lang.String r6 = r6.apiKey(r0)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L46
            r6 = r2
            goto L47
        L46:
            r6 = r1
        L47:
            if (r6 != 0) goto L4a
            goto L58
        L4a:
            com.exampletest.mobilestudiotest.net.AssetFetcher r6 = com.exampletest.mobilestudiotest.net.AssetFetcher.INSTANCE
            android.graphics.Bitmap r6 = r6.imageBlocking(r4)
            if (r6 == 0) goto L58
            r1 = 0
            kotlin.Pair r2 = kotlin.TuplesKt.to(r3, r6)
            return r2
        L58:
            com.exampletest.mobilestudiotest.net.ImageLoader r3 = com.exampletest.mobilestudiotest.net.ImageLoader.INSTANCE
            android.graphics.Bitmap r3 = r3.get(r8)
            if (r3 == 0) goto L61
            r1 = r2
        L61:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r3)
            return r1
        L6a:
            kotlin.Pair r0 = kotlin.TuplesKt.to(r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.SceneRenderer.clothingImage(java.lang.String):kotlin.Pair");
    }

    private final int compile(int type, String src) {
        int glCreateShader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(glCreateShader, src);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            OutputLog.INSTANCE.error("Shader error: " + GLES20.glGetShaderInfoLog(glCreateShader));
        }
        return glCreateShader;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0084. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:160:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03a5  */
    /* JADX WARN: Type inference failed for: r5v33, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v50 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drawAdornments() {
        /*
            Method dump skipped, instructions count: 1514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.SceneRenderer.drawAdornments():void");
    }

    private final void drawBatch(StaticBatches.Batch b) {
        GLES20.glBindBuffer(34962, b.getVbo());
        GLES20.glEnableVertexAttribArray(this.aPos);
        GLES20.glVertexAttribPointer(this.aPos, 3, 5126, false, 40, 0);
        if (this.aUvB >= 0) {
            GLES20.glEnableVertexAttribArray(this.aUvB);
            GLES20.glVertexAttribPointer(this.aUvB, 2, 5126, false, 40, 12);
        }
        if (this.aNrm >= 0) {
            GLES20.glEnableVertexAttribArray(this.aNrm);
            GLES20.glVertexAttribPointer(this.aNrm, 4, 5120, true, 40, 20);
        }
        if (this.aCol >= 0) {
            GLES20.glEnableVertexAttribArray(this.aCol);
            GLES20.glVertexAttribPointer(this.aCol, 4, 5121, true, 40, 24);
        }
        if (this.aMatB >= 0) {
            GLES20.glEnableVertexAttribArray(this.aMatB);
            GLES20.glVertexAttribPointer(this.aMatB, 4, 5121, false, 40, 28);
        }
        if (this.aTan >= 0) {
            GLES20.glEnableVertexAttribArray(this.aTan);
            GLES20.glVertexAttribPointer(this.aTan, 3, 5120, true, 40, 32);
        }
        if (this.aBit >= 0) {
            GLES20.glEnableVertexAttribArray(this.aBit);
            GLES20.glVertexAttribPointer(this.aBit, 3, 5120, true, 40, 36);
        }
        GLES20.glDrawArrays(4, 0, b.getCount());
    }

    private final void drawClothing() {
        int i;
        Instance instance;
        boolean z;
        boolean z2;
        List listOf;
        Instance findFirstChild$default;
        String str;
        ArrayList arrayList;
        List<Instance> renderClothing = this.studio.renderClothing();
        if (renderClothing.isEmpty()) {
            if (this.partTexOverride.isEmpty()) {
                return;
            }
            this.partTexOverride = MapsKt.emptyMap();
            return;
        }
        this.nextOverride = new IdentityHashMap<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : renderClothing) {
            Instance parent = ((Instance) obj).getParent();
            Object obj2 = linkedHashMap.get(parent);
            if (obj2 == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(parent, arrayList);
            } else {
                arrayList = obj2;
            }
            ((List) arrayList).add(obj);
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (true) {
            i = 2;
            instance = null;
            z = false;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Instance instance2 = (Instance) entry.getKey();
            List<? extends Instance> list = (List) entry.getValue();
            if (instance2 != null && (findFirstChild$default = Instance.findFirstChild$default(instance2, "UpperTorso", false, 2, null)) != null) {
                if (!Intrinsics.areEqual(findFirstChild$default.getClassName(), "MeshPart")) {
                    findFirstChild$default = null;
                }
                if (findFirstChild$default != null) {
                    Object obj3 = findFirstChild$default.get("TextureID");
                    if (obj3 == null || (str = obj3.toString()) == null) {
                        str = "";
                    }
                    if (!StringsKt.startsWith$default(str, Avatar.TEX_PREFIX, false, 2, (Object) null)) {
                        r15Clothing(instance2, list);
                    }
                }
            }
        }
        this.partTexOverride = this.nextOverride;
        Vector3 camPos = this.studio.getView().getCamPos();
        Vector3 forward = this.studio.getCamera().getForward();
        PlaySession play = this.studio.getPlay();
        for (Instance instance3 : CollectionsKt.sortedWith(renderClothing, new SceneRenderer$drawClothing$$inlined$sortedBy$1())) {
            Instance parent2 = instance3.getParent();
            if (parent2 != null) {
                Instance findFirstChild$default2 = Instance.findFirstChild$default(parent2, "Torso", z, i, instance);
                if (findFirstChild$default2 != null) {
                    if (!findFirstChild$default2.isA("BasePart")) {
                        findFirstChild$default2 = instance;
                    }
                    if (findFirstChild$default2 != null) {
                        if (PartData.INSTANCE.transparency(findFirstChild$default2) >= 0.99f) {
                            i = 2;
                            instance = null;
                            z = false;
                        } else if ((play == null || !play.hiddenInFirstPerson(findFirstChild$default2)) ? z : true) {
                            i = 2;
                            instance = null;
                            z = false;
                        } else {
                            Geo geometry = geometry(findFirstChild$default2);
                            if (visible(geometry.getCf(), geometry.getScale().times(3.0f), camPos, forward)) {
                                Object obj4 = instance3.get("ShirtTemplate");
                                if (obj4 == null && (obj4 = instance3.get("PantsTemplate")) == null) {
                                    obj4 = instance3.get("Graphic");
                                }
                                String obj5 = obj4 != null ? obj4.toString() : null;
                                int assetTexture = assetTexture(obj5, z);
                                if (assetTexture != 0) {
                                    GLES20.glBindTexture(3553, assetTexture);
                                    Object obj6 = instance3.get("Color3");
                                    Color3 color3 = obj6 instanceof Color3 ? (Color3) obj6 : null;
                                    if (color3 == null) {
                                        color3 = new Color3(1.0f, 1.0f, 1.0f);
                                    }
                                    List<Instance> list2 = renderClothing;
                                    Vector3 vector3 = camPos;
                                    Vector3 vector32 = forward;
                                    GLES20.glUniform4f(this.cTint, color3.getR(), color3.getG(), color3.getB(), 1.0f);
                                    if (Intrinsics.areEqual(instance3.getClassName(), "ShirtGraphic")) {
                                        FaceQuad faceQuad = faceQuad(geometry, 5, 0.006f);
                                        float min = Math.min(faceQuad.getW(), faceQuad.getH()) * 0.98f;
                                        setModel(geometry.getCf().times(faceQuad.getLocal()), new Vector3(min, min, 1.0f));
                                        GLES20.glUniformMatrix4fv(this.cModel, 1, false, this.model, 0);
                                        GLES20.glUniform3f(this.cNormal, faceQuad.getNormal().getX(), faceQuad.getNormal().getY(), faceQuad.getNormal().getZ());
                                        GLES20.glUniform4f(this.cUv, 1.0f, 1.0f, 0.0f, 0.0f);
                                        Mesh mesh = this.quad;
                                        if (mesh == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("quad");
                                            mesh = null;
                                        }
                                        drawUvMesh(mesh);
                                        renderClothing = list2;
                                        camPos = vector3;
                                        forward = vector32;
                                        i = 2;
                                        instance = null;
                                        z = false;
                                    } else {
                                        boolean areEqual = Intrinsics.areEqual(instance3.getClassName(), "Shirt");
                                        for (Map.Entry<Integer, Region> entry2 : this.torsoRegions.entrySet()) {
                                            drawTemplateFace(findFirstChild$default2, geometry, entry2.getKey().intValue(), entry2.getValue());
                                        }
                                        if (areEqual) {
                                            listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Right Arm", this.rightLimbRegions), TuplesKt.to("Left Arm", this.leftLimbRegions)});
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                            listOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Right Leg", this.rightLimbRegions), TuplesKt.to("Left Leg", this.leftLimbRegions)});
                                        }
                                        Iterator it2 = listOf.iterator();
                                        while (it2.hasNext()) {
                                            Pair pair = (Pair) it2.next();
                                            String str2 = (String) pair.component1();
                                            Map map = (Map) pair.component2();
                                            boolean z3 = areEqual;
                                            List list3 = listOf;
                                            Iterator it3 = it2;
                                            Instance findFirstChild$default3 = Instance.findFirstChild$default(parent2, str2, false, 2, null);
                                            if (findFirstChild$default3 != null) {
                                                if (!((!findFirstChild$default3.isA("BasePart") || PartData.INSTANCE.transparency(findFirstChild$default3) >= 0.99f) ? false : z2)) {
                                                    findFirstChild$default3 = null;
                                                }
                                                if (findFirstChild$default3 != null) {
                                                    Instance instance4 = findFirstChild$default3;
                                                    Geo geometry2 = geometry(instance4);
                                                    if (geometry2.getKind() == 0) {
                                                        Mesh mesh2 = geometry2.getMesh();
                                                        String str3 = obj5;
                                                        Mesh mesh3 = this.cube;
                                                        if (mesh3 == null) {
                                                            Intrinsics.throwUninitializedPropertyAccessException("cube");
                                                            mesh3 = null;
                                                        }
                                                        if (mesh2 != mesh3) {
                                                            listOf = list3;
                                                            it2 = it3;
                                                            areEqual = z3;
                                                            obj5 = str3;
                                                        } else {
                                                            for (Iterator it4 = map.entrySet().iterator(); it4.hasNext(); it4 = it4) {
                                                                Map.Entry entry3 = (Map.Entry) it4.next();
                                                                drawTemplateFace(instance4, geometry2, ((Number) entry3.getKey()).intValue(), (Region) entry3.getValue());
                                                            }
                                                            listOf = list3;
                                                            it2 = it3;
                                                            areEqual = z3;
                                                            obj5 = str3;
                                                        }
                                                    } else {
                                                        listOf = list3;
                                                        it2 = it3;
                                                        areEqual = z3;
                                                    }
                                                }
                                            }
                                            listOf = list3;
                                            it2 = it3;
                                            areEqual = z3;
                                            obj5 = obj5;
                                        }
                                        renderClothing = list2;
                                        camPos = vector3;
                                        forward = vector32;
                                        i = 2;
                                        instance = null;
                                        z = false;
                                    }
                                } else {
                                    i = 2;
                                    instance = null;
                                    z = false;
                                }
                            } else {
                                i = 2;
                                instance = null;
                                z = false;
                            }
                        }
                    }
                }
                renderClothing = renderClothing;
                camPos = camPos;
                forward = forward;
                i = 2;
                instance = null;
                z = false;
            }
        }
    }

    private final void drawConstraints() {
        LitLocs litLocs;
        Color3 fromRGB;
        float f;
        float f2;
        List<Instance> list;
        LitLocs litLocs2;
        Iterator<Instance> it;
        Vector3 vector3;
        List<Instance> renderConstraints = this.studio.renderConstraints();
        if (renderConstraints.isEmpty() || (litLocs = this.litBasic) == null) {
            return;
        }
        useLit(litLocs);
        setLitFrameUniforms(this.frameShadows);
        Mesh mesh = this.cube;
        if (mesh == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cube");
            mesh = null;
        }
        bind(mesh, this.aPos, this.aNrm);
        boolean z = false;
        GLES20.glUniform1f(this.uEmissive, 0.0f);
        GLES20.glUniform1f(this.uGrid, 0.0f);
        GLES20.glUniform1f(this.uTruss, 0.0f);
        float f3 = 1.0f;
        GLES20.glUniform4f(this.uMat, 0.0f, 0.0f, 1.0f, 0.1f);
        GLES20.glUniform3f(this.uSurfA, 0.0f, 0.0f, 0.0f);
        GLES20.glUniform3f(this.uSurfB, 0.0f, 0.0f, 0.0f);
        GLES20.glUniform3f(this.uSize, 1.0f, 1.0f, 1.0f);
        Vector3 camPos = this.studio.getView().getCamPos();
        Iterator<Instance> it2 = renderConstraints.iterator();
        while (it2.hasNext()) {
            Instance next = it2.next();
            if (next.getParent() == null || !Intrinsics.areEqual(next.get("Visible"), (Object) true)) {
                renderConstraints = renderConstraints;
                it2 = it2;
            } else if (!Intrinsics.areEqual(next.get("Enabled"), (Object) false)) {
                Object obj = next.get("Attachment0");
                Vector3 attachmentWorld = attachmentWorld(obj instanceof Instance ? (Instance) obj : null);
                if (attachmentWorld != null) {
                    Object obj2 = next.get("Attachment1");
                    Vector3 attachmentWorld2 = attachmentWorld(obj2 instanceof Instance ? (Instance) obj2 : null);
                    if (attachmentWorld2 != null) {
                        Vector3 div = attachmentWorld.plus(attachmentWorld2).div(2.0f);
                        float magnitude = (attachmentWorld2.minus(attachmentWorld).getMagnitude() / 2.0f) + 2.0f;
                        if (this.frustum.sphere(div.getX(), div.getY(), div.getZ(), magnitude)) {
                            Object obj3 = next.get("Color");
                            BrickColorV brickColorV = obj3 instanceof BrickColorV ? (BrickColorV) obj3 : null;
                            if (brickColorV == null || (fromRGB = brickColorV.getColor()) == null) {
                                fromRGB = Color3.INSTANCE.fromRGB(163, 162, 165);
                            }
                            GLES20.glUniform4f(this.uColor, fromRGB.getR(), fromRGB.getG(), fromRGB.getB(), f3);
                            Object obj4 = next.get("Thickness");
                            Number number = obj4 instanceof Number ? (Number) obj4 : null;
                            float coerceIn = RangesKt.coerceIn(number != null ? number.floatValue() : 0.1f, 0.02f, 5.0f);
                            float magnitude2 = attachmentWorld2.minus(attachmentWorld).getMagnitude();
                            String className = next.getClassName();
                            if (Intrinsics.areEqual(className, "RopeConstraint")) {
                                Object obj5 = next.get("Length");
                                Number number2 = obj5 instanceof Number ? (Number) obj5 : null;
                                float coerceAtLeast = RangesKt.coerceAtLeast(number2 != null ? number2.floatValue() : magnitude2, magnitude2);
                                if (coerceAtLeast > 0.01f + magnitude2) {
                                    f = f3;
                                    f2 = RangesKt.coerceAtMost((float) Math.sqrt((((coerceAtLeast * coerceAtLeast) - (magnitude2 * magnitude2)) * 3.0f) / 16.0f), coerceAtLeast / 2.0f);
                                } else {
                                    f = f3;
                                    f2 = 0.0f;
                                }
                                int i = f2 > 0.05f ? 14 : 1;
                                Vector3 vector32 = attachmentWorld;
                                list = renderConstraints;
                                int i2 = 1;
                                if (1 <= i) {
                                    while (true) {
                                        litLocs2 = litLocs;
                                        float f4 = i2 / i;
                                        Color3 color3 = fromRGB;
                                        float f5 = f2;
                                        it = it2;
                                        Vector3 minus = attachmentWorld.plus(attachmentWorld2.minus(attachmentWorld).times(f4)).minus(new Vector3(0.0f, 4.0f * f2 * f4 * (f - f4), 0.0f));
                                        segment(vector32, minus, coerceIn);
                                        vector32 = minus;
                                        if (i2 == i) {
                                            break;
                                        }
                                        i2++;
                                        litLocs = litLocs2;
                                        fromRGB = color3;
                                        it2 = it;
                                        f2 = f5;
                                    }
                                } else {
                                    litLocs2 = litLocs;
                                    it = it2;
                                }
                                vector3 = camPos;
                            } else {
                                list = renderConstraints;
                                litLocs2 = litLocs;
                                f = f3;
                                it = it2;
                                if (Intrinsics.areEqual(className, "SpringConstraint")) {
                                    Object obj6 = next.get("Coils");
                                    Number number3 = obj6 instanceof Number ? (Number) obj6 : null;
                                    float coerceIn2 = RangesKt.coerceIn(number3 != null ? number3.floatValue() : 8.0f, 0.0f, 64.0f);
                                    Object obj7 = next.get("Radius");
                                    Number number4 = obj7 instanceof Number ? (Number) obj7 : null;
                                    float coerceIn3 = RangesKt.coerceIn(number4 != null ? number4.floatValue() : 0.4f, 0.0f, 20.0f);
                                    Vector3 minus2 = attachmentWorld2.minus(attachmentWorld);
                                    if (minus2.getMagnitude() >= 0.001f) {
                                        Vector3 unit = minus2.getUnit();
                                        Vector3 unit2 = (Math.abs(unit.getY()) > 0.9f ? Vector3.INSTANCE.getX() : Vector3.INSTANCE.getY()).cross(unit).getUnit();
                                        Vector3 unit3 = unit.cross(unit2).getUnit();
                                        int coerceIn4 = RangesKt.coerceIn((int) (12.0f * coerceIn2), 8, 600);
                                        Vector3 vector33 = attachmentWorld;
                                        int i3 = 1;
                                        if (1 <= coerceIn4) {
                                            while (true) {
                                                float f6 = coerceIn3;
                                                float f7 = i3 / coerceIn4;
                                                Vector3 vector34 = unit;
                                                float f8 = f7 * coerceIn2 * 2.0f * 3.1415927f;
                                                float f9 = (f7 < 0.04f || f7 > 0.96f) ? 0.0f : f6;
                                                Instance instance = next;
                                                vector3 = camPos;
                                                Vector3 vector35 = minus2;
                                                Vector3 plus = attachmentWorld.plus(minus2.times(f7)).plus(unit2.times(((float) Math.cos(f8)) * f9)).plus(unit3.times(((float) Math.sin(f8)) * f9));
                                                segment(vector33, plus, coerceIn);
                                                vector33 = plus;
                                                if (i3 == coerceIn4) {
                                                    break;
                                                }
                                                i3++;
                                                minus2 = vector35;
                                                coerceIn3 = f6;
                                                next = instance;
                                                unit = vector34;
                                                camPos = vector3;
                                            }
                                        } else {
                                            vector3 = camPos;
                                        }
                                    } else {
                                        renderConstraints = list;
                                        f3 = f;
                                        litLocs = litLocs2;
                                        it2 = it;
                                        z = false;
                                    }
                                } else {
                                    vector3 = camPos;
                                    segment(attachmentWorld, attachmentWorld2, coerceIn);
                                }
                            }
                            Vector3 vector36 = vector3;
                            if (div.minus(vector36).getMagnitude() < this.closest) {
                                this.closest = RangesKt.coerceAtLeast(div.minus(vector36).getMagnitude() - magnitude, 0.0f);
                                camPos = vector36;
                                z = false;
                                renderConstraints = list;
                                f3 = f;
                                litLocs = litLocs2;
                                it2 = it;
                            } else {
                                camPos = vector36;
                                z = false;
                                renderConstraints = list;
                                f3 = f;
                                litLocs = litLocs2;
                                it2 = it;
                            }
                        } else {
                            renderConstraints = renderConstraints;
                            it2 = it2;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0369 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b4 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r22v2 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r26v6 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drawDecals() {
        /*
            Method dump skipped, instructions count: 1015
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.SceneRenderer.drawDecals():void");
    }

    private final void drawFileMesh(Instance p, Geo g, float alpha) {
        GLES20.glUseProgram(this.meshProg);
        this.activeLit = null;
        if (this.meshFrame != this.frames) {
            this.meshFrame = this.frames;
            GLES20.glUniformMatrix4fv(this.mVP, 1, false, this.studio.getView().getVp(), 0);
            GLES20.glUniformMatrix4fv(this.mShadowVP, 1, false, this.lightVP, 0);
            GLES20.glUniform3f(this.mLight, this.sunDir.getX(), this.sunDir.getY(), this.sunDir.getZ());
            GLES20.glUniform3fv(this.mSun, 1, this.sunColor, 0);
            GLES20.glUniform1f(this.mAmbient, this.ambient);
            Vector3 camPos = this.studio.getView().getCamPos();
            GLES20.glUniform3f(this.mCam, camPos.getX(), camPos.getY(), camPos.getZ());
            GLES20.glUniform3fv(this.mFogColor, 1, this.fogColor, 0);
            GLES20.glUniform3f(this.mFog, this.fogStart, this.fogEnd, this.fogMode);
            GLES20.glUniform1f(this.mExposure, this.exposure);
            GLES20.glUniform1f(this.mShadowOn, this.frameShadows ? 1.0f : 0.0f);
            GLES20.glUniform2f(this.mShadowTexel, 1.0f / this.shadowSize, 1.0f / this.shadowSize);
            GLES20.glUniform3fv(this.mHorizon, 1, this.horizon, 0);
            GLES20.glUniform3fv(this.mZenith, 1, this.zenith, 0);
            GLES20.glUniform1i(this.mShadow, 0);
            GLES20.glUniform1i(this.mTex, 1);
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.shadowTex);
        String tex = g.getTex();
        int assetTexture = tex != null ? assetTexture(tex, true) : 0;
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, assetTexture);
        GLES20.glActiveTexture(33984);
        GLES20.glUniform1f(this.mHasTex, assetTexture != 0 ? 1.0f : 0.0f);
        Color3 color = PartData.INSTANCE.color(p);
        GLES20.glUniform4f(this.mColor, color.getR(), color.getG(), color.getB(), alpha);
        Vector3 tint = g.getTint();
        if (tint == null) {
            tint = new Vector3(1.0f, 1.0f, 1.0f);
        }
        GLES20.glUniform3f(this.mTint, tint.getX(), tint.getY(), tint.getZ());
        GLES20.glUniform1f(this.mEmissive, PartData.INSTANCE.material(p) == 288 ? 1.0f : 0.0f);
        setModel(g.getCf(), g.getScale());
        GLES20.glUniformMatrix4fv(this.mModel, 1, false, this.model, 0);
        GLES20.glUniformMatrix3fv(this.mNrm, 1, false, this.normal, 0);
        Mesh mesh = g.getMesh();
        GLES20.glBindBuffer(34962, mesh.getVbo());
        GLES20.glEnableVertexAttribArray(this.maPos);
        GLES20.glVertexAttribPointer(this.maPos, 3, 5126, false, 32, 0);
        GLES20.glEnableVertexAttribArray(this.maNrm);
        GLES20.glVertexAttribPointer(this.maNrm, 3, 5126, false, 32, 12);
        GLES20.glEnableVertexAttribArray(this.maUv);
        GLES20.glVertexAttribPointer(this.maUv, 2, 5126, false, 32, 24);
        GLES20.glDisable(2884);
        GLES20.glDrawArrays(mesh.getMode(), 0, mesh.getCount());
        GLES20.glEnable(2884);
        GLES20.glDisableVertexAttribArray(this.maUv);
    }

    private final void drawHandles() {
        float f;
        float f2;
        Mesh mesh;
        Mesh mesh2;
        HandleSet compute = Handles.INSTANCE.compute(this.studio);
        if (compute == null) {
            return;
        }
        int i = 2929;
        GLES20.glDisable(2929);
        GLES20.glUseProgram(this.lit);
        GLES20.glUniform1f(this.uGrid, 0.0f);
        GLES20.glUniform1f(this.uEmissive, 1.0f);
        GLES20.glUniform4f(this.uMat, 0.0f, 0.0f, 1.0f, 0.0f);
        GLES20.glUniform3f(this.uSurfA, 0.0f, 0.0f, 0.0f);
        GLES20.glUniform3f(this.uSurfB, 0.0f, 0.0f, 0.0f);
        GLES20.glUniform1f(this.uTruss, 0.0f);
        GLES20.glUniform3f(this.uFog, 0.0f, 1.0E9f, 0.0f);
        for (Handle handle : compute.getHandles()) {
            float[] color = Handles.INSTANCE.color(handle.getIndex());
            float magnitude = handle.getTip().minus(handle.getBase()).getMagnitude();
            int i2 = i;
            if (magnitude > 0.001f) {
                Mesh mesh3 = this.cube;
                if (mesh3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cube");
                    mesh3 = null;
                }
                f2 = 0.9f;
                bind(mesh3, this.aPos, this.aNrm);
                f = 2.0f;
                setModel(CFrame.INSTANCE.lookAt(handle.getBase().plus(handle.getTip()).div(2.0f), handle.getTip(), Math.abs(handle.getAxis().getY()) > 0.9f ? Vector3.INSTANCE.getZ() : Vector3.INSTANCE.getY()), new Vector3(handle.getRadius() * 0.3f, 0.3f * handle.getRadius(), magnitude));
                GLES20.glUniformMatrix4fv(this.uModel, 1, false, this.model, 0);
                GLES20.glUniformMatrix3fv(this.uNrm, 1, false, this.normal, 0);
                GLES20.glUniform4f(this.uColor, color[0], color[1], color[2], 1.0f);
                Mesh mesh4 = this.cube;
                if (mesh4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cube");
                    mesh4 = null;
                }
                GLES20.glDrawArrays(4, 0, mesh4.getCount());
            } else {
                f = 2.0f;
                f2 = 0.9f;
            }
            if (compute.getTool() == Tool.SCALE) {
                mesh = this.cube;
                if (mesh == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cube");
                    mesh2 = null;
                }
                mesh2 = mesh;
            } else {
                mesh = this.sphere;
                if (mesh == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sphere");
                    mesh2 = null;
                }
                mesh2 = mesh;
            }
            bind(mesh2, this.aPos, this.aNrm);
            float radius = handle.getRadius() * f;
            setModel(CFrame.INSTANCE.lookAt(handle.getTip(), handle.getTip().plus(handle.getAxis()), Math.abs(handle.getAxis().getY()) > f2 ? Vector3.INSTANCE.getZ() : Vector3.INSTANCE.getY()), new Vector3(radius, radius, radius));
            GLES20.glUniformMatrix4fv(this.uModel, 1, false, this.model, 0);
            GLES20.glUniformMatrix3fv(this.uNrm, 1, false, this.normal, 0);
            GLES20.glUniform4f(this.uColor, color[0], color[1], color[2], 1.0f);
            GLES20.glDrawArrays(4, 0, mesh2.getCount());
            i = i2;
        }
        GLES20.glEnable(i);
    }

    private final void drawMeshBatch(StaticBatches.Batch b) {
        GLES20.glActiveTexture(33985);
        TexBind tex = b.getTex();
        GLES20.glBindTexture(3553, tex != null ? tex.getColor() : 0);
        GLES20.glActiveTexture(33984);
        Integer num = this.mb.get("uHasTex");
        int intValue = num != null ? num.intValue() : -1;
        TexBind tex2 = b.getTex();
        GLES20.glUniform1f(intValue, (tex2 != null ? tex2.getColor() : 0) != 0 ? 1.0f : 0.0f);
        GLES20.glBindBuffer(34962, b.getVbo());
        GLES20.glEnableVertexAttribArray(drawMeshBatch$a(this, "aPos"));
        GLES20.glVertexAttribPointer(drawMeshBatch$a(this, "aPos"), 3, 5126, false, 28, 0);
        if (drawMeshBatch$a(this, "aUv") >= 0) {
            GLES20.glEnableVertexAttribArray(drawMeshBatch$a(this, "aUv"));
            GLES20.glVertexAttribPointer(drawMeshBatch$a(this, "aUv"), 2, 5126, false, 28, 12);
        }
        if (drawMeshBatch$a(this, "aNrm") >= 0) {
            GLES20.glEnableVertexAttribArray(drawMeshBatch$a(this, "aNrm"));
            GLES20.glVertexAttribPointer(drawMeshBatch$a(this, "aNrm"), 4, 5120, true, 28, 20);
        }
        if (drawMeshBatch$a(this, "aCol") >= 0) {
            GLES20.glEnableVertexAttribArray(drawMeshBatch$a(this, "aCol"));
            GLES20.glVertexAttribPointer(drawMeshBatch$a(this, "aCol"), 4, 5121, true, 28, 24);
        }
        GLES20.glDrawArrays(4, 0, b.getCount());
    }

    private static final int drawMeshBatch$a(SceneRenderer sceneRenderer, String str) {
        Integer num = sceneRenderer.mb.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.exampletest.mobilestudiotest.render.Mesh drawPart(com.exampletest.mobilestudiotest.model.Instance r19, float r20, com.exampletest.mobilestudiotest.render.Mesh r21, com.exampletest.mobilestudiotest.render.SceneRenderer.Geo r22, com.exampletest.mobilestudiotest.model.Color3 r23) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.SceneRenderer.drawPart(com.exampletest.mobilestudiotest.model.Instance, float, com.exampletest.mobilestudiotest.render.Mesh, com.exampletest.mobilestudiotest.render.SceneRenderer$Geo, com.exampletest.mobilestudiotest.model.Color3):com.exampletest.mobilestudiotest.render.Mesh");
    }

    static /* synthetic */ Mesh drawPart$default(SceneRenderer sceneRenderer, Instance instance, float f, Mesh mesh, Geo geo, Color3 color3, int i, Object obj) {
        if ((i & 8) != 0) {
            geo = sceneRenderer.geometry(instance);
        }
        Geo geo2 = geo;
        if ((i & 16) != 0) {
            color3 = null;
        }
        return sceneRenderer.drawPart(instance, f, mesh, geo2, color3);
    }

    private final void drawParts(boolean shadows) {
        String str;
        String str2;
        String str3;
        String str4;
        LitLocs litLocs;
        Mesh mesh;
        float f;
        Mesh mesh2;
        TexBind texBind;
        Mesh mesh3;
        PlaySession playSession;
        Mesh mesh4;
        ArrayList<Instance> arrayList;
        String str5;
        LitLocs litLocs2;
        Iterator<Instance> it;
        String str6;
        TexBind texturesFor;
        ArrayList<Instance> loose = this.batches.getLoose();
        this.frames++;
        this.frameShadows = shadows;
        LitLocs litLocs3 = this.litBasic;
        if (litLocs3 == null) {
            return;
        }
        useLit(litLocs3);
        setLitFrameUniforms(shadows);
        Vector3 camPos = this.studio.getView().getCamPos();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        PlaySession play = this.studio.getPlay();
        if (this.meshEpoch != MeshLoader.INSTANCE.getEpoch()) {
            this.meshEpoch = MeshLoader.INSTANCE.getEpoch();
        }
        refreshVariants();
        LitLocs texturedLit = texturedLit();
        Iterator<StaticBatches.Chunk> it2 = this.batches.getVisible().iterator();
        String str7 = "iterator(...)";
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (true) {
            str = "next(...)";
            if (!it2.hasNext()) {
                break;
            }
            StaticBatches.Chunk next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            StaticBatches.Chunk chunk = next;
            if (chunk.getDist() < this.closest && this.frustum.box(chunk.getX0(), chunk.getY0(), chunk.getZ0(), chunk.getX1(), chunk.getY1(), chunk.getZ1())) {
                this.closest = chunk.getDist();
            }
        }
        long nanoTime = System.nanoTime();
        drawStaticBatches();
        long nanoTime2 = System.nanoTime();
        LitLocs litLocs4 = texturedLit;
        this.tB += ((float) (nanoTime2 - nanoTime)) / 1000000.0f;
        LitLocs litLocs5 = this.litBasic;
        if (litLocs5 == null) {
            return;
        }
        useLit(litLocs5);
        setLitFrameUniforms(shadows);
        Iterator<Instance> it3 = loose.iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        Mesh mesh5 = null;
        while (true) {
            str2 = str7;
            str3 = "NegateOperation";
            boolean z = false;
            if (!it3.hasNext()) {
                break;
            }
            Instance next2 = it3.next();
            float transparency = PartData.INSTANCE.transparency(next2);
            if (transparency < 0.999f) {
                if (play != null) {
                    playSession = play;
                    if (play.hiddenInFirstPerson(next2)) {
                        z = true;
                    }
                } else {
                    playSession = play;
                }
                if (z) {
                    mesh4 = mesh5;
                    arrayList = loose;
                    str5 = str2;
                    litLocs2 = litLocs4;
                    it = it3;
                    str6 = str;
                } else {
                    CFrame cframe = PartData.INSTANCE.cframe(next2);
                    if (inView(cframe, PartData.INSTANCE.size(next2), camPos)) {
                        int material = PartData.INSTANCE.material(next2);
                        if (transparency <= 0.01f) {
                            mesh4 = mesh5;
                            if (material == 1568 || material == 1584) {
                                arrayList = loose;
                                str5 = str2;
                                litLocs2 = litLocs4;
                                it = it3;
                                str6 = str;
                            } else if (Intrinsics.areEqual(next2.getClassName(), "NegateOperation")) {
                                arrayList = loose;
                                str5 = str2;
                                litLocs2 = litLocs4;
                                it = it3;
                                str6 = str;
                            } else {
                                Geo geometry = geometry(next2);
                                if (geometry.getKind() == 2) {
                                    arrayList5.add(TuplesKt.to(next2, geometry));
                                    arrayList = loose;
                                    str5 = str2;
                                    litLocs2 = litLocs4;
                                    it = it3;
                                    str6 = str;
                                } else if (litLocs4 != null && (texturesFor = texturesFor(next2, material)) != null) {
                                    arrayList4.add(new Triple(next2, geometry, texturesFor));
                                    arrayList = loose;
                                    str5 = str2;
                                    litLocs2 = litLocs4;
                                    it = it3;
                                    str6 = str;
                                } else if (needsAdvanced(material)) {
                                    arrayList3.add(next2);
                                    arrayList = loose;
                                    str5 = str2;
                                    litLocs2 = litLocs4;
                                    it = it3;
                                    str6 = str;
                                } else {
                                    mesh5 = drawPart$default(this, next2, 1.0f, mesh4, geometry, null, 16, null);
                                    litLocs4 = litLocs4;
                                    str = str;
                                    str7 = str2;
                                    it3 = it3;
                                    play = playSession;
                                    loose = loose;
                                }
                            }
                        } else {
                            mesh4 = mesh5;
                            arrayList = loose;
                            str5 = str2;
                            litLocs2 = litLocs4;
                            it = it3;
                            str6 = str;
                        }
                        arrayList2.add(new Draw(next2, cframe.getPosition().minus(camPos).getMagnitude()));
                    } else {
                        mesh4 = mesh5;
                        arrayList = loose;
                        str5 = str2;
                        litLocs2 = litLocs4;
                        it = it3;
                        str6 = str;
                    }
                }
            } else {
                playSession = play;
                mesh4 = mesh5;
                arrayList = loose;
                str5 = str2;
                litLocs2 = litLocs4;
                it = it3;
                str6 = str;
            }
            litLocs4 = litLocs2;
            str = str6;
            str7 = str5;
            it3 = it;
            play = playSession;
            mesh5 = mesh4;
            loose = arrayList;
        }
        Mesh mesh6 = mesh5;
        String str8 = str;
        char c = 2;
        LitLocs litLocs6 = litLocs4;
        if (arrayList3.isEmpty()) {
            str4 = "NegateOperation";
        } else {
            LitLocs advancedLit = advancedLit();
            if (advancedLit != null) {
                switchLit(advancedLit);
                mesh3 = null;
            } else {
                mesh3 = mesh6;
            }
            Iterator it4 = arrayList3.iterator();
            Intrinsics.checkNotNullExpressionValue(it4, str2);
            while (it4.hasNext()) {
                mesh3 = drawPart$default(this, (Instance) it4.next(), 1.0f, mesh3, null, null, 24, null);
                str3 = str3;
                it4 = it4;
                camPos = camPos;
                c = 2;
            }
            str4 = str3;
        }
        if (!arrayList4.isEmpty() && litLocs6 != null) {
            switchLit(litLocs6);
            Mesh mesh7 = null;
            ArrayList arrayList6 = arrayList4;
            if (arrayList6.size() > 1) {
                CollectionsKt.sortWith(arrayList6, new SceneRenderer$drawParts$$inlined$sortBy$1());
            }
            TexBind texBind2 = null;
            Iterator it5 = arrayList4.iterator();
            Intrinsics.checkNotNullExpressionValue(it5, str2);
            while (it5.hasNext()) {
                Object next3 = it5.next();
                Intrinsics.checkNotNullExpressionValue(next3, str8);
                Triple triple = (Triple) next3;
                Instance instance = (Instance) triple.component1();
                Geo geo = (Geo) triple.component2();
                TexBind texBind3 = (TexBind) triple.component3();
                if (texBind2 != null) {
                    mesh2 = mesh7;
                    if (texBind2.getColor() == texBind3.getColor() && texBind2.getNormal() == texBind3.getNormal()) {
                        if (texBind2.getScale() == texBind3.getScale()) {
                            texBind = texBind2;
                            mesh7 = drawPart$default(this, instance, 1.0f, mesh2, geo, null, 16, null);
                            it5 = it5;
                            texBind2 = texBind;
                        }
                    }
                } else {
                    mesh2 = mesh7;
                }
                bindTextures(texBind3);
                texBind = texBind3;
                mesh7 = drawPart$default(this, instance, 1.0f, mesh2, geo, null, 16, null);
                it5 = it5;
                texBind2 = texBind;
            }
        }
        float f2 = 1.0f;
        LitLocs litLocs7 = null;
        if (!arrayList5.isEmpty()) {
            Iterator it6 = arrayList5.iterator();
            Intrinsics.checkNotNullExpressionValue(it6, str2);
            while (it6.hasNext()) {
                Object next4 = it6.next();
                Intrinsics.checkNotNullExpressionValue(next4, str8);
                Pair pair = (Pair) next4;
                drawFileMesh((Instance) pair.component1(), (Geo) pair.component2(), 1.0f);
            }
            this.activeLit = null;
            LitLocs litLocs8 = this.litBasic;
            if (litLocs8 == null) {
                return;
            }
            useLit(litLocs8);
            setLitFrameUniforms(shadows);
        }
        long nanoTime3 = System.nanoTime();
        this.tL += ((float) (nanoTime3 - nanoTime2)) / 1000000.0f;
        drawDecals();
        drawConstraints();
        drawAdornments();
        long nanoTime4 = System.nanoTime();
        this.tDec += ((float) (nanoTime4 - nanoTime3)) / 1000000.0f;
        this.activeLit = null;
        Mesh mesh8 = null;
        if (!arrayList2.isEmpty()) {
            ArrayList arrayList7 = arrayList2;
            if (arrayList7.size() > 1) {
                CollectionsKt.sortWith(arrayList7, new SceneRenderer$drawParts$$inlined$sortByDescending$1());
            }
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            GLES20.glDepthMask(false);
            Iterator it7 = arrayList2.iterator();
            Intrinsics.checkNotNullExpressionValue(it7, str2);
            while (it7.hasNext()) {
                Object next5 = it7.next();
                Intrinsics.checkNotNullExpressionValue(next5, str8);
                Draw draw = (Draw) next5;
                float transparency2 = f2 - PartData.INSTANCE.transparency(draw.getPart());
                switch (PartData.INSTANCE.material(draw.getPart())) {
                    case 1568:
                        f = 0.45f;
                        break;
                    case 1584:
                        f = 0.5f;
                        break;
                }
                transparency2 = Math.min(transparency2, f);
                boolean areEqual = Intrinsics.areEqual(draw.getPart().getClassName(), str4);
                if (areEqual) {
                    transparency2 = Math.min(transparency2, 0.42f);
                }
                Geo geometry2 = geometry(draw.getPart());
                if (geometry2.getKind() == 2) {
                    drawFileMesh(draw.getPart(), geometry2, transparency2);
                    this.activeLit = litLocs7;
                    mesh8 = null;
                    f2 = 1.0f;
                } else {
                    TexBind texturesFor2 = (litLocs6 == null || areEqual) ? null : texturesFor(draw.getPart(), PartData.INSTANCE.material(draw.getPart()));
                    LitLocs litLocs9 = needsAdvanced(PartData.INSTANCE.material(draw.getPart())) ? this.litAdv : null;
                    if (texturesFor2 != null) {
                        Intrinsics.checkNotNull(litLocs6);
                        litLocs = litLocs6;
                    } else if (litLocs9 == null) {
                        litLocs = this.litBasic;
                        Intrinsics.checkNotNull(litLocs);
                    } else {
                        litLocs = litLocs9;
                    }
                    Mesh mesh9 = mesh8;
                    if (this.activeLit != litLocs) {
                        switchLit(litLocs);
                        mesh = null;
                    } else {
                        mesh = mesh9;
                    }
                    if (texturesFor2 != null) {
                        bindTextures(texturesFor2);
                    }
                    Iterator it8 = it7;
                    mesh8 = drawPart(draw.getPart(), transparency2, mesh, geometry2, areEqual ? NEGATE_COLOR : null);
                    it7 = it8;
                    f2 = 1.0f;
                    litLocs7 = null;
                }
            }
            GLES20.glDepthMask(true);
            GLES20.glDisable(3042);
        }
        this.tTr += ((float) (System.nanoTime() - nanoTime4)) / 1000000.0f;
        this.nTr += arrayList2.size();
        this.nLoose += arrayList4.size() + arrayList3.size() + arrayList5.size();
        LitLocs litLocs10 = this.litBasic;
        if (litLocs10 != null) {
            useLit(litLocs10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void drawSelection() {
        if (this.studio.getSelection().isEmpty()) {
            return;
        }
        GLES20.glUseProgram(this.line);
        GLES20.glUniformMatrix4fv(this.lVP, 1, false, this.studio.getView().getVp(), 0);
        Mesh mesh = this.boxLines;
        List list = null;
        if (mesh == null) {
            Intrinsics.throwUninitializedPropertyAccessException("boxLines");
            mesh = null;
        }
        bind(mesh, this.laPos, -1);
        GLES20.glLineWidth(3.0f);
        float[] fArr = {0.1f, 0.65f, 1.0f, 1.0f};
        Iterator<Instance> it = this.studio.getSelection().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Instance next = it.next();
            if (next.isA("BasePart")) {
                setModel(PartData.INSTANCE.cframe(next), PartData.INSTANCE.size(next).times(1.004f).plus(new Vector3(0.04f, 0.04f, 0.04f)));
                GLES20.glUniformMatrix4fv(this.lModel, 1, false, this.model, 0);
                GLES20.glUniform4fv(this.lColor, 1, fArr, 0);
                Mesh mesh2 = this.boxLines;
                Mesh mesh3 = mesh2;
                if (mesh2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("boxLines");
                    mesh3 = list;
                }
                GLES20.glDrawArrays(1, 0, mesh3.getCount());
            } else if (next.getIsService()) {
                list = null;
            } else if (next.isA("Model") || Intrinsics.areEqual(next.getClassName(), "Folder")) {
                List descendants$default = Instance.descendants$default(next, list, 1, list);
                ArrayList arrayList = new ArrayList();
                for (Object obj : descendants$default) {
                    if (((Instance) obj).isA("BasePart")) {
                        arrayList.add(obj);
                    }
                }
                ArrayList<Instance> arrayList2 = arrayList;
                Pair<Vector3, Vector3> boundsOf = Geometry.INSTANCE.boundsOf(arrayList2);
                if (boundsOf == null) {
                    list = null;
                } else {
                    Vector3 component1 = boundsOf.component1();
                    Vector3 component2 = boundsOf.component2();
                    setModel(CFrame.INSTANCE.at(component1.plus(component2).div(2.0f)), component2.minus(component1).plus(new Vector3(0.1f, 0.1f, 0.1f)));
                    GLES20.glUniformMatrix4fv(this.lModel, 1, false, this.model, 0);
                    GLES20.glUniform4fv(this.lColor, 1, new float[]{0.1f, 0.65f, 1.0f, 1.0f}, 0);
                    Mesh mesh4 = this.boxLines;
                    if (mesh4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("boxLines");
                        mesh4 = null;
                    }
                    GLES20.glDrawArrays(1, 0, mesh4.getCount());
                    GLES20.glUniform4fv(this.lColor, 1, new float[]{0.1f, 0.65f, 1.0f, 0.6f}, 0);
                    for (Instance instance : arrayList2) {
                        setModel(PartData.INSTANCE.cframe(instance), PartData.INSTANCE.size(instance).times(1.004f));
                        GLES20.glUniformMatrix4fv(this.lModel, 1, false, this.model, 0);
                        Mesh mesh5 = this.boxLines;
                        if (mesh5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("boxLines");
                            mesh5 = null;
                        }
                        GLES20.glDrawArrays(1, 0, mesh5.getCount());
                    }
                    list = null;
                }
            }
        }
    }

    private final void drawSky() {
        if (drawSkybox()) {
            return;
        }
        GLES20.glDisable(2929);
        GLES20.glDepthMask(false);
        GLES20.glUseProgram(this.skyProg);
        GLES20.glUniformMatrix4fv(this.sInvVP, 1, false, this.studio.getView().getInvVp(), 0);
        Vector3 camPos = this.studio.getView().getCamPos();
        GLES20.glUniform3f(this.sCam, camPos.getX(), camPos.getY(), camPos.getZ());
        GLES20.glUniform3f(this.sSun, this.sunDir.getX(), this.sunDir.getY(), this.sunDir.getZ());
        GLES20.glUniform3fv(this.sZenith, 1, this.zenith, 0);
        GLES20.glUniform3fv(this.sHorizon, 1, this.horizon, 0);
        GLES20.glUniform3f(this.sSunColor, 1.0f, 0.95f, 0.85f);
        GLES20.glUniform1f(this.sTime, this.time);
        GLES20.glUniform1f(this.sDay, this.dayFactor);
        Mesh mesh = this.screen;
        Mesh mesh2 = null;
        if (mesh == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
            mesh = null;
        }
        GLES20.glBindBuffer(34962, mesh.getVbo());
        GLES20.glEnableVertexAttribArray(this.saPos);
        GLES20.glVertexAttribPointer(this.saPos, 2, 5126, false, 8, 0);
        Mesh mesh3 = this.screen;
        if (mesh3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        } else {
            mesh2 = mesh3;
        }
        GLES20.glDrawArrays(4, 0, mesh2.getCount());
        GLES20.glDepthMask(true);
        GLES20.glEnable(2929);
    }

    private final boolean drawSkybox() {
        ArrayList<Instance> children;
        Mesh mesh;
        Object obj;
        boolean z;
        String obj2;
        Instance findService = this.studio.getModel().findService("Lighting");
        if (findService != null && (children = findService.getChildren()) != null) {
            Iterator<T> it = children.iterator();
            while (true) {
                mesh = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((Instance) obj).getClassName(), "Sky")) {
                    break;
                }
            }
            Instance instance = (Instance) obj;
            if (instance != null) {
                int[] iArr = new int[6];
                int i = 0;
                while (true) {
                    if (i >= 6) {
                        int length = iArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                z = false;
                                break;
                            }
                            if (iArr[i2] == 0) {
                                z = true;
                                break;
                            }
                            i2++;
                        }
                        if (z) {
                            return false;
                        }
                        GLES20.glDisable(2929);
                        GLES20.glDepthMask(false);
                        GLES20.glDisable(2884);
                        GLES20.glUseProgram(this.skyboxProg);
                        GLES20.glUniformMatrix4fv(this.kVP, 1, false, this.studio.getView().getVp(), 0);
                        Vector3 camPos = this.studio.getView().getCamPos();
                        GLES20.glUniform3f(this.kCam, camPos.getX(), camPos.getY(), camPos.getZ());
                        Object obj3 = instance.get("SkyboxOrientation");
                        Vector3 vector3 = obj3 instanceof Vector3 ? (Vector3) obj3 : null;
                        if (vector3 == null) {
                            vector3 = Vector3.INSTANCE.getZERO();
                        }
                        CFrame identity = Intrinsics.areEqual(vector3, Vector3.INSTANCE.getZERO()) ? CFrame.INSTANCE.getIDENTITY() : CFrame.INSTANCE.fromOrientation((float) Math.toRadians(vector3.getX()), (float) Math.toRadians(vector3.getY()), (float) Math.toRadians(vector3.getZ()));
                        GLES20.glUniformMatrix3fv(this.kRot, 1, false, new float[]{identity.getR00(), identity.getR10(), identity.getR20(), identity.getR01(), identity.getR11(), identity.getR21(), identity.getR02(), identity.getR12(), identity.getR22()}, 0);
                        float f = (this.dayFactor * 0.65f) + 0.35f;
                        GLES20.glUniform3f(this.kTint, f, f, f);
                        GLES20.glUniform1i(this.kTex, 0);
                        GLES20.glActiveTexture(33984);
                        Mesh mesh2 = this.skyboxMesh;
                        if (mesh2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("skyboxMesh");
                        } else {
                            mesh = mesh2;
                        }
                        GLES20.glBindBuffer(34962, mesh.getVbo());
                        GLES20.glEnableVertexAttribArray(this.kaPos);
                        GLES20.glVertexAttribPointer(this.kaPos, 3, 5126, false, 20, 0);
                        GLES20.glEnableVertexAttribArray(this.kaUv);
                        GLES20.glVertexAttribPointer(this.kaUv, 2, 5126, false, 20, 12);
                        for (int i3 = 0; i3 < 6; i3++) {
                            GLES20.glBindTexture(3553, iArr[i3]);
                            GLES20.glDrawArrays(4, i3 * 6, 6);
                        }
                        GLES20.glDisableVertexAttribArray(this.kaUv);
                        GLES20.glBindTexture(3553, this.shadowTex);
                        GLES20.glEnable(2884);
                        GLES20.glDepthMask(true);
                        GLES20.glEnable(2929);
                        return true;
                    }
                    Object obj4 = instance.get(this.SKY_FACES[i]);
                    String obj5 = (obj4 == null || (obj2 = obj4.toString()) == null) ? null : StringsKt.trim((CharSequence) obj2).toString();
                    if (obj5 == null) {
                        obj5 = "";
                    }
                    if ((obj5.length() == 0) || AssetFetcher.INSTANCE.idOf(obj5) == null) {
                        break;
                    }
                    iArr[i] = assetTexture(obj5, false);
                    i++;
                }
                return false;
            }
        }
        return false;
    }

    private final void drawStaticBatches() {
        if (this.batches.getVisible().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<StaticBatches.Chunk> it = this.batches.getVisible().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            StaticBatches.Chunk next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            StaticBatches.Chunk chunk = next;
            for (StaticBatches.Batch batch : chunk.getBatches()) {
                if (chunk.getDist() <= this.batches.tierRange(batch.getTier(), this.detailScale)) {
                    arrayList.add(batch);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        CollectionsKt.sortWith(arrayList, ComparisonsKt.compareBy(new SceneRenderer$$ExternalSyntheticLambda2(), new SceneRenderer$$ExternalSyntheticLambda3(), new SceneRenderer$$ExternalSyntheticLambda4()));
        int i = -1;
        TexBind texBind = null;
        Iterator it2 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next2 = it2.next();
            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
            StaticBatches.Batch batch2 = (StaticBatches.Batch) next2;
            if (batch2.getKind() != i) {
                if (i == 3) {
                    GLES20.glEnable(2884);
                }
                i = batch2.getKind();
                this.activeLit = null;
                if (i == 3) {
                    useMeshBatch();
                    GLES20.glDisable(2884);
                } else {
                    switchLit(batchProgram(i));
                }
                texBind = null;
            }
            if (i == 3) {
                drawMeshBatch(batch2);
            } else {
                TexBind tex = batch2.getTex();
                if (tex != null && !Intrinsics.areEqual(tex, texBind)) {
                    bindTextures(tex);
                    texBind = tex;
                }
                drawBatch(batch2);
            }
        }
        if (i == 3) {
            GLES20.glEnable(2884);
        }
        endBatches();
        this.activeLit = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Comparable drawStaticBatches$lambda$10(StaticBatches.Batch it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Integer.valueOf(it.getKind());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Comparable drawStaticBatches$lambda$11(StaticBatches.Batch it) {
        Intrinsics.checkNotNullParameter(it, "it");
        TexBind tex = it.getTex();
        return Integer.valueOf(tex != null ? tex.getColor() : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Comparable drawStaticBatches$lambda$12(StaticBatches.Batch it) {
        Intrinsics.checkNotNullParameter(it, "it");
        TexBind tex = it.getTex();
        return Integer.valueOf(tex != null ? tex.getNormal() : 0);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:118|(2:120|(26:124|(1:126)(1:148)|(3:128|(1:130)|131)(1:147)|132|133|134|135|136|(1:138)(1:143)|139|(1:141)(1:142)|84|(1:86)(1:108)|(1:88)(1:107)|89|(1:91)(1:106)|(1:93)(1:105)|94|(1:96)|97|(1:99)|100|(1:102)|103|104|51))(1:150)|149|(0)(0)|(0)(0)|132|133|134|135|136|(0)(0)|139|(0)(0)|84|(0)(0)|(0)(0)|89|(0)(0)|(0)(0)|94|(0)|97|(0)|100|(0)|103|104|51) */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0296, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0297, code lost:
    
        r36 = r2;
        r28 = r5;
        r27 = r7;
        com.exampletest.mobilestudiotest.core.OutputLog.INSTANCE.warn("SurfaceGui " + r10.getName() + ": " + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0084, code lost:
    
        if (r0 == null) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x043e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drawSurfaceGuis() {
        /*
            Method dump skipped, instructions count: 1293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.SceneRenderer.drawSurfaceGuis():void");
    }

    private final void drawTemplateFace(Instance part, Geo g, int face, Region r) {
        FaceQuad faceQuad = faceQuad(g, face, 0.003f);
        setModel(g.getCf().times(faceQuad.getLocal()), new Vector3(faceQuad.getW(), faceQuad.getH(), 1.0f));
        GLES20.glUniformMatrix4fv(this.cModel, 1, false, this.model, 0);
        GLES20.glUniform3f(this.cNormal, faceQuad.getNormal().getX(), faceQuad.getNormal().getY(), faceQuad.getNormal().getZ());
        float x = (r.getX() + 0.5f) / this.TW;
        float y = (r.getY() + 0.5f) / this.TH;
        float w = (r.getW() - 1.0f) / this.TW;
        float h = (r.getH() - 1.0f) / this.TH;
        if (r.getFlip()) {
            GLES20.glUniform4f(this.cUv, -w, -h, x + w, y + h);
        } else {
            GLES20.glUniform4f(this.cUv, w, h, x, y);
        }
        Mesh mesh = this.quad;
        if (mesh == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quad");
            mesh = null;
        }
        drawUvMesh(mesh);
    }

    private final void drawUvMesh(Mesh m) {
        GLES20.glBindBuffer(34962, m.getVbo());
        GLES20.glEnableVertexAttribArray(this.caPos);
        GLES20.glVertexAttribPointer(this.caPos, 3, 5126, false, 20, 0);
        GLES20.glEnableVertexAttribArray(this.caUv);
        GLES20.glVertexAttribPointer(this.caUv, 2, 5126, false, 20, 12);
        GLES20.glDrawArrays(4, 0, m.getCount());
        GLES20.glDisableVertexAttribArray(this.caUv);
    }

    private final void endBatches() {
        int intValue;
        int[] locs;
        for (LitLocs litLocs : this.batchLit) {
            if (litLocs != null && (locs = litLocs.getLocs()) != null) {
                for (int i = 33; i < 38; i++) {
                    if (locs[i] >= 0) {
                        GLES20.glDisableVertexAttribArray(locs[i]);
                    }
                }
            }
        }
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{"aUv", "aCol"}).iterator();
        while (it.hasNext()) {
            Integer num = this.mb.get((String) it.next());
            if (num != null && (intValue = num.intValue()) >= 0) {
                GLES20.glDisableVertexAttribArray(intValue);
            }
        }
    }

    private final Bitmap faceBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawOval(0.335f * 256, 256 * 0.3f, 0.405f * 256, 256 * 0.46f, paint);
        canvas.drawOval(0.595f * 256, 256 * 0.3f, 0.665f * 256, 256 * 0.46f, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(256 * 0.038f);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Path path = new Path();
        path.moveTo(256 * 0.29f, 256 * 0.57f);
        path.cubicTo(256 * 0.36f, 256 * 0.75f, 0.64f * 256, 256 * 0.75f, 256 * 0.71f, 256 * 0.57f);
        canvas.drawPath(path, paint);
        return createBitmap;
    }

    private final FaceQuad faceQuad(Geo g, int faceId, float lift) {
        Pair pair;
        Vector3 scale = g.getScale();
        switch (faceId) {
            case 0:
                pair = TuplesKt.to(Vector3.INSTANCE.getX(), Vector3.INSTANCE.getY());
                break;
            case 1:
                pair = TuplesKt.to(Vector3.INSTANCE.getY(), new Vector3(0.0f, 0.0f, -1.0f));
                break;
            case 2:
                pair = TuplesKt.to(Vector3.INSTANCE.getZ(), Vector3.INSTANCE.getY());
                break;
            case 3:
                pair = TuplesKt.to(new Vector3(-1.0f, 0.0f, 0.0f), Vector3.INSTANCE.getY());
                break;
            case 4:
                pair = TuplesKt.to(new Vector3(0.0f, -1.0f, 0.0f), Vector3.INSTANCE.getZ());
                break;
            default:
                pair = TuplesKt.to(new Vector3(0.0f, 0.0f, -1.0f), Vector3.INSTANCE.getY());
                break;
        }
        Vector3 vector3 = (Vector3) pair.component1();
        Vector3 vector32 = (Vector3) pair.component2();
        Vector3 cross = vector32.cross(vector3);
        return new FaceQuad(CFrame.INSTANCE.fromColumns(vector3.times((faceQuad$extent(scale, vector3) / 2.0f) + lift), cross, vector32, vector3), faceQuad$extent(scale, cross), faceQuad$extent(scale, vector32), g.getCf().rotationOnly().times(vector3));
    }

    private static final float faceQuad$extent(Vector3 vector3, Vector3 vector32) {
        return (Math.abs(vector32.getX()) * vector3.getX()) + (Math.abs(vector32.getY()) * vector3.getY()) + (Math.abs(vector32.getZ()) * vector3.getZ());
    }

    private final GpuMesh fileMesh(Object content) {
        Long idOf = AssetFetcher.INSTANCE.idOf(content);
        if (idOf == null) {
            return null;
        }
        long longValue = idOf.longValue();
        GpuMesh gpuMesh = this.gpuMeshes.get(Long.valueOf(longValue));
        if (gpuMesh != null) {
            return gpuMesh;
        }
        MeshData meshData = MeshLoader.INSTANCE.get(longValue);
        if (meshData == null || meshData.getTriangles() == 0) {
            return null;
        }
        GpuMesh gpuMesh2 = new GpuMesh(Meshes.upload$default(Meshes.INSTANCE, meshData.getVerts(), 8, 4, null, 8, null), new Vector3(meshData.center(0), meshData.center(1), meshData.center(2)), new Vector3(meshData.size(0), meshData.size(1), meshData.size(2)));
        this.gpuMeshes.put(Long.valueOf(longValue), gpuMesh2);
        return gpuMesh2;
    }

    private final Geo geometry(Instance p) {
        int i;
        Geo unionGeo;
        Instance instance;
        Vector3 vector3;
        int i2;
        Mesh mesh;
        Mesh mesh2;
        Mesh mesh3;
        Mesh mesh4;
        Mesh mesh5;
        String obj;
        String str;
        char c;
        Object obj2;
        CFrame cframe = PartData.INSTANCE.cframe(p);
        Vector3 size = PartData.INSTANCE.size(p);
        if (Intrinsics.areEqual(p.getClassName(), "MeshPart")) {
            GpuMesh fileMesh = fileMesh(PartData.INSTANCE.meshContent(p));
            if (fileMesh != null) {
                Vector3 vector32 = new Vector3(geometry$lambda$40$k$37(size.getX(), fileMesh.getSize().getX()), geometry$lambda$40$k$37(size.getY(), fileMesh.getSize().getY()), geometry$lambda$40$k$37(size.getZ(), fileMesh.getSize().getZ()));
                String str2 = this.partTexOverride.get(p);
                if (str2 == null && (str2 = PartData.INSTANCE.textureContent(p)) == null) {
                    Iterator<T> it = p.getChildren().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            c = 0;
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        c = 0;
                        if (Intrinsics.areEqual(((Instance) obj2).getClassName(), "SurfaceAppearance")) {
                            break;
                        }
                    }
                    Instance instance2 = (Instance) obj2;
                    if (instance2 != null) {
                        PartData partData = PartData.INSTANCE;
                        String[] strArr = new String[2];
                        strArr[c] = "ColorMap";
                        strArr[1] = "ColorMapContent";
                        str = partData.content(instance2, strArr);
                    } else {
                        str = null;
                    }
                } else {
                    str = str2;
                }
                return new Geo(fileMesh.getMesh(), cframe.times(CFrame.INSTANCE.at(fileMesh.getCenter().times(vector32).unaryMinus())), vector32, 2, str, null, null, 96, null);
            }
            i = 0;
        } else {
            i = 0;
            if (p.isA("PartOperation") && !Intrinsics.areEqual(p.getClassName(), "NegateOperation") && (unionGeo = unionGeo(p, cframe)) != null) {
                return unionGeo;
            }
        }
        Iterator<Instance> it2 = p.getChildren().iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Instance next = it2.next();
            if (Intrinsics.areEqual(next.getClassName(), "SpecialMesh") || Intrinsics.areEqual(next.getClassName(), "BlockMesh") || Intrinsics.areEqual(next.getClassName(), "CylinderMesh") || Intrinsics.areEqual(next.getClassName(), "FileMesh")) {
                instance = next;
                break;
            }
        }
        instance = null;
        if (instance != null) {
            Object obj3 = instance.get("Scale");
            Vector3 vector33 = obj3 instanceof Vector3 ? (Vector3) obj3 : null;
            if (vector33 == null) {
                vector33 = new Vector3(1.0f, 1.0f, 1.0f);
            }
            Vector3 vector34 = vector33;
            Object obj4 = instance.get("Offset");
            Vector3 vector35 = obj4 instanceof Vector3 ? (Vector3) obj4 : null;
            if (vector35 == null) {
                vector35 = Vector3.INSTANCE.getZERO();
            }
            CFrame times = !Intrinsics.areEqual(vector35, Vector3.INSTANCE.getZERO()) ? cframe.times(CFrame.INSTANCE.at(vector35)) : cframe;
            if (Intrinsics.areEqual(instance.getClassName(), "SpecialMesh")) {
                Object obj5 = instance.get("MeshType");
                EnumValue enumValue = obj5 instanceof EnumValue ? (EnumValue) obj5 : null;
                i2 = enumValue != null ? enumValue.getValue() : i;
            } else {
                i2 = Intrinsics.areEqual(instance.getClassName(), "CylinderMesh") ? 4 : Intrinsics.areEqual(instance.getClassName(), "FileMesh") ? 5 : 6;
            }
            switch (i2) {
                case 0:
                    float min = Math.min(size.getX(), size.getZ());
                    Mesh mesh6 = this.head;
                    if (mesh6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("head");
                        mesh = null;
                    } else {
                        mesh = mesh6;
                    }
                    return new Geo(mesh, times, new Vector3(vector34.getX() * min, size.getY() * vector34.getY(), vector34.getZ() * min), 1, null, null, null, 112, null);
                case 1:
                case 6:
                    Mesh mesh7 = this.cube;
                    if (mesh7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cube");
                        mesh2 = null;
                    } else {
                        mesh2 = mesh7;
                    }
                    return new Geo(mesh2, times, size.times(vector34), 0, null, null, null, 112, null);
                case 2:
                    Mesh mesh8 = this.wedge;
                    if (mesh8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("wedge");
                        mesh3 = null;
                    } else {
                        mesh3 = mesh8;
                    }
                    return new Geo(mesh3, times, size.times(vector34), 0, null, null, null, 112, null);
                case 3:
                    Mesh mesh9 = this.sphere;
                    if (mesh9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sphere");
                        mesh4 = null;
                    } else {
                        mesh4 = mesh9;
                    }
                    return new Geo(mesh4, times, size.times(vector34), 0, null, null, null, 112, null);
                case 4:
                    Mesh mesh10 = this.cylinderY;
                    if (mesh10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cylinderY");
                        mesh5 = null;
                    } else {
                        mesh5 = mesh10;
                    }
                    return new Geo(mesh5, times, size.times(vector34), 0, null, null, null, 112, null);
                case 5:
                    GpuMesh fileMesh2 = fileMesh(instance.get("MeshId"));
                    if (fileMesh2 == null) {
                        break;
                    } else {
                        Object obj6 = instance.get("TextureId");
                        String str3 = (obj6 == null || (obj = obj6.toString()) == null || StringsKt.isBlank(obj)) ? null : obj;
                        Mesh mesh11 = fileMesh2.getMesh();
                        Object obj7 = instance.get("VertexColor");
                        return new Geo(mesh11, times, vector34, 2, str3, null, obj7 instanceof Vector3 ? (Vector3) obj7 : null, 32, null);
                    }
            }
        }
        int shape = PartData.INSTANCE.shape(p);
        switch (shape) {
            case 0:
                float min2 = Math.min(size.getX(), Math.min(size.getY(), size.getZ()));
                vector3 = new Vector3(min2, min2, min2);
                break;
            case 1:
            default:
                vector3 = size;
                break;
            case 2:
                float min3 = Math.min(size.getY(), size.getZ());
                vector3 = new Vector3(size.getX(), min3, min3);
                break;
        }
        return new Geo(meshFor(shape), cframe, vector3, 0, null, null, null, 112, null);
    }

    private static final float geometry$lambda$40$k$37(float f, float f2) {
        if (f2 > 1.0E-5f) {
            return f / f2;
        }
        return 1.0f;
    }

    private final int gridTexture() {
        if (this.gridTex == 0) {
            Bitmap createBitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
            Paint paint = new Paint(1);
            paint.setColor(-1);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(6.0f);
            new Canvas(createBitmap).drawRect(0.0f, 0.0f, 256, 256, paint);
            this.gridTex = upload(createBitmap, true);
        }
        return this.gridTex;
    }

    private final boolean inView(CFrame cf, Vector3 size, Vector3 camPos) {
        float magnitude = size.getMagnitude() * 0.5f;
        if (!this.frustum.sphere(cf.getX(), cf.getY(), cf.getZ(), magnitude)) {
            return false;
        }
        float x = cf.getX() - camPos.getX();
        float y = cf.getY() - camPos.getY();
        float z = cf.getZ() - camPos.getZ();
        float sqrt = (float) Math.sqrt((x * x) + (y * y) + (z * z));
        if (magnitude < 5.0f && sqrt > this.detailScale * magnitude) {
            if (sqrt > (magnitude < 1.2f ? 150.0f : 900.0f)) {
                return false;
            }
        }
        float f = sqrt - magnitude;
        if (f >= this.closest) {
            return true;
        }
        this.closest = RangesKt.coerceAtLeast(f, 0.0f);
        return true;
    }

    private final boolean isBatchable(Instance p) {
        if (!this.BATCH_CLASSES.contains(p.getClassName()) || PartData.INSTANCE.transparency(p) > 0.001f || Intrinsics.areEqual(p.get("CastShadow"), (Object) false)) {
            return false;
        }
        switch (PartData.INSTANCE.material(p)) {
            case 1568:
            case 1584:
                return false;
            default:
                String[] strArr = this.SURFACES;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        for (Instance parent = p.getParent(); parent != null && !(parent instanceof DataModel); parent = parent.getParent()) {
                            if (Intrinsics.areEqual(parent.getClassName(), "Model") && parent.findFirstChildOfClass("Humanoid") != null) {
                                return false;
                            }
                        }
                        return true;
                    }
                    Object obj = p.get(strArr[i]);
                    EnumValue enumValue = obj instanceof EnumValue ? (EnumValue) obj : null;
                    int value = enumValue != null ? enumValue.getValue() : 0;
                    if (6 <= value && value < 9) {
                        return false;
                    }
                    i++;
                }
                break;
        }
    }

    private final LitLocs litLocs(int prog) {
        return new LitLocs(prog, new int[]{litLocs$u(prog, "uVP"), litLocs$u(prog, "uModel"), litLocs$u(prog, "uNrm"), litLocs$u(prog, "uColor"), litLocs$u(prog, "uLight"), litLocs$u(prog, "uCam"), litLocs$u(prog, "uEmissive"), litLocs$u(prog, "uGrid"), litLocs$u(prog, "uSize"), litLocs$u(prog, "uHorizon"), litLocs$u(prog, "uZenith"), litLocs$u(prog, "uSun"), litLocs$u(prog, "uAmbient"), litLocs$u(prog, "uFogColor"), litLocs$u(prog, "uFog"), litLocs$u(prog, "uMat"), litLocs$u(prog, "uSurfA"), litLocs$u(prog, "uSurfB"), litLocs$u(prog, "uShadow"), litLocs$u(prog, "uShadowOn"), litLocs$u(prog, "uShadowTexel"), litLocs$u(prog, "uShadowVP"), litLocs$u(prog, "uExposure"), litLocs$u(prog, "uTime"), litLocs$u(prog, "uTruss"), GLES20.glGetAttribLocation(prog, "aPos"), GLES20.glGetAttribLocation(prog, "aNrm"), litLocs$u(prog, "uMatTex"), litLocs$u(prog, "uMatNrm"), litLocs$u(prog, "uTexScale"), litLocs$u(prog, "uHasNrm"), litLocs$u(prog, "uSurfTex"), litLocs$u(prog, "uHasSurfTex"), GLES20.glGetAttribLocation(prog, "aUv"), GLES20.glGetAttribLocation(prog, "aCol"), GLES20.glGetAttribLocation(prog, "aMat"), GLES20.glGetAttribLocation(prog, "aTan"), GLES20.glGetAttribLocation(prog, "aBit")});
    }

    private static final int litLocs$u(int i, String str) {
        return GLES20.glGetUniformLocation(i, str);
    }

    private final float luma(Color3 c) {
        return (c.getR() * 0.3f) + (c.getG() * 0.59f) + (c.getB() * 0.11f);
    }

    private final float[] material(int m) {
        float[] fArr;
        HashMap<Integer, float[]> hashMap = this.matCache;
        Integer valueOf = Integer.valueOf(m);
        float[] fArr2 = hashMap.get(valueOf);
        if (fArr2 == null) {
            fArr = materialParams(m);
            hashMap.put(valueOf, fArr);
        } else {
            fArr = fArr2;
        }
        return fArr;
    }

    private final TexBind materialBind(int mat) {
        MaterialTextures.MatTex matTex;
        TexBind texBind;
        if (!MaterialTextures.INSTANCE.hasTexture(mat) || (matTex = MaterialTextures.INSTANCE.get(mat, this.modernMaterialsNow)) == null) {
            return null;
        }
        IdentityHashMap<MaterialTextures.MatTex, TexBind> identityHashMap = this.matTexGpu;
        TexBind texBind2 = identityHashMap.get(matTex);
        if (texBind2 == null) {
            Bitmap color = matTex.getColor();
            int upload = color != null ? upload(color, true) : whiteTex();
            Bitmap normal = matTex.getNormal();
            texBind = new TexBind(upload, normal != null ? upload(normal, true) : 0, 1.0f / matTex.getStudsPerTile());
            identityHashMap.put(matTex, texBind);
        } else {
            texBind = texBind2;
        }
        return texBind;
    }

    private final float[] materialParams(int m) {
        switch (m) {
            case ClothingCompositor.TORSO_H /* 272 */:
                return new float[]{0.0f, 0.0f, 1.0f, 0.22f};
            case 288:
                return new float[]{0.0f, 0.0f, 1.0f, 0.0f};
            case 512:
                return new float[]{2.0f, 0.14f, 1.0f, 0.06f};
            case 528:
                return new float[]{3.0f, 0.12f, 1.0f, 0.06f};
            case 784:
                return new float[]{11.0f, 0.1f, 0.25f, 0.45f};
            case 788:
                return new float[]{13.0f, 0.16f, 0.9f, 0.08f};
            case 800:
                return new float[]{12.0f, 0.16f, 0.35f, 0.12f};
            case 804:
                return new float[]{14.0f, 0.22f, 0.7f, 0.1f};
            case 816:
                return new float[]{23.0f, 0.1f, 1.4f, 0.04f};
            case 820:
                return new float[]{5.0f, 0.09f, 0.5f, 0.05f};
            case 832:
                return new float[]{24.0f, 0.13f, 2.5f, 0.2f};
            case 836:
                return new float[]{16.0f, 0.08f, 4.0f, 0.04f};
            case 848:
                return new float[]{4.0f, 0.12f, 1.0f, 0.04f};
            case 864:
                return new float[]{13.0f, 0.2f, 2.2f, 0.12f};
            case 880:
                return new float[]{13.0f, 0.24f, 0.8f, 0.08f};
            case 896:
                return new float[]{5.0f, 0.17f, 0.4f, 0.08f};
            case 912:
                return new float[]{12.0f, 0.1f, 0.8f, 0.05f};
            case 1040:
                return new float[]{15.0f, 0.2f, 0.6f, 0.3f};
            case 1056:
                return new float[]{6.0f, 0.14f, 1.0f, 0.7f};
            case 1072:
                return new float[]{7.0f, 0.07f, 2.0f, 0.9f};
            case 1088:
                return new float[]{7.0f, 0.06f, 1.5f, 0.7f};
            case 1280:
                return new float[]{8.0f, 0.16f, 1.5f, 0.04f};
            case 1284:
                return new float[]{8.0f, 0.2f, 1.2f, 0.04f};
            case 1296:
                return new float[]{25.0f, 0.08f, 3.0f, 0.04f};
            case 1312:
                return new float[]{9.0f, 0.08f, 4.0f, 0.02f};
            case 1328:
                return new float[]{25.0f, 0.05f, 1.0f, 0.3f};
            case 1344:
                return new float[]{5.0f, 0.14f, 0.6f, 0.15f};
            case 1360:
                return new float[]{5.0f, 0.15f, 0.8f, 0.03f};
            case 1376:
                return new float[]{22.0f, 0.09f, 4.0f, 0.05f};
            case 1392:
                return new float[]{25.0f, 0.07f, 2.0f, 0.15f};
            case 1536:
                return new float[]{10.0f, 0.05f, 0.3f, 0.9f};
            case 1552:
                return new float[]{10.0f, 0.08f, 0.3f, 0.8f};
            case 1568:
                return new float[]{0.0f, 0.0f, 1.0f, 1.0f};
            case 1584:
                return new float[]{19.0f, 0.0f, 1.0f, 0.0f};
            case 2304:
                return new float[]{18.0f, 0.06f, 1.0f, 0.03f};
            case 2305:
                return new float[]{21.0f, 0.12f, 1.0f, 0.01f};
            case 2306:
                return new float[]{16.0f, 0.06f, 2.0f, 0.5f};
            case 2307:
                return new float[]{17.0f, 0.12f, 1.0f, 0.1f};
            case 2308:
                return new float[]{17.0f, 0.16f, 0.7f, 0.05f};
            case 2309:
                return new float[]{20.0f, 0.1f, 1.0f, 0.15f};
            case 2310:
                return new float[]{5.0f, 0.05f, 0.4f, 0.04f};
            case 2311:
                return new float[]{1.0f, 0.02f, 3.0f, 0.08f};
            default:
                return new float[]{0.0f, 0.0f, 1.0f, 0.28f};
        }
    }

    private final int meshBatchProgram() {
        if (this.meshBatchProg != 0) {
            return this.meshBatchProg;
        }
        int program = program("#define BATCH 1\n\nuniform mat4 uVP; uniform mat4 uModel; uniform mat3 uNrm; uniform mat4 uShadowVP;\nvarying vec3 vN; varying vec3 vW; varying vec2 vUv; varying vec4 vS;\n#ifdef BATCH\nattribute vec3 aPos; attribute vec4 aNrm; attribute vec2 aUv; attribute vec4 aCol;\nvarying vec4 vCol;\nvoid main() {\n  vW = aPos; vN = aNrm.xyz; vUv = aUv; vS = uShadowVP * vec4(aPos, 1.0); vCol = aCol;\n  gl_Position = uVP * vec4(aPos, 1.0);\n}\n#else\nattribute vec3 aPos; attribute vec3 aNrm; attribute vec2 aUv;\nvoid main() {\n  vec4 w = uModel * vec4(aPos, 1.0);\n  vW = w.xyz; vN = uNrm * aNrm; vUv = aUv; vS = uShadowVP * w;\n  gl_Position = uVP * w;\n}\n#endif", "#define BATCH 1\n\n#ifdef GL_FRAGMENT_PRECISION_HIGH\nprecision highp float;\n#else\nprecision mediump float;\n#endif\nvarying vec3 vN; varying vec3 vW; varying vec2 vUv; varying vec4 vS;\nuniform vec4 uColor; uniform vec3 uTint; uniform vec3 uLight; uniform vec3 uSun; uniform float uAmbient; uniform vec3 uCam;\nuniform sampler2D uTex; uniform float uHasTex; uniform sampler2D uShadow; uniform float uShadowOn; uniform vec2 uShadowTexel;\nuniform vec3 uFogColor; uniform vec3 uFog; uniform float uExposure; uniform float uEmissive; uniform vec3 uHorizon; uniform vec3 uZenith;\nfloat unpackDepth(vec4 c) { return dot(c, vec4(1.0, 1.0 / 255.0, 1.0 / 65025.0, 1.0 / 16581375.0)); }\nfloat shadowAt(float ndl) {\n  if (uShadowOn < 0.5 || ndl <= 0.0) return 1.0;\n  vec3 p = vS.xyz / vS.w * 0.5 + 0.5;\n  if (p.x <= 0.001 || p.x >= 0.999 || p.y <= 0.001 || p.y >= 0.999 || p.z >= 1.0) return 1.0;\n  float z = p.z - (0.0015 + 0.004 * (1.0 - ndl));\n  vec2 t = uShadowTexel;\n  float s = (z > unpackDepth(texture2D(uShadow, p.xy)) ? 0.0 : 2.0);\n  s += (z > unpackDepth(texture2D(uShadow, p.xy + vec2(t.x, t.y))) ? 0.0 : 1.0);\n  s += (z > unpackDepth(texture2D(uShadow, p.xy - vec2(t.x, t.y))) ? 0.0 : 1.0);\n  return s / 4.0;\n}\n#ifdef BATCH\nvarying vec4 vCol;\n#endif\nvoid main() {\n  vec3 n = normalize(vN);\n  if (!gl_FrontFacing) n = -n;\n#ifdef BATCH\n  vec3 c = vCol.rgb; float a = 1.0; float emis = vCol.a; vec3 tint = vec3(1.0);\n#else\n  vec3 c = uColor.rgb; float a = uColor.a; float emis = uEmissive; vec3 tint = uTint;\n#endif\n  if (uHasTex > 0.5) {\n    vec4 t = texture2D(uTex, vUv);\n    // Texture over the part color (where the texture is see-through the color shows).\n    c = mix(c, t.rgb / max(t.a, 0.001), t.a);\n  }\n  c *= tint;\n  vec3 col;\n  if (emis > 0.5) col = c * 1.15;\n  else {\n    float ndl = dot(n, uLight);\n    float sh = shadowAt(ndl);\n    vec3 sky = mix(uHorizon, uZenith, 0.5);\n    vec3 amb = uAmbient * mix(vec3(0.82), mix(vec3(1.0), sky * 1.2, 0.35), 0.5 + 0.5 * n.y);\n    col = c * (amb + uSun * max(ndl, 0.0) * sh);\n  }\n  col *= uExposure;\n  float dist = length(uCam - vW);\n  float fog;\n  if (uFog.z > 1.5) fog = (1.0 - exp(-dist * uFog.x)) * uFog.y;\n  else if (uFog.z > 0.5) fog = clamp((dist - uFog.x) / max(uFog.y - uFog.x, 1.0), 0.0, 1.0);\n  else fog = smoothstep(900.0, 5000.0, dist) * 0.7;\n  gl_FragColor = vec4(mix(col, uFogColor, fog), a);\n}");
        for (String str : CollectionsKt.listOf((Object[]) new String[]{"uVP", "uShadowVP", "uLight", "uSun", "uAmbient", "uCam", "uFogColor", "uFog", "uExposure", "uShadowOn", "uShadowTexel", "uHorizon", "uZenith", "uShadow", "uTex", "uHasTex"})) {
            this.mb.put(str, Integer.valueOf(GLES20.glGetUniformLocation(program, str)));
        }
        for (String str2 : CollectionsKt.listOf((Object[]) new String[]{"aPos", "aNrm", "aUv", "aCol"})) {
            this.mb.put(str2, Integer.valueOf(GLES20.glGetAttribLocation(program, str2)));
        }
        this.meshBatchProg = program;
        return program;
    }

    private final Mesh meshFor(int shape) {
        Mesh mesh;
        String str;
        switch (shape) {
            case 0:
                mesh = this.sphere;
                if (mesh == null) {
                    str = "sphere";
                    break;
                }
                return mesh;
            case 1:
            default:
                mesh = this.cube;
                if (mesh == null) {
                    str = "cube";
                    break;
                }
                return mesh;
            case 2:
                mesh = this.cylinder;
                if (mesh == null) {
                    str = "cylinder";
                    break;
                }
                return mesh;
            case 3:
                mesh = this.wedge;
                if (mesh == null) {
                    str = "wedge";
                    break;
                }
                return mesh;
            case 4:
                mesh = this.corner;
                if (mesh == null) {
                    str = "corner";
                    break;
                }
                return mesh;
        }
        Intrinsics.throwUninitializedPropertyAccessException(str);
        return null;
    }

    private final void mix(float[] a, float[] b, float t, float[] out) {
        for (int i = 0; i < 3; i++) {
            out[i] = a[i] + ((b[i] - a[i]) * t);
        }
    }

    private final boolean needsAdvanced(int mat) {
        return material(mat)[0] > 1.5f;
    }

    private static final int onSurfaceCreated$u$23(int i, String str) {
        return GLES20.glGetUniformLocation(i, str);
    }

    private final int program(String vs, String fs) {
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, compile(35633, vs));
        GLES20.glAttachShader(glCreateProgram, compile(35632, fs));
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            OutputLog.INSTANCE.error("Shader link error: " + GLES20.glGetProgramInfoLog(glCreateProgram));
        }
        return glCreateProgram;
    }

    private final void r15Clothing(Instance rig, List<? extends Instance> items) {
        Object obj;
        Object obj2;
        Object obj3;
        String str;
        String r15ColorKey;
        Object obj4;
        String obj5;
        Object obj6;
        String obj7;
        Object obj8;
        String obj9;
        Avatar avatar = Avatar.INSTANCE;
        Iterator<T> it = items.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(((Instance) obj).getClassName(), "Shirt")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Instance instance = (Instance) obj;
        String str2 = (instance == null || (obj8 = instance.get("ShirtTemplate")) == null || (obj9 = obj8.toString()) == null || StringsKt.isBlank(obj9)) ? null : obj9;
        Iterator<T> it2 = items.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj2 = it2.next();
                if (Intrinsics.areEqual(((Instance) obj2).getClassName(), "Pants")) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        Instance instance2 = (Instance) obj2;
        String str3 = (instance2 == null || (obj6 = instance2.get("PantsTemplate")) == null || (obj7 = obj6.toString()) == null || StringsKt.isBlank(obj7)) ? null : obj7;
        Iterator<T> it3 = items.iterator();
        while (true) {
            if (it3.hasNext()) {
                obj3 = it3.next();
                if (Intrinsics.areEqual(((Instance) obj3).getClassName(), "ShirtGraphic")) {
                    break;
                }
            } else {
                obj3 = null;
                break;
            }
        }
        Instance instance3 = (Instance) obj3;
        String str4 = (instance3 == null || (obj4 = instance3.get("Graphic")) == null || (obj5 = obj4.toString()) == null || StringsKt.isBlank(obj5)) ? null : obj5;
        if (str2 == null && str3 == null && str4 == null) {
            return;
        }
        ArrayList<Instance> children = rig.getChildren();
        ArrayList arrayList = new ArrayList();
        for (Object obj10 : children) {
            if (((Instance) obj10).isA("BasePart")) {
                arrayList.add(obj10);
            }
        }
        ArrayList<Instance> arrayList2 = arrayList;
        HashMap hashMap = new HashMap();
        for (Instance instance4 : arrayList2) {
            String r15GroupOf = avatar.r15GroupOf(instance4.getName());
            if (r15GroupOf != null && (r15ColorKey = avatar.r15ColorKey(r15GroupOf)) != null) {
            }
        }
        Set entrySet = hashMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        String str5 = str2 + "|" + str3 + "|" + str4 + "|" + CollectionsKt.joinToString$default(CollectionsKt.sortedWith(entrySet, new SceneRenderer$r15Clothing$$inlined$sortedBy$1()), ",", null, null, 0, null, new SceneRenderer$$ExternalSyntheticLambda0(), 30, null);
        Map<String, String> map = this.r15Tex.get(str5);
        if (map == null) {
            if (this.r15Pending.add(str5)) {
                this.r15Pool.execute(new SceneRenderer$$ExternalSyntheticLambda1(this, str2, str3, str4, str5, avatar, hashMap, rig));
                return;
            }
            return;
        }
        for (Instance instance5 : arrayList2) {
            String r15GroupOf2 = avatar.r15GroupOf(instance5.getName());
            if (r15GroupOf2 != null && (str = map.get(r15GroupOf2)) != null) {
                this.nextOverride.put(instance5, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence r15Clothing$lambda$85(Map.Entry it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getKey() + "=" + ((Color3) it.getValue()).toHex();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0138 A[Catch: all -> 0x016c, TryCatch #7 {all -> 0x016c, blocks: (B:24:0x00dc, B:26:0x012c, B:28:0x0138, B:29:0x013e, B:33:0x013b, B:35:0x00ec), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x013b A[Catch: all -> 0x016c, TryCatch #7 {all -> 0x016c, blocks: (B:24:0x00dc, B:26:0x012c, B:28:0x0138, B:29:0x013e, B:33:0x013b, B:35:0x00ec), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void r15Clothing$lambda$87(com.exampletest.mobilestudiotest.render.SceneRenderer r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, com.exampletest.mobilestudiotest.engine.Avatar r31, java.util.HashMap r32, com.exampletest.mobilestudiotest.model.Instance r33) {
        /*
            Method dump skipped, instructions count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.SceneRenderer.r15Clothing$lambda$87(com.exampletest.mobilestudiotest.render.SceneRenderer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.exampletest.mobilestudiotest.engine.Avatar, java.util.HashMap, com.exampletest.mobilestudiotest.model.Instance):void");
    }

    private final void refreshVariants() {
        LinkedHashMap emptyMap;
        Object obj;
        List descendants$default;
        List<? extends Instance> list;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.variantIndexAt < 500) {
            return;
        }
        this.variantIndexAt = currentTimeMillis;
        this.variantBinds.clear();
        Instance findService = this.studio.getModel().findService("MaterialService");
        this.variantService = findService;
        if (findService == null || (descendants$default = Instance.descendants$default(findService, null, 1, null)) == null) {
            emptyMap = MapsKt.emptyMap();
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : descendants$default) {
                if (Intrinsics.areEqual(((Instance) obj2).getClassName(), "MaterialVariant")) {
                    arrayList.add(obj2);
                }
            }
            emptyMap = new LinkedHashMap();
            for (Object obj3 : arrayList) {
                String name = ((Instance) obj3).getName();
                List<? extends Instance> list2 = emptyMap.get(name);
                if (list2 == null) {
                    list = new ArrayList();
                    emptyMap.put(name, list);
                } else {
                    list = list2;
                }
                list.add(obj3);
            }
        }
        this.variantIndex = emptyMap;
        if (findService != null) {
            Object obj4 = findService.get("Use2022MaterialsXml");
            if (obj4 == null) {
                obj4 = findService.get("Use2022Materials");
            }
            obj = obj4;
        } else {
            obj = null;
        }
        boolean z = false;
        if (Settings.INSTANCE.getModernMaterials() && !Intrinsics.areEqual(obj, (Object) false)) {
            z = true;
        }
        if (z != this.modernMaterialsNow) {
            this.modernMaterialsNow = z;
            this.batches.reset(true);
        }
    }

    private final void renderShadowMap(Vector3 focus, float radius) {
        Mesh mesh;
        Iterator<Instance> it;
        ArrayList listOf;
        List list;
        Iterator it2;
        SceneRenderer sceneRenderer = this;
        PlaySession play = sceneRenderer.studio.getPlay();
        Vector3 z = Math.abs(sceneRenderer.sunDir.getY()) > 0.99f ? Vector3.INSTANCE.getZ() : Vector3.INSTANCE.getY();
        Vector3 unit = sceneRenderer.sunDir.unaryMinus().getUnit();
        Vector3 unit2 = unit.cross(z).getUnit();
        float f = (2.0f * radius) / sceneRenderer.shadowSize;
        Vector3 plus = unit2.times(((float) Math.floor(focus.dot(unit2) / f)) * f).plus(unit2.cross(unit).getUnit().times(((float) Math.floor(focus.dot(r14) / f)) * f)).plus(unit.times(focus.dot(unit)));
        Vector3 plus2 = plus.plus(sceneRenderer.sunDir.times(600.0f));
        Matrix.setLookAtM(sceneRenderer.lightView, 0, plus2.getX(), plus2.getY(), plus2.getZ(), plus.getX(), plus.getY(), plus.getZ(), z.getX(), z.getY(), z.getZ());
        Matrix.orthoM(sceneRenderer.lightProj, 0, -radius, radius, -radius, radius, 1.0f, 1300.0f);
        Matrix.multiplyMM(sceneRenderer.lightVP, 0, sceneRenderer.lightProj, 0, sceneRenderer.lightView, 0);
        long j = Instance.changeCount;
        sceneRenderer.shadowAge++;
        if (sceneRenderer.shadowValid && sceneRenderer.studio.isPlaying() && sceneRenderer.fps < 20.0f && sceneRenderer.frames % 2 == 1) {
            ArraysKt.copyInto$default(sceneRenderer.lastLightVP, sceneRenderer.lightVP, 0, 0, 0, 14, (Object) null);
            return;
        }
        if (sceneRenderer.shadowValid && j == sceneRenderer.lastShadowChange && MeshLoader.INSTANCE.getEpoch() == sceneRenderer.lastShadowMeshEpoch && sceneRenderer.shadowAge < 45 && Arrays.equals(sceneRenderer.lightVP, sceneRenderer.lastLightVP)) {
            return;
        }
        sceneRenderer.shadowValid = true;
        sceneRenderer.lastShadowChange = j;
        sceneRenderer.lastShadowMeshEpoch = MeshLoader.INSTANCE.getEpoch();
        sceneRenderer.shadowAge = 0;
        ArraysKt.copyInto$default(sceneRenderer.lightVP, sceneRenderer.lastLightVP, 0, 0, 0, 14, (Object) null);
        GLES20.glBindFramebuffer(36160, sceneRenderer.shadowFbo);
        GLES20.glViewport(0, 0, sceneRenderer.shadowSize, sceneRenderer.shadowSize);
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(sceneRenderer.depthProg);
        GLES20.glUniformMatrix4fv(sceneRenderer.dVP, 1, false, sceneRenderer.lightVP, 0);
        GLES20.glCullFace(1028);
        float f2 = radius * 1.6f * 1.6f * radius;
        Matrix.setIdentityM(sceneRenderer.model, 0);
        GLES20.glUniformMatrix4fv(sceneRenderer.dModel, 1, false, sceneRenderer.model, 0);
        GLES20.glEnableVertexAttribArray(sceneRenderer.daPos);
        Iterator<StaticBatches.Chunk> it3 = sceneRenderer.batches.getVisible().iterator();
        Intrinsics.checkNotNullExpressionValue(it3, "iterator(...)");
        while (it3.hasNext()) {
            StaticBatches.Chunk next = it3.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            StaticBatches.Chunk chunk = next;
            float max = Math.max(Math.max(chunk.getX0() - plus.getX(), 0.0f), plus.getX() - chunk.getX1());
            float max2 = Math.max(Math.max(chunk.getZ0() - plus.getZ(), 0.0f), plus.getZ() - chunk.getZ1());
            if ((max * max) + (max2 * max2) <= f2) {
                for (StaticBatches.Batch batch : chunk.getBatches()) {
                    float f3 = max2;
                    long j2 = j;
                    if (batch.getTier() >= 2 || chunk.getDist() <= sceneRenderer.batches.tierRange(batch.getTier(), sceneRenderer.detailScale)) {
                        GLES20.glBindBuffer(34962, batch.getVbo());
                        GLES20.glVertexAttribPointer(sceneRenderer.daPos, 3, 5126, false, batch.getStrideBytes(), 0);
                        if (batch.getKind() == 3) {
                            GLES20.glDisable(2884);
                        }
                        GLES20.glDrawArrays(4, 0, batch.getCount());
                        if (batch.getKind() == 3) {
                            GLES20.glEnable(2884);
                            max2 = f3;
                            j = j2;
                        } else {
                            max2 = f3;
                            j = j2;
                        }
                    } else {
                        max2 = f3;
                        j = j2;
                    }
                }
            }
        }
        Mesh mesh2 = null;
        Iterator<Instance> it4 = sceneRenderer.batches.getLoose().iterator();
        Intrinsics.checkNotNullExpressionValue(it4, "iterator(...)");
        while (it4.hasNext()) {
            Instance next2 = it4.next();
            if (PartData.INSTANCE.transparency(next2) > 0.5f || Intrinsics.areEqual(next2.get("CastShadow"), (Object) false)) {
                mesh = mesh2;
                it = it4;
            } else if (Intrinsics.areEqual(next2.getClassName(), "NegateOperation")) {
                mesh = mesh2;
                it = it4;
            } else if (play != null && play.hiddenInFirstPerson(next2)) {
                mesh = mesh2;
                it = it4;
            } else {
                Geo geometry = sceneRenderer.geometry(next2);
                float x = geometry.getCf().getX() - plus.getX();
                float z2 = geometry.getCf().getZ() - plus.getZ();
                float magnitude = geometry.getScale().getMagnitude() * 0.5f;
                if ((x * x) + (z2 * z2) <= f2 + (magnitude * magnitude * 4.0f) || magnitude >= radius) {
                    Mesh mesh3 = mesh2;
                    sceneRenderer.setModel(geometry.getCf(), geometry.getScale());
                    Iterator<Instance> it5 = it4;
                    GLES20.glUniformMatrix4fv(sceneRenderer.dModel, 1, false, sceneRenderer.model, 0);
                    List<Pair<Mesh, Color3>> subs = geometry.getSubs();
                    if (subs != null) {
                        List<Pair<Mesh, Color3>> list2 = subs;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        Iterator<T> it6 = list2.iterator();
                        while (it6.hasNext()) {
                            arrayList.add((Mesh) ((Pair) it6.next()).getFirst());
                            list2 = list2;
                        }
                        listOf = arrayList;
                    } else {
                        listOf = CollectionsKt.listOf(geometry.getMesh());
                    }
                    Iterator it7 = listOf.iterator();
                    Mesh mesh4 = mesh3;
                    while (it7.hasNext()) {
                        Mesh mesh5 = (Mesh) it7.next();
                        if (mesh5 != mesh4) {
                            list = listOf;
                            it2 = it7;
                            sceneRenderer.bind(mesh5, sceneRenderer.daPos, -1);
                            mesh4 = mesh5;
                        } else {
                            list = listOf;
                            it2 = it7;
                        }
                        GLES20.glDrawArrays(mesh5.getMode(), 0, mesh5.getCount());
                        sceneRenderer = this;
                        listOf = list;
                        it7 = it2;
                    }
                    sceneRenderer = this;
                    mesh2 = mesh4;
                    it4 = it5;
                } else {
                    mesh = mesh2;
                    it = it4;
                }
            }
            sceneRenderer = this;
            mesh2 = mesh;
            it4 = it;
        }
        GLES20.glCullFace(1029);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private final void segment(Vector3 a, Vector3 b, float thick) {
        Vector3 minus = b.minus(a);
        float magnitude = minus.getMagnitude();
        if (magnitude < 1.0E-4f) {
            return;
        }
        setModel(CFrame.INSTANCE.lookAt(a.plus(b).div(2.0f), b, Math.abs(minus.getY() / magnitude) > 0.95f ? Vector3.INSTANCE.getZ() : Vector3.INSTANCE.getY()), new Vector3(thick, thick, (0.5f * thick) + magnitude));
        GLES20.glUniformMatrix4fv(this.uModel, 1, false, this.model, 0);
        GLES20.glUniformMatrix3fv(this.uNrm, 1, false, this.normal, 0);
        Mesh mesh = this.cube;
        if (mesh == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cube");
            mesh = null;
        }
        GLES20.glDrawArrays(4, 0, mesh.getCount());
    }

    private final void setLitFrameUniforms(boolean shadows) {
        GLES20.glUniformMatrix4fv(this.uVP, 1, false, this.studio.getView().getVp(), 0);
        GLES20.glUniformMatrix4fv(this.uShadowVP, 1, false, this.lightVP, 0);
        GLES20.glUniform3f(this.uLight, this.sunDir.getX(), this.sunDir.getY(), this.sunDir.getZ());
        Vector3 camPos = this.studio.getView().getCamPos();
        GLES20.glUniform3f(this.uCam, camPos.getX(), camPos.getY(), camPos.getZ());
        GLES20.glUniform3fv(this.uHorizon, 1, this.horizon, 0);
        GLES20.glUniform3fv(this.uZenith, 1, this.zenith, 0);
        GLES20.glUniform3fv(this.uSun, 1, this.sunColor, 0);
        GLES20.glUniform1f(this.uAmbient, this.ambient);
        GLES20.glUniform3fv(this.uFogColor, 1, this.fogColor, 0);
        GLES20.glUniform3f(this.uFog, this.fogStart, this.fogEnd, this.fogMode);
        GLES20.glUniform1f(this.uExposure, this.exposure);
        GLES20.glUniform1f(this.uShadowOn, shadows ? 1.0f : 0.0f);
        GLES20.glUniform2f(this.uShadowTexel, 1.0f / this.shadowSize, 1.0f / this.shadowSize);
        GLES20.glUniform1f(this.uTime, this.time);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.shadowTex);
        GLES20.glUniform1i(this.uShadow, 0);
        GLES20.glUniform1i(this.uMatTex, 1);
        GLES20.glUniform1i(this.uMatNrm, 2);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.surfTex);
        GLES20.glActiveTexture(33984);
        GLES20.glUniform1i(this.uSurfTex, 3);
        GLES20.glUniform1f(this.uHasSurfTex, this.surfTex != 0 ? 1.0f : 0.0f);
    }

    private final void setModel(CFrame cf, Vector3 s) {
        this.model[0] = cf.getR00() * s.getX();
        this.model[1] = cf.getR10() * s.getX();
        this.model[2] = cf.getR20() * s.getX();
        this.model[3] = 0.0f;
        this.model[4] = cf.getR01() * s.getY();
        this.model[5] = cf.getR11() * s.getY();
        this.model[6] = cf.getR21() * s.getY();
        this.model[7] = 0.0f;
        this.model[8] = cf.getR02() * s.getZ();
        this.model[9] = cf.getR12() * s.getZ();
        this.model[10] = cf.getR22() * s.getZ();
        this.model[11] = 0.0f;
        this.model[12] = cf.getX();
        this.model[13] = cf.getY();
        this.model[14] = cf.getZ();
        this.model[15] = 1.0f;
        float x = !((s.getX() > 0.0f ? 1 : (s.getX() == 0.0f ? 0 : -1)) == 0) ? 1.0f / s.getX() : 0.0f;
        float y = !((s.getY() > 0.0f ? 1 : (s.getY() == 0.0f ? 0 : -1)) == 0) ? 1.0f / s.getY() : 0.0f;
        float z = (s.getZ() > 0.0f ? 1 : (s.getZ() == 0.0f ? 0 : -1)) == 0 ? 0.0f : 1.0f / s.getZ();
        this.normal[0] = cf.getR00() * x;
        this.normal[1] = cf.getR10() * x;
        this.normal[2] = cf.getR20() * x;
        this.normal[3] = cf.getR01() * y;
        this.normal[4] = cf.getR11() * y;
        this.normal[5] = cf.getR21() * y;
        this.normal[6] = cf.getR02() * z;
        this.normal[7] = cf.getR12() * z;
        this.normal[8] = cf.getR22() * z;
    }

    private final void setupMeshProgram() {
        this.meshProg = program(MESH_VS, MESH_FS);
        this.mVP = setupMeshProgram$u$56(this, "uVP");
        this.mModel = setupMeshProgram$u$56(this, "uModel");
        this.mNrm = setupMeshProgram$u$56(this, "uNrm");
        this.mColor = setupMeshProgram$u$56(this, "uColor");
        this.mLight = setupMeshProgram$u$56(this, "uLight");
        this.mSun = setupMeshProgram$u$56(this, "uSun");
        this.mAmbient = setupMeshProgram$u$56(this, "uAmbient");
        this.mTex = setupMeshProgram$u$56(this, "uTex");
        this.mHasTex = setupMeshProgram$u$56(this, "uHasTex");
        this.mShadow = setupMeshProgram$u$56(this, "uShadow");
        this.mShadowVP = setupMeshProgram$u$56(this, "uShadowVP");
        this.mShadowOn = setupMeshProgram$u$56(this, "uShadowOn");
        this.mShadowTexel = setupMeshProgram$u$56(this, "uShadowTexel");
        this.mCam = setupMeshProgram$u$56(this, "uCam");
        this.mFogColor = setupMeshProgram$u$56(this, "uFogColor");
        this.mFog = setupMeshProgram$u$56(this, "uFog");
        this.mExposure = setupMeshProgram$u$56(this, "uExposure");
        this.mTint = setupMeshProgram$u$56(this, "uTint");
        this.mEmissive = setupMeshProgram$u$56(this, "uEmissive");
        this.mHorizon = setupMeshProgram$u$56(this, "uHorizon");
        this.mZenith = setupMeshProgram$u$56(this, "uZenith");
        this.maPos = GLES20.glGetAttribLocation(this.meshProg, "aPos");
        this.maNrm = GLES20.glGetAttribLocation(this.meshProg, "aNrm");
        this.maUv = GLES20.glGetAttribLocation(this.meshProg, "aUv");
    }

    private static final int setupMeshProgram$u$56(SceneRenderer sceneRenderer, String str) {
        return GLES20.glGetUniformLocation(sceneRenderer.meshProg, str);
    }

    private final void setupShadowMap() {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(3379, iArr, 0);
        this.shadowSize = iArr[0] < 2048 ? 1024 : 2048;
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr2, 0);
        this.shadowTex = iArr2[0];
        GLES20.glBindTexture(3553, this.shadowTex);
        GLES20.glTexImage2D(3553, 0, 6408, this.shadowSize, this.shadowSize, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glGenRenderbuffers(1, iArr2, 0);
        int i = iArr2[0];
        GLES20.glBindRenderbuffer(36161, i);
        GLES20.glRenderbufferStorage(36161, 33189, this.shadowSize, this.shadowSize);
        GLES20.glGenFramebuffers(1, iArr2, 0);
        this.shadowFbo = iArr2[0];
        GLES20.glBindFramebuffer(36160, this.shadowFbo);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.shadowTex, 0);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, i);
        this.shadowOk = GLES20.glCheckFramebufferStatus(36160) == 36053;
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        if (this.shadowOk) {
            return;
        }
        OutputLog.INSTANCE.warn("Shadows are not supported on this device's GPU");
    }

    private final void setupSkybox() {
        this.skyboxProg = program(SKYBOX_VS, SKYBOX_FS);
        this.kVP = setupSkybox$u$47(this, "uVP");
        this.kCam = setupSkybox$u$47(this, "uCam");
        this.kRot = setupSkybox$u$47(this, "uRot");
        this.kTex = setupSkybox$u$47(this, "uTex");
        this.kTint = setupSkybox$u$47(this, "uTint");
        this.kaPos = GLES20.glGetAttribLocation(this.skyboxProg, "aPos");
        this.kaUv = GLES20.glGetAttribLocation(this.skyboxProg, "aUv");
        int i = 6;
        Float valueOf = Float.valueOf(-1.0f);
        Vector3 vector3 = new Vector3(0.0f, 0.0f, -1.0f);
        float f = 1.0f;
        Float valueOf2 = Float.valueOf(1.0f);
        boolean z = true;
        char c = 2;
        char c2 = 3;
        char c3 = 5;
        float[] fArr = new float[180];
        int i2 = 0;
        for (Triple triple : CollectionsKt.listOf((Object[]) new Triple[]{new Triple(vector3, new Vector3(1.0f, 0.0f, 0.0f), new Vector3(0.0f, 1.0f, 0.0f)), new Triple(new Vector3(0.0f, 0.0f, 1.0f), new Vector3(-1.0f, 0.0f, 0.0f), new Vector3(0.0f, 1.0f, 0.0f)), new Triple(new Vector3(-1.0f, 0.0f, 0.0f), new Vector3(0.0f, 0.0f, -1.0f), new Vector3(0.0f, 1.0f, 0.0f)), new Triple(new Vector3(1.0f, 0.0f, 0.0f), new Vector3(0.0f, 0.0f, 1.0f), new Vector3(0.0f, 1.0f, 0.0f)), new Triple(new Vector3(0.0f, 1.0f, 0.0f), new Vector3(0.0f, 0.0f, -1.0f), new Vector3(1.0f, 0.0f, 0.0f)), new Triple(new Vector3(0.0f, -1.0f, 0.0f), new Vector3(0.0f, 0.0f, -1.0f), new Vector3(-1.0f, 0.0f, 0.0f))})) {
            Vector3 vector32 = (Vector3) triple.component1();
            char c4 = c3;
            Vector3 vector33 = (Vector3) triple.component2();
            Vector3 vector34 = (Vector3) triple.component3();
            boolean z2 = z;
            Pair[] pairArr = new Pair[i];
            pairArr[0] = TuplesKt.to(valueOf, valueOf);
            pairArr[z2 ? 1 : 0] = TuplesKt.to(valueOf2, valueOf);
            pairArr[c] = TuplesKt.to(valueOf2, valueOf2);
            pairArr[c2] = TuplesKt.to(valueOf, valueOf);
            pairArr[4] = TuplesKt.to(valueOf2, valueOf2);
            pairArr[c4] = TuplesKt.to(valueOf, valueOf2);
            for (Pair pair : CollectionsKt.listOf((Object[]) pairArr)) {
                float floatValue = ((Number) pair.component1()).floatValue();
                float f2 = f;
                float floatValue2 = ((Number) pair.component2()).floatValue();
                Vector3 plus = vector32.plus(vector33.times(floatValue)).plus(vector34.times(floatValue2));
                int i3 = i2 + 1;
                fArr[i2] = plus.getX();
                int i4 = i3 + 1;
                fArr[i3] = plus.getY();
                int i5 = i4 + 1;
                fArr[i4] = plus.getZ();
                int i6 = i5 + 1;
                fArr[i5] = (floatValue + f2) / 2.0f;
                fArr[i6] = (f2 - floatValue2) / 2.0f;
                i2 = i6 + 1;
                f = f2;
            }
            z = z2 ? 1 : 0;
            c3 = c4;
            i = 6;
            c = 2;
            c2 = 3;
        }
        this.skyboxMesh = Meshes.upload$default(Meshes.INSTANCE, fArr, 5, 4, null, 8, null);
    }

    private static final int setupSkybox$u$47(SceneRenderer sceneRenderer, String str) {
        return GLES20.glGetUniformLocation(sceneRenderer.skyboxProg, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002c, code lost:
    
        if (r5 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlin.Pair<com.exampletest.mobilestudiotest.model.Vector3, java.lang.Float> shadowFocus() {
        /*
            r9 = this;
            com.exampletest.mobilestudiotest.core.Studio r0 = r9.studio
            com.exampletest.mobilestudiotest.render.FlyCamera r0 = r0.getCamera()
            com.exampletest.mobilestudiotest.core.Studio r1 = r9.studio
            com.exampletest.mobilestudiotest.engine.PlaySession r1 = r1.getPlay()
            if (r1 == 0) goto L2f
            r2 = r1
            r3 = 0
            com.exampletest.mobilestudiotest.model.Instance r4 = r2.getCharacter()
            r5 = 0
            if (r4 == 0) goto L2c
            r6 = 0
            r7 = 2
            java.lang.String r8 = "HumanoidRootPart"
            com.exampletest.mobilestudiotest.model.Instance r4 = com.exampletest.mobilestudiotest.model.Instance.findFirstChild$default(r4, r8, r6, r7, r5)
            if (r4 == 0) goto L2c
            r5 = 0
            com.exampletest.mobilestudiotest.model.PartData r6 = com.exampletest.mobilestudiotest.model.PartData.INSTANCE
            com.exampletest.mobilestudiotest.model.CFrame r6 = r6.cframe(r4)
            com.exampletest.mobilestudiotest.model.Vector3 r5 = r6.getPosition()
        L2c:
            if (r5 == 0) goto L2f
            goto L41
        L2f:
            com.exampletest.mobilestudiotest.model.Vector3 r2 = r0.getPos()
            com.exampletest.mobilestudiotest.model.Vector3 r3 = r0.getForward()
            r4 = 1110704128(0x42340000, float:45.0)
            com.exampletest.mobilestudiotest.model.Vector3 r3 = r3.times(r4)
            com.exampletest.mobilestudiotest.model.Vector3 r5 = r2.plus(r3)
        L41:
            if (r1 == 0) goto L47
            r2 = 1121714176(0x42dc0000, float:110.0)
            goto L63
        L47:
            com.exampletest.mobilestudiotest.model.Vector3 r2 = r0.getPos()
            float r2 = r2.getY()
            r3 = 0
            float r2 = kotlin.ranges.RangesKt.coerceAtLeast(r2, r3)
            r3 = 1061997773(0x3f4ccccd, float:0.8)
            float r2 = r2 * r3
            r3 = 1109393408(0x42200000, float:40.0)
            float r2 = r2 + r3
            r3 = 1117782016(0x42a00000, float:80.0)
            r4 = 1132593152(0x43820000, float:260.0)
            float r2 = kotlin.ranges.RangesKt.coerceIn(r2, r3, r4)
        L63:
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            kotlin.Pair r3 = kotlin.TuplesKt.to(r5, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.SceneRenderer.shadowFocus():kotlin.Pair");
    }

    private final long signature(Instance sg) {
        long j = 17;
        boolean z = false;
        Iterator it = Instance.descendants$default(sg, null, 1, null).iterator();
        while (true) {
            long j2 = 31;
            if (!it.hasNext()) {
                break;
            }
            Instance instance = (Instance) it.next();
            long hashCode = (j * 31) + instance.getClassName().hashCode();
            String[] strArr = SIG_PROPS;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                hashCode = (hashCode * j2) + (instance.getProps().get(strArr[i]) != null ? r15.hashCode() : 0);
                i++;
                j2 = j2;
            }
            if (instance.getProps().containsKey("Image")) {
                z = true;
            }
            j = hashCode == 0 ? 1L : hashCode;
        }
        return z ? (j * 31) + ImageLoader.INSTANCE.getEpoch() : j;
    }

    private final float smooth(float a, float b, float x) {
        float coerceIn = RangesKt.coerceIn((x - a) / (b - a), 0.0f, 1.0f);
        return coerceIn * coerceIn * (3.0f - (2.0f * coerceIn));
    }

    private final BatchSpec spec(Instance p, float[] data, int stride, boolean isCube, Geo g, Color3 color, boolean pending) {
        int material = PartData.INSTANCE.material(p);
        float[] material2 = material(material);
        float f = material2[0];
        float f2 = material2[1];
        float f3 = material2[2];
        float f4 = material2[3];
        Object obj = p.get("Reflectance");
        Number number = obj instanceof Number ? (Number) obj : null;
        float[] fArr = {f, f2, f3, f4 + RangesKt.coerceIn(number != null ? number.floatValue() : 0.0f, 0.0f, 1.0f)};
        TexBind texturesFor = texturesFor(p, material);
        return new BatchSpec(data, isCube, g.getCf(), g.getScale(), color.getR(), color.getG(), color.getB(), material == 288, fArr, isCube ? new Vector3(surf(p, "RightSurface"), surf(p, "TopSurface"), surf(p, "BackSurface")) : null, isCube ? new Vector3(surf(p, "LeftSurface"), surf(p, "BottomSurface"), surf(p, "FrontSurface")) : null, texturesFor != null ? 2 : needsAdvanced(material) ? 1 : 0, texturesFor, pending || (texturesFor == null && MaterialTextures.INSTANCE.hasTexture(material)), stride, null, 32768, null);
    }

    private final Geo storedUnionGeo(Instance p, CFrame cf) {
        Geo geo;
        ArrayList arrayList;
        List<Pair<Mesh, Integer>> list;
        Vector3 vector3;
        Color3 fromRGB;
        Instance instance = p;
        UnionMeshes.Data data = UnionMeshes.INSTANCE.get(instance);
        Geo geo2 = null;
        if (data == null) {
            return null;
        }
        HashMap<String, List<Pair<Mesh, Integer>>> hashMap = this.storedUnionGpu;
        String key = data.getKey();
        List<Pair<Mesh, Integer>> list2 = hashMap.get(key);
        if (list2 == null) {
            List<Pair<Integer, float[]>> groups = data.getGroups();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(groups, 10));
            Iterator<T> it = groups.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                int intValue = ((Number) pair.component1()).intValue();
                arrayList2.add(TuplesKt.to(Meshes.upload$default(Meshes.INSTANCE, (float[]) pair.component2(), 8, 4, null, 8, null), Integer.valueOf(intValue)));
                geo2 = geo2;
            }
            geo = geo2;
            arrayList = arrayList2;
            hashMap.put(key, arrayList);
        } else {
            geo = null;
            arrayList = list2;
        }
        List<Pair<Mesh, Integer>> list3 = arrayList;
        if (list3.isEmpty()) {
            return geo;
        }
        Vector3 size = PartData.INSTANCE.size(instance);
        Vector3 vector32 = new Vector3(storedUnionGeo$k(size.getX(), data.getSize().getX()), storedUnionGeo$k(size.getY(), data.getSize().getY()), storedUnionGeo$k(size.getZ(), data.getSize().getZ()));
        boolean areEqual = Intrinsics.areEqual(instance.get("UsePartColor"), (Object) true);
        List<Pair<Mesh, Integer>> list4 = list3;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator<T> it2 = list4.iterator();
        while (it2.hasNext()) {
            Pair pair2 = (Pair) it2.next();
            UnionMeshes.Data data2 = data;
            Mesh mesh = (Mesh) pair2.component1();
            int intValue2 = ((Number) pair2.component2()).intValue();
            if (areEqual) {
                list = list3;
                fromRGB = PartData.INSTANCE.color(instance);
                vector3 = size;
            } else {
                list = list3;
                vector3 = size;
                fromRGB = Color3.INSTANCE.fromRGB((intValue2 >> 16) & 255, (intValue2 >> 8) & 255, intValue2 & 255);
            }
            arrayList3.add(TuplesKt.to(mesh, fromRGB));
            instance = p;
            data = data2;
            list3 = list;
            size = vector3;
        }
        ArrayList arrayList4 = arrayList3;
        return new Geo((Mesh) ((Pair) arrayList4.get(0)).getFirst(), cf.times(CFrame.INSTANCE.at(data.getCenter().times(vector32).unaryMinus())), vector32, 3, null, arrayList4, null, 80, null);
    }

    private static final float storedUnionGeo$k(float f, float f2) {
        if (f2 > 1.0E-4f) {
            return f / f2;
        }
        return 1.0f;
    }

    private final float surf(Instance p, String name) {
        Object obj = p.get(name);
        return (obj instanceof EnumValue ? (EnumValue) obj : null) != null ? r0.getValue() : 0;
    }

    private final void switchLit(LitLocs l) {
        if (this.activeLit == l) {
            return;
        }
        useLit(l);
        setLitFrameUniforms(this.frameShadows);
    }

    private final int textureFor(String content, boolean repeat) {
        String str;
        String str2;
        String keyFor = ImageLoader.INSTANCE.keyFor(content);
        if (keyFor == null) {
            return 0;
        }
        if (repeat) {
            HashMap<String, String> hashMap = this.repeatKeys;
            String str3 = hashMap.get(keyFor);
            if (str3 == null) {
                str2 = keyFor + "#r";
                hashMap.put(keyFor, str2);
            } else {
                str2 = str3;
            }
            str = str2;
        } else {
            str = keyFor;
        }
        Integer num = this.textures.get(str);
        if (num != null) {
            return num.intValue();
        }
        Bitmap key = ImageLoader.INSTANCE.getKey(keyFor);
        if (key == null) {
            return 0;
        }
        int upload = upload(key, repeat);
        this.textures.put(str, Integer.valueOf(upload));
        return upload;
    }

    private final LitLocs texturedLit() {
        LitLocs litLocs = this.litTex;
        if (litLocs != null) {
            return litLocs;
        }
        if (this.frames < 30) {
            return null;
        }
        LitLocs litLocs2 = litLocs(program("#define TEXTURED 1\n\nuniform mat4 uVP; uniform mat4 uModel; uniform mat3 uNrm; uniform mat4 uShadowVP;\n#ifdef BATCH\n// Static batches: vertices are already in world space and carry the part's look.\nattribute vec3 aPos; attribute vec4 aNrm; attribute vec2 aUv; attribute vec4 aCol; attribute vec4 aMat;\nvarying vec3 vN; varying vec3 vW; varying vec4 vS; varying vec3 vA; varying vec4 vCol; varying vec4 vMat;\n#ifdef TEXTURED\nattribute vec3 aTan; attribute vec3 aBit;\nvarying vec3 vT; varying vec3 vB;\n#endif\nvoid main() {\n  vW = aPos; vN = aNrm.xyz;\n  vS = uShadowVP * vec4(aPos, 1.0);\n  vA = vec3(aUv, floor(aNrm.w * 127.0 + 0.5));\n  vCol = aCol;\n  vMat = vec4(aMat.x, aMat.y / 1000.0, aMat.z / 50.0, aMat.w / 120.0);\n#ifdef TEXTURED\n  vT = aTan; vB = aBit;\n#endif\n  gl_Position = uVP * vec4(aPos, 1.0);\n}\n#else\nattribute vec3 aPos; attribute vec3 aNrm;\nvarying vec3 vN; varying vec3 vW; varying vec3 vL; varying vec3 vLN; varying vec4 vS;\n#ifdef TEXTURED\nvarying vec3 vT; varying vec3 vB;\n#endif\nvoid main() {\n  vec4 w = uModel * vec4(aPos, 1.0);\n  vW = w.xyz; vN = uNrm * aNrm; vL = aPos; vLN = aNrm;\n  vS = uShadowVP * w;\n#ifdef TEXTURED\n  // World directions of the face's texture axes (same box projection the fragment shader uses).\n  vec3 an = abs(aNrm);\n  bool yF = an.y > an.x && an.y > an.z; bool xF = !yF && an.x > an.z;\n  vT = (uModel * vec4(yF ? vec3(1.0, 0.0, 0.0) : (xF ? vec3(0.0, 0.0, 1.0) : vec3(1.0, 0.0, 0.0)), 0.0)).xyz;\n  vB = (uModel * vec4(yF ? vec3(0.0, 0.0, 1.0) : vec3(0.0, 1.0, 0.0), 0.0)).xyz;\n#endif\n  gl_Position = uVP * w;\n}\n#endif", "#define TEXTURED 1\n\n#ifdef GL_FRAGMENT_PRECISION_HIGH\nprecision highp float;\n#else\nprecision mediump float;\n#endif\n\n#ifdef BATCH\nvarying vec3 vN; varying vec3 vW; varying vec4 vS; varying vec3 vA; varying vec4 vCol; varying vec4 vMat;\n#else\nvarying vec3 vN; varying vec3 vW; varying vec3 vL; varying vec3 vLN; varying vec4 vS;\n#endif\nuniform vec4 uColor; uniform vec3 uLight; uniform vec3 uCam; uniform float uEmissive;\nuniform float uGrid; uniform vec3 uSize; uniform vec3 uHorizon; uniform vec3 uZenith; uniform vec3 uSun;\nuniform float uAmbient; uniform vec3 uFogColor; uniform vec3 uFog; uniform vec4 uMat; uniform vec3 uSurfA; uniform vec3 uSurfB;\nuniform sampler2D uShadow; uniform float uShadowOn; uniform vec2 uShadowTexel; uniform float uExposure; uniform float uTime; uniform float uTruss;\nuniform sampler2D uSurfTex; uniform float uHasSurfTex;\n#ifdef TEXTURED\nvarying vec3 vT; varying vec3 vB;\nuniform sampler2D uMatTex; uniform sampler2D uMatNrm; uniform float uTexScale; uniform float uHasNrm;\n#endif\n\nfloat hash(vec2 p) { return fract(sin(dot(p, vec2(127.1, 311.7))) * 43758.5453); }\nvec2 hash2(vec2 p) { return fract(sin(vec2(dot(p, vec2(127.1, 311.7)), dot(p, vec2(269.5, 183.3)))) * 43758.5453); }\nfloat noise(vec2 p) {\n  vec2 i = floor(p); vec2 f = fract(p); f = f * f * (3.0 - 2.0 * f);\n  return mix(mix(hash(i), hash(i + vec2(1.0, 0.0)), f.x), mix(hash(i + vec2(0.0, 1.0)), hash(i + vec2(1.0, 1.0)), f.x), f.y);\n}\nfloat fbm(vec2 p) { return noise(p) * 0.5 + noise(p * 2.03 + 7.1) * 0.3 + noise(p * 4.1 + 3.3) * 0.2; }\n#ifdef ADVANCED\n// Cellular noise: x = distance to the nearest cell point, y = distance to the cell edge (approx).\nvec3 voro(vec2 x) {\n  vec2 n = floor(x); vec2 f = fract(x);\n  float d1 = 8.0; float d2 = 8.0; vec2 id = n;\n  for (int j = -1; j <= 1; j++) for (int i = -1; i <= 1; i++) {\n    vec2 g = vec2(float(i), float(j));\n    vec2 r = g + hash2(n + g) - f;\n    float d = dot(r, r);\n    if (d < d1) { d2 = d1; d1 = d; id = n + g; } else if (d < d2) { d2 = d; }\n  }\n  return vec3(sqrt(d1), sqrt(d2) - sqrt(d1), hash(id));\n}\n#endif\n// Roblox surface types on one face (sp = stud coordinates on the face, fsz = face size).\n// Roblox's stud look: a raised disc lit from the upper left with a soft shadow to the lower right.\nfloat studShade(vec2 f, float R) {\n  vec2 L = vec2(-0.62, 0.78);\n  float r = length(f);\n  float inside = smoothstep(R + 0.012, R - 0.012, r);\n  float rim = smoothstep(R - 0.09, R, r) * inside;\n  float side = dot(f / max(r, 0.001), L);\n  float shadow = smoothstep(R + 0.1, R, length(f + L * 0.05)) * (1.0 - inside);\n  return 1.0 + inside * 0.05 + rim * side * 0.22 - shadow * 0.2;\n}\nvec3 surface(vec3 c, float s, vec2 sp, vec2 fsz) {\n  if (s < 0.5 || s > 9.5) return c;\n  if (uHasSurfTex > 0.5 && s < 5.5) {\n    // Roblox's own surface textures: one 2x8-stud tile per type, shaded around grey 128\n    // (R = studs, G = weld/glue, B = inlet). Sampled with repeat (no fract) so mipmapping\n    // never sees a seam. s is the same for a whole face, so this branch is uniform per triangle.\n    vec2 st = vec2(sp.x * 0.5, -sp.y * 0.125);\n    vec3 t = texture2D(uSurfTex, st).rgb;\n    float k;\n    if (s < 2.5) k = t.g;\n    else if (s < 3.5) k = t.r;\n    else if (s < 4.5) k = t.b;\n    else { vec2 cell = floor(fract(st) * vec2(2.0, 8.0)); k = mod(cell.x + cell.y, 2.0) < 0.5 ? t.r : t.b; }\n    return c * (k * 2.0);\n  }\n  vec2 f = fract(sp) - 0.5; float r = length(f);\n  if (s > 2.5 && s < 3.5) { // Studs\n    c *= studShade(f, 0.29);\n  } else if (s > 3.5 && s < 4.5) { // Inlet: a sunken hole, shaded the opposite way\n    vec2 L = vec2(-0.62, 0.78);\n    float inside = smoothstep(0.302, 0.278, r);\n    float rim = smoothstep(0.2, 0.29, r) * inside;\n    c *= 1.0 - inside * 0.16 - rim * dot(f / max(r, 0.001), L) * 0.2 + smoothstep(0.36, 0.3, r) * (1.0 - inside) * 0.05;\n  } else if (s > 4.5 && s < 5.5) { // Universal: a stud with a hole in it\n    c *= studShade(f, 0.29) * (1.0 - smoothstep(0.14, 0.12, r) * 0.18);\n  } else if (s > 1.5 && s < 2.5) { // Weld: diagonal hatching\n    float l = fract((sp.x + sp.y) * 1.25);\n    c *= mix(1.0, 0.84, smoothstep(0.82, 0.88, l) * smoothstep(1.0, 0.94, l));\n  } else if (s > 0.5 && s < 1.5) { // Glue: grid of small crosses\n    vec2 g = abs(fract(sp * 2.0) - 0.5);\n    float cr = max(step(g.x, 0.05) * step(g.y, 0.22), step(g.y, 0.05) * step(g.x, 0.22));\n    c *= 1.0 - 0.14 * cr;\n  } else { // Hinge / Motor / SteppingMotor: a yellow joint in the middle of the face\n    float rr = length(sp - fsz * 0.5);\n    vec3 yellow = vec3(0.96, 0.8, 0.16);\n    if (s > 6.5) {\n      if (rr < 0.75) c = mix(c, vec3(0.45, 0.45, 0.47), smoothstep(0.75, 0.7, rr));\n      if (s > 7.5 && rr < 0.75 && rr > 0.5) { float a = atan(sp.y - fsz.y * 0.5, sp.x - fsz.x * 0.5); c *= 0.75 + 0.25 * step(0.5, fract(a * 1.273)); }\n    }\n    if (rr < 0.45) c = mix(c, yellow, smoothstep(0.45, 0.4, rr));\n  }\n  return c;\n}\nfloat unpackDepth(vec4 c) { return dot(c, vec4(1.0, 1.0 / 255.0, 1.0 / 65025.0, 1.0 / 16581375.0)); }\nfloat sampleShadow(vec2 uv, float z) { return z > unpackDepth(texture2D(uShadow, uv)) ? 0.0 : 1.0; }\nfloat shadowAt(float ndl) {\n  if (uShadowOn < 0.5 || ndl <= 0.0) return 1.0;\n  vec3 p = vS.xyz / vS.w * 0.5 + 0.5;\n  if (p.x <= 0.001 || p.x >= 0.999 || p.y <= 0.001 || p.y >= 0.999 || p.z >= 1.0) return 1.0;\n  float z = p.z - (0.0012 + 0.0035 * (1.0 - ndl));\n  vec2 t = uShadowTexel;\n  float s = sampleShadow(p.xy, z) * 2.0;\n  s += sampleShadow(p.xy + vec2(-t.x, -t.y), z);\n  s += sampleShadow(p.xy + vec2(t.x, -t.y), z);\n  s += sampleShadow(p.xy + vec2(-t.x, t.y), z);\n  s += sampleShadow(p.xy + vec2(t.x, t.y), z);\n  s /= 6.0;\n  vec2 e = min(p.xy, 1.0 - p.xy);\n  float fade = clamp(min(e.x, e.y) * 12.0, 0.0, 1.0);\n  return mix(1.0, s, fade);\n}\nvoid main() {\n  vec3 n = normalize(vN);\n  if (!gl_FrontFacing) n = -n;\n#ifdef BATCH\n  vec3 c = vCol.rgb; vec4 mat = vMat; float emis = vCol.a; float alpha = 1.0;\n  vec2 uv = vA.xy; vec2 fsz = vec2(1.0); float sf = vA.z;\n#else\n  vec3 c = uColor.rgb; vec4 mat = uMat; float emis = uEmissive; float alpha = uColor.a;\n  vec3 a = abs(vLN);\n  vec3 p = vL * uSize + uSize * 0.5;\n  bool yFace = a.y > a.x && a.y > a.z; bool xFace = !yFace && a.x > a.z;\n  vec2 uv = yFace ? p.xz : (xFace ? p.zy : p.xy);\n  vec2 fsz = yFace ? uSize.xz : (xFace ? uSize.zy : uSize.xy);\n  // Surface types (studs, inlets, welds, hinges...) on whichever face this is.\n  float sf = yFace ? (vLN.y > 0.0 ? uSurfA.y : uSurfB.y) : (xFace ? (vLN.x > 0.0 ? uSurfA.x : uSurfB.x) : (vLN.z > 0.0 ? uSurfA.z : uSurfB.z));\n  if (uTruss > 0.5) {\n    // Lattice: frame and diagonals per 2-stud cell; everything else is see-through.\n    vec2 cell = fract(uv / 2.0);\n    float e = min(min(cell.x, cell.y), min(1.0 - cell.x, 1.0 - cell.y));\n    float dg = min(abs(cell.x - cell.y), abs(cell.x + cell.y - 1.0));\n    if (e > 0.11 && dg > 0.07) discard;\n  }\n#endif\n  vec3 glow = vec3(0.0);\n  float type = mat.x;\n#ifdef TEXTURED\n  // Roblox material textures: the color map tints the part color; the normal map bends the light.\n  vec2 tuv = vec2(uv.x, -uv.y) * uTexScale;\n  c *= texture2D(uMatTex, tuv).rgb * 1.08;\n  if (uHasNrm > 0.5) {\n    vec3 tn = texture2D(uMatNrm, tuv).xyz * 2.0 - 1.0;\n    n = normalize(normalize(vT) * tn.x + normalize(vB) * tn.y + n * max(tn.z, 0.25));\n  }\n  type = 0.0;\n#endif\n  if (type > 0.5) {\n    float amt = mat.y; float sc = mat.z;\n#ifdef ADVANCED\n    if (type > 10.5) {\n      if (type < 11.5) { // Marble veins\n        float v = abs(sin((uv.x * 0.6 + uv.y * 0.25 + fbm(uv * 0.35) * 5.0) * 1.7));\n        c *= mix(0.8, 1.05, pow(v, 0.35)) + (noise(uv * 3.0) - 0.5) * 0.04;\n      } else if (type < 12.5) { // Slate / sandstone: layered plates\n        float layer = floor(uv.y * sc * 2.0 + fbm(uv * 0.3) * 2.5);\n        c *= 0.9 + hash(vec2(layer, 3.0)) * 0.16 + (noise(uv * 5.0) - 0.5) * amt;\n      } else if (type < 13.5) { // Cobblestone / pebble / basalt: cells with dark gaps\n        vec3 v = voro(uv * sc);\n        c *= mix(0.62, 0.92 + v.z * 0.16, smoothstep(0.03, 0.12, v.y)) * (1.0 - v.x * 0.12);\n      } else if (type < 14.5) { // Cracked lava: dark rock with glowing cracks\n        vec3 v = voro(uv * sc);\n        c *= 0.55 + fbm(uv * 1.5) * 0.25;\n        glow = vec3(1.0, 0.36, 0.05) * smoothstep(0.08, 0.0, v.y) * (0.7 + 0.3 * sin(uTime * 1.5 + v.z * 6.0));\n      } else if (type < 15.5) { // Corroded metal: rust patches\n        float rust = smoothstep(0.42, 0.66, fbm(uv * sc));\n        c = mix(c * (0.95 + (noise(uv * vec2(18.0, 0.8)) - 0.5) * 0.08), c * vec3(0.7, 0.42, 0.24) + vec3(0.14, 0.05, 0.0), rust * 0.8);\n      } else if (type < 16.5) { // Tiles (ceramic / pavement)\n        vec2 tf = fract(uv / sc); float grout = step(0.035, tf.x) * step(0.035, tf.y);\n        c *= mix(0.72, 1.0 + (hash(floor(uv / sc)) - 0.5) * amt * 2.0 + (noise(uv * 3.0) - 0.5) * 0.04, grout);\n      } else if (type < 17.5) { // Roof tiles / shingles: overlapping rows\n        float row = floor(uv.y / (0.8 * sc));\n        vec2 q = vec2(uv.x / sc + mod(row, 2.0) * 0.5, fract(uv.y / (0.8 * sc)));\n        float edge = smoothstep(0.0, 0.08, fract(q.x)) * smoothstep(1.0, 0.92, fract(q.x));\n        c *= (0.8 + 0.25 * q.y) * mix(0.82, 1.0, edge) * (0.94 + hash(vec2(floor(q.x), row)) * 0.12);\n      } else if (type < 18.5) { // Cardboard corrugation\n        c *= 0.95 + 0.05 * sin(uv.x * 22.0) + (noise(uv * 8.0) - 0.5) * 0.06;\n      } else if (type < 19.5) { // ForceField: moving bands\n        float s = sin((uv.x + uv.y) * 2.5 - uTime * 2.2) * 0.5 + 0.5;\n        c = c * (0.55 + 0.45 * s) + vec3(0.12) * s;\n      } else if (type < 20.5) { // Leather: small creased cells\n        vec3 v = voro(uv * 6.0);\n        c *= 0.9 + 0.1 * smoothstep(0.0, 0.12, v.y) + (v.z - 0.5) * 0.04;\n      } else if (type < 21.5) { // Carpet: dense fibres\n        c *= 0.9 + hash(floor(uv * 28.0)) * 0.12 + (noise(uv * 6.0) - 0.5) * 0.1;\n      } else if (type < 22.5) { // Asphalt: speckled\n        c *= 0.9 + (hash(floor(uv * 16.0)) - 0.5) * 0.25 + (noise(uv * 2.0) - 0.5) * 0.08;\n      } else if (type < 23.5) { // Concrete: blotchy with pores\n        c *= 1.0 + (fbm(uv * sc) - 0.5) * amt * 2.4 - step(0.985, hash(floor(uv * 20.0))) * 0.18;\n      } else if (type < 24.5) { // Granite: mixed grains\n        float g = hash(floor(uv * 12.0));\n        c *= 0.88 + g * 0.22 - step(0.9, g) * 0.3 + (fbm(uv * 1.5) - 0.5) * 0.1;\n      } else { // Sand / snow / salt: fine grain with sparkle\n        float g = hash(floor(uv * 30.0));\n        c *= 1.0 + (g - 0.5) * amt * 2.0 + (fbm(uv * sc) - 0.5) * 0.1;\n        c += vec3(step(0.996, g) * 0.15);\n      }\n    } else\n    if (type < 1.5) { c *= 1.0 + (noise(uv * 2.2) - 0.5) * amt * 2.0; }\n    else if (type < 2.5) {\n      float g = sin((uv.x * 1.3 + fbm(uv * vec2(0.35, 2.2)) * 4.0) * 5.0);\n      c *= 1.0 + g * amt * 0.6 - amt * 0.2;\n    } else if (type < 3.5) {\n      float plank = floor(uv.y);\n      float seamY = smoothstep(0.0, 0.05, fract(uv.y)) * smoothstep(1.0, 0.95, fract(uv.y));\n      float off = hash(vec2(plank, 3.0)) * 8.0;\n      float seamX = smoothstep(0.0, 0.04, fract((uv.x + off) / 6.0) * 6.0);\n      float g = sin((uv.x * 1.6 + fbm(vec2(uv.x * 0.3, uv.y * 3.0 + plank)) * 3.0) * 6.0);\n      c *= (0.9 + hash(vec2(plank, 1.0)) * 0.18) * (1.0 + g * amt * 0.35) * mix(0.72, 1.0, seamY * seamX);\n    } else if (type < 4.5) {\n      // Brick: running bond with light grey mortar, like Roblox's brick material.\n      vec2 b = vec2(uv.x / 1.6, uv.y / 0.66);\n      float row = floor(b.y);\n      b.x += mod(row, 2.0) * 0.5;\n      vec2 f = fract(b);\n      float mortar = smoothstep(0.05, 0.09, f.y) * smoothstep(0.025, 0.05, f.x) * smoothstep(1.0, 0.985, f.x);\n      vec3 brick = c * (0.9 + (hash(floor(b)) - 0.5) * amt * 2.2 + (noise(uv * 7.0) - 0.5) * 0.08);\n      vec3 grout = mix(vec3(dot(c, vec3(0.3, 0.59, 0.11))), vec3(0.82), 0.55);\n      c = mix(grout, brick, mortar);\n    } else if (type < 5.5) { c *= 1.0 + (fbm(uv * sc) - 0.5) * amt * 2.6; }\n    else if (type < 6.5) {\n      vec2 q = vec2(uv.x + uv.y, uv.x - uv.y) * 1.4;\n      vec2 f = fract(q) - 0.5;\n      float bump = smoothstep(0.18, 0.05, abs(f.x) * 0.35 + abs(f.y));\n      c *= 0.92 + bump * 0.22 + (noise(uv * 8.0) - 0.5) * 0.05;\n    } else if (type < 7.5) { c *= 1.0 + (noise(uv * vec2(24.0, 0.6)) - 0.5) * amt * 2.0; }\n    else if (type < 8.5) {\n      float f = fbm(uv * sc);\n      c *= 1.0 + (f - 0.5) * amt * 2.4 + (noise(uv * 9.0) - 0.5) * 0.05;\n      c.r += (noise(uv * 0.25) - 0.5) * 0.04;\n    } else if (type < 9.5) { c *= 1.0 + sin(uv.x * 30.0) * sin(uv.y * 30.0) * amt; }\n    else { c *= 1.0 + (fbm(uv * sc) - 0.5) * amt * 2.0; }\n#else\n    // Lean variant: plastic grain only (other materials use the ADVANCED program).\n    c *= 1.0 + (noise(uv * 2.2) - 0.5) * amt * 2.0;\n#endif\n  }\n  c = surface(c, sf, uv, fsz);\n#ifndef BATCH\n  if (uGrid > 0.5) {\n    vec2 f = abs(fract(uv / 4.0 + 0.5) - 0.5) * 4.0;\n    float d = min(f.x, f.y);\n    c *= mix(0.84, 1.0, smoothstep(0.04, 0.09, d));\n  }\n#endif\n  vec3 col;\n  if (emis > 0.5) {\n    col = c * 1.15 + vec3(0.06);\n  } else {\n    float ndl = dot(n, uLight);\n    float diff = max(ndl, 0.0);\n    float sh = shadowAt(ndl);\n    vec3 sky = mix(uHorizon, uZenith, 0.5);\n    vec3 amb = uAmbient * mix(vec3(0.82), mix(vec3(1.0), sky * 1.2, 0.35), 0.5 + 0.5 * n.y);\n    col = c * (amb + uSun * diff * sh);\n    vec3 v = normalize(uCam - vW);\n    vec3 h = normalize(uLight + v);\n    float spec = pow(max(dot(n, h), 0.0), 16.0 + mat.w * 80.0) * mat.w * sh;\n    col += uSun * spec * 0.6;\n    float fres = pow(1.0 - max(dot(n, v), 0.0), 4.0) * mat.w * 0.25;\n    col = mix(col, uZenith, fres);\n  }\n  col += glow;\n  col *= uExposure;\n  float dist = length(uCam - vW);\n  float fog;\n  if (uFog.z > 1.5) fog = (1.0 - exp(-dist * uFog.x)) * uFog.y;\n  else if (uFog.z > 0.5) fog = clamp((dist - uFog.x) / max(uFog.y - uFog.x, 1.0), 0.0, 1.0);\n  else fog = smoothstep(900.0, 5000.0, dist) * 0.7;\n  col = mix(col, uFogColor, fog);\n  gl_FragColor = vec4(col, alpha);\n}"));
        this.litTex = litLocs2;
        return litLocs2;
    }

    private final TexBind texturesFor(Instance p, int mat) {
        TexBind texBind;
        Instance variantFor = variantFor(p);
        if (variantFor == null) {
            return materialBind(mat);
        }
        TexBind texBind2 = this.variantBinds.get(variantFor);
        if (texBind2 != null) {
            return texBind2;
        }
        boolean z = false;
        String content = PartData.INSTANCE.content(variantFor, "ColorMap", "ColorMapContent");
        if (content == null) {
            content = "";
        }
        String content2 = PartData.INSTANCE.content(variantFor, "NormalMap", "NormalMapContent");
        String str = content2 != null ? content2 : "";
        Object obj = variantFor.get("StudsPerTile");
        Number number = obj instanceof Number ? (Number) obj : null;
        float coerceAtLeast = RangesKt.coerceAtLeast(number != null ? number.floatValue() : 10.0f, 0.05f);
        TexBind materialBind = materialBind(mat);
        int assetTexture = !StringsKt.isBlank(content) ? assetTexture(content, true) : 0;
        int assetTexture2 = !StringsKt.isBlank(str) ? assetTexture(str, true) : 0;
        if ((!StringsKt.isBlank(content) && assetTexture == 0) || (!StringsKt.isBlank(str) && assetTexture2 == 0)) {
            z = true;
        }
        if (assetTexture != 0) {
            texBind = new TexBind(assetTexture, assetTexture2, 1.0f / coerceAtLeast);
        } else if (!StringsKt.isBlank(content) || assetTexture2 == 0) {
            texBind = materialBind;
        } else {
            texBind = new TexBind(materialBind != null ? materialBind.getColor() : whiteTex(), assetTexture2, 1.0f / coerceAtLeast);
        }
        if (texBind != null && !z) {
            this.variantBinds.put(variantFor, texBind);
        }
        return texBind;
    }

    private final Geo unionGeo(Instance p, CFrame cf) {
        boolean z;
        Geo geo;
        List<Pair<Mesh, Integer>> meshes;
        Color3 color;
        SolidModeling.Style style;
        SolidModeling.Result result = SolidModeling.INSTANCE.result(p);
        if (result == null) {
            if (UnionMeshes.INSTANCE.isStored(p)) {
                return storedUnionGeo(p, cf);
            }
            return null;
        }
        UnionGpu unionGpu = this.unionGpu.get(p);
        boolean z2 = true;
        if (unionGpu == null || unionGpu.getSig() != result.getSig()) {
            UnionGpu unionGpu2 = unionGpu;
            if (unionGpu2 != null && (meshes = unionGpu2.getMeshes()) != null) {
                Iterator<T> it = meshes.iterator();
                while (it.hasNext()) {
                    GLES20.glDeleteBuffers(1, new int[]{((Mesh) ((Pair) it.next()).getFirst()).getVbo()}, 0);
                }
            }
            long sig = result.getSig();
            Map<Integer, float[]> tris = result.getTris();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Integer, float[]> entry : tris.entrySet()) {
                if (!(entry.getValue().length == 0 ? z2 : false)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                    z2 = z2;
                }
            }
            z = z2;
            geo = null;
            boolean z3 = false;
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                arrayList.add(TuplesKt.to(Meshes.upload$default(Meshes.INSTANCE, (float[]) entry2.getValue(), 8, 4, null, 8, null), Integer.valueOf(((Number) entry2.getKey()).intValue())));
                z3 = z3;
            }
            unionGpu = new UnionGpu(sig, arrayList, result.getStyles());
            this.unionGpu.put(p, unionGpu);
        } else {
            z = true;
            geo = null;
        }
        if (unionGpu.getMeshes().isEmpty()) {
            return geo;
        }
        boolean areEqual = Intrinsics.areEqual(p.get("UsePartColor"), Boolean.valueOf(z));
        List<Pair<Mesh, Integer>> meshes2 = unionGpu.getMeshes();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(meshes2, 10));
        Iterator<T> it2 = meshes2.iterator();
        while (it2.hasNext()) {
            Pair pair = (Pair) it2.next();
            Mesh mesh = (Mesh) pair.component1();
            int intValue = ((Number) pair.component2()).intValue();
            if (areEqual || (style = (SolidModeling.Style) CollectionsKt.getOrNull(unionGpu.getStyles(), intValue)) == null || (color = style.getColor()) == null) {
                color = PartData.INSTANCE.color(p);
            }
            arrayList2.add(TuplesKt.to(mesh, color));
        }
        ArrayList arrayList3 = arrayList2;
        return new Geo((Mesh) ((Pair) arrayList3.get(0)).getFirst(), cf, SolidModeling.INSTANCE.scaleOf(p, result), 3, null, arrayList3, null, 80, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        if (r5.equals("Low") != false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateBatches(float r22, com.exampletest.mobilestudiotest.model.Vector3 r23, float r24) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.SceneRenderer.updateBatches(float, com.exampletest.mobilestudiotest.model.Vector3, float):void");
    }

    private final void updateLighting() {
        float f;
        List split$default;
        Float floatOrNull;
        Float floatOrNull2;
        Instance instance;
        float f2;
        ArrayList<Instance> children;
        Object obj;
        Instance findService = this.studio.getModel().findService("Lighting");
        Object obj2 = findService != null ? findService.get("ClockTime") : null;
        Number number = obj2 instanceof Number ? (Number) obj2 : null;
        if (number != null) {
            f = number.floatValue();
        } else {
            Object obj3 = findService != null ? findService.get("TimeOfDay") : null;
            String str = obj3 instanceof String ? (String) obj3 : null;
            float f3 = 14.0f;
            if (str == null || (split$default = StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null)) == null) {
                f = 14.0f;
            } else {
                String str2 = (String) CollectionsKt.getOrNull(split$default, 0);
                if (str2 != null && (floatOrNull2 = StringsKt.toFloatOrNull(str2)) != null) {
                    f3 = floatOrNull2.floatValue();
                }
                String str3 = (String) CollectionsKt.getOrNull(split$default, 1);
                f = f3 + (((str3 == null || (floatOrNull = StringsKt.toFloatOrNull(str3)) == null) ? 0.0f : floatOrNull.floatValue()) / 60.0f);
            }
        }
        Object obj4 = findService != null ? findService.get("GeographicLatitude") : null;
        Number number2 = obj4 instanceof Number ? (Number) obj4 : null;
        float radians = (float) Math.toRadians(number2 != null ? number2.doubleValue() : 41.733d);
        float f4 = (float) (((f - 6.0f) / 12.0f) * 3.141592653589793d);
        float sin = (float) Math.sin(f4);
        Vector3 unit = new Vector3(-((float) Math.cos(f4)), ((float) Math.cos(radians)) * sin, (((float) Math.sin(radians)) * sin) + 1.0E-4f).getUnit();
        this.dayFactor = smooth(-0.08f, 0.18f, unit.getY());
        if (unit.getY() < 0.0f) {
            unit = new Vector3(-unit.getX(), -unit.getY(), -unit.getZ());
        }
        this.sunDir = new Vector3(unit.getX(), Math.max(unit.getY(), 0.08f), unit.getZ()).getUnit();
        mix(new float[]{0.015f, 0.025f, 0.07f}, new float[]{0.3f, 0.55f, 0.93f}, this.dayFactor, this.zenith);
        mix(new float[]{0.06f, 0.08f, 0.16f}, new float[]{0.74f, 0.85f, 0.97f}, this.dayFactor, this.horizon);
        float smooth = smooth(0.35f, 0.0f, Math.abs(sin)) * smooth(-0.2f, 0.05f, sin);
        mix(this.horizon, new float[]{0.98f, 0.62f, 0.38f}, smooth * 0.65f, this.horizon);
        Object obj5 = findService != null ? findService.get("Brightness") : null;
        Number number3 = obj5 instanceof Number ? (Number) obj5 : null;
        float coerceAtMost = RangesKt.coerceAtMost((RangesKt.coerceIn(number3 != null ? number3.floatValue() : 2.0f, 0.0f, 6.0f) * 0.14f) + 0.36f, 1.1f) * ((this.dayFactor * 0.88f) + 0.12f);
        float[] fArr = {1.0f, 0.96f - (smooth * 0.25f), 0.9f - (0.45f * smooth)};
        int i = 0;
        while (true) {
            float[] fArr2 = fArr;
            if (i >= 3) {
                break;
            }
            this.sunColor[i] = fArr2[i] * coerceAtMost;
            i++;
            fArr = fArr2;
        }
        if (this.dayFactor < 0.05f) {
            this.sunColor[0] = 0.12f;
            this.sunColor[1] = 0.14f;
            this.sunColor[2] = 0.22f;
        }
        Color3 c3 = c3(findService != null ? findService.get("OutdoorAmbient") : null);
        if (c3 == null) {
            c3 = Color3.INSTANCE.fromRGB(128, 128, 128);
        }
        Color3 c32 = c3(findService != null ? findService.get("Ambient") : null);
        if (c32 == null) {
            c32 = Color3.INSTANCE.fromRGB(0, 0, 0);
        }
        this.ambient = RangesKt.coerceIn((luma(c3) * 0.42f) + 0.3f + (luma(c32) * 0.3f), 0.25f, 0.9f) * ((this.dayFactor * 0.65f) + 0.35f);
        Object obj6 = findService != null ? findService.get("ExposureCompensation") : null;
        Number number4 = obj6 instanceof Number ? (Number) obj6 : null;
        this.exposure = (float) Math.pow(2.0d, RangesKt.coerceIn(number4 != null ? number4.doubleValue() : 0.0d, -3.0d, 3.0d));
        this.shadowsOn = !(findService != null ? Intrinsics.areEqual(findService.get("GlobalShadows"), (Object) false) : false);
        if (findService == null || (children = findService.getChildren()) == null) {
            instance = null;
        } else {
            ArrayList<Instance> arrayList = children;
            boolean z = false;
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                ArrayList<Instance> arrayList2 = arrayList;
                boolean z2 = z;
                if (Intrinsics.areEqual(((Instance) obj).getClassName(), "Atmosphere")) {
                    break;
                }
                arrayList = arrayList2;
                z = z2;
            }
            instance = (Instance) obj;
        }
        Object obj7 = findService != null ? findService.get("FogEnd") : null;
        Number number5 = obj7 instanceof Number ? (Number) obj7 : null;
        float floatValue = number5 != null ? number5.floatValue() : 100000.0f;
        if (instance != null) {
            Object obj8 = instance.get("Density");
            Number number6 = obj8 instanceof Number ? (Number) obj8 : null;
            float coerceIn = RangesKt.coerceIn(number6 != null ? number6.floatValue() : 0.3f, 0.0f, 1.0f);
            Color3 c33 = c3(instance.get("Color"));
            if (c33 == null) {
                f2 = coerceIn;
                c33 = Color3.INSTANCE.fromRGB(199, 170, 107);
            } else {
                f2 = coerceIn;
            }
            Object obj9 = instance.get("Haze");
            Number number7 = obj9 instanceof Number ? (Number) obj9 : null;
            float coerceIn2 = RangesKt.coerceIn(number7 != null ? number7.floatValue() : 0.0f, 0.0f, 10.0f);
            this.fogMode = 2.0f;
            this.fogStart = ((6.0E-4f * coerceIn2) + 0.004f) * f2;
            this.fogEnd = 0.75f;
            mix(this.horizon, new float[]{c33.getR(), c33.getG(), c33.getB()}, 0.35f, this.fogColor);
            mix(this.horizon, this.fogColor, 0.5f, this.horizon);
            return;
        }
        if (floatValue >= 20000.0f) {
            this.fogMode = 0.0f;
            this.fogColor[0] = this.horizon[0];
            this.fogColor[1] = this.horizon[1];
            this.fogColor[2] = this.horizon[2];
            return;
        }
        this.fogMode = 1.0f;
        Object obj10 = findService != null ? findService.get("FogStart") : null;
        Number number8 = obj10 instanceof Number ? (Number) obj10 : null;
        this.fogStart = number8 != null ? number8.floatValue() : 0.0f;
        this.fogEnd = Math.max(floatValue, this.fogStart + 1.0f);
        Color3 c34 = c3(findService != null ? findService.get("FogColor") : null);
        if (c34 == null) {
            c34 = Color3.INSTANCE.fromRGB(191, 191, 191);
        }
        this.fogColor[0] = c34.getR();
        this.fogColor[1] = c34.getG();
        this.fogColor[2] = c34.getB();
        if (floatValue < 2000.0f) {
            mix(this.horizon, this.fogColor, 0.7f, this.horizon);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int upload(android.graphics.Bitmap r8, boolean r9) {
        /*
            r7 = this;
            r0 = 1
            if (r9 == 0) goto L25
            int r1 = r8.getWidth()
            int r1 = upload$pot(r1)
            int r2 = r8.getHeight()
            int r2 = upload$pot(r2)
            int r3 = r8.getWidth()
            if (r1 != r3) goto L20
            int r3 = r8.getHeight()
            if (r2 != r3) goto L20
            goto L26
        L20:
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createScaledBitmap(r8, r1, r2, r0)
            goto L27
        L25:
        L26:
            r3 = r8
        L27:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            int[] r1 = new int[r0]
            r2 = 0
            android.opengl.GLES20.glGenTextures(r0, r1, r2)
            r0 = r1[r2]
            r4 = 3553(0xde1, float:4.979E-42)
            android.opengl.GLES20.glBindTexture(r4, r0)
            android.opengl.GLUtils.texImage2D(r4, r2, r3, r2)
            if (r9 == 0) goto L3f
            r0 = 10497(0x2901, float:1.471E-41)
            goto L42
        L3f:
            r0 = 33071(0x812f, float:4.6342E-41)
        L42:
            r5 = 10242(0x2802, float:1.4352E-41)
            android.opengl.GLES20.glTexParameteri(r4, r5, r0)
            r5 = 10243(0x2803, float:1.4354E-41)
            android.opengl.GLES20.glTexParameteri(r4, r5, r0)
            r5 = 10240(0x2800, float:1.4349E-41)
            r6 = 9729(0x2601, float:1.3633E-41)
            android.opengl.GLES20.glTexParameteri(r4, r5, r6)
            r5 = 10241(0x2801, float:1.435E-41)
            if (r9 == 0) goto L70
            android.opengl.GLES20.glGenerateMipmap(r4)
            r6 = 9987(0x2703, float:1.3995E-41)
            android.opengl.GLES20.glTexParameteri(r4, r5, r6)
            float r5 = r7.aniso
            r6 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L73
            r5 = 34046(0x84fe, float:4.7709E-41)
            float r6 = r7.aniso
            android.opengl.GLES20.glTexParameterf(r4, r5, r6)
            goto L73
        L70:
            android.opengl.GLES20.glTexParameteri(r4, r5, r6)
        L73:
            r2 = r1[r2]
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.SceneRenderer.upload(android.graphics.Bitmap, boolean):int");
    }

    private static final int upload$pot(int i) {
        int i2 = 1;
        while (i2 < i && i2 < 1024) {
            i2 *= 2;
        }
        return i2;
    }

    private final void useLit(LitLocs l) {
        this.activeLit = l;
        this.lit = l.getProg();
        GLES20.glUseProgram(l.getProg());
        int[] locs = l.getLocs();
        this.uVP = locs[0];
        this.uModel = locs[1];
        this.uNrm = locs[2];
        this.uColor = locs[3];
        this.uLight = locs[4];
        this.uCam = locs[5];
        this.uEmissive = locs[6];
        this.uGrid = locs[7];
        this.uSize = locs[8];
        this.uHorizon = locs[9];
        this.uZenith = locs[10];
        this.uSun = locs[11];
        this.uAmbient = locs[12];
        this.uFogColor = locs[13];
        this.uFog = locs[14];
        this.uMat = locs[15];
        this.uSurfA = locs[16];
        this.uSurfB = locs[17];
        this.uShadow = locs[18];
        this.uShadowOn = locs[19];
        this.uShadowTexel = locs[20];
        this.uShadowVP = locs[21];
        this.uExposure = locs[22];
        this.uTime = locs[23];
        this.uTruss = locs[24];
        this.aPos = locs[25];
        this.aNrm = locs[26];
        this.uMatTex = locs[27];
        this.uMatNrm = locs[28];
        this.uTexScale = locs[29];
        this.uHasNrm = locs[30];
        this.uSurfTex = locs[31];
        this.uHasSurfTex = locs[32];
        this.aUvB = locs[33];
        this.aCol = locs[34];
        this.aMatB = locs[35];
        this.aTan = locs[36];
        this.aBit = locs[37];
    }

    private final void useMeshBatch() {
        GLES20.glUseProgram(meshBatchProgram());
        this.activeLit = null;
        GLES20.glUniformMatrix4fv(useMeshBatch$u$8(this, "uVP"), 1, false, this.studio.getView().getVp(), 0);
        GLES20.glUniformMatrix4fv(useMeshBatch$u$8(this, "uShadowVP"), 1, false, this.lightVP, 0);
        GLES20.glUniform3f(useMeshBatch$u$8(this, "uLight"), this.sunDir.getX(), this.sunDir.getY(), this.sunDir.getZ());
        GLES20.glUniform3fv(useMeshBatch$u$8(this, "uSun"), 1, this.sunColor, 0);
        GLES20.glUniform1f(useMeshBatch$u$8(this, "uAmbient"), this.ambient);
        Vector3 camPos = this.studio.getView().getCamPos();
        GLES20.glUniform3f(useMeshBatch$u$8(this, "uCam"), camPos.getX(), camPos.getY(), camPos.getZ());
        GLES20.glUniform3fv(useMeshBatch$u$8(this, "uFogColor"), 1, this.fogColor, 0);
        GLES20.glUniform3f(useMeshBatch$u$8(this, "uFog"), this.fogStart, this.fogEnd, this.fogMode);
        GLES20.glUniform1f(useMeshBatch$u$8(this, "uExposure"), this.exposure);
        GLES20.glUniform1f(useMeshBatch$u$8(this, "uShadowOn"), this.frameShadows ? 1.0f : 0.0f);
        GLES20.glUniform2f(useMeshBatch$u$8(this, "uShadowTexel"), 1.0f / this.shadowSize, 1.0f / this.shadowSize);
        GLES20.glUniform3fv(useMeshBatch$u$8(this, "uHorizon"), 1, this.horizon, 0);
        GLES20.glUniform3fv(useMeshBatch$u$8(this, "uZenith"), 1, this.zenith, 0);
        GLES20.glUniform1i(useMeshBatch$u$8(this, "uShadow"), 0);
        GLES20.glUniform1i(useMeshBatch$u$8(this, "uTex"), 1);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.shadowTex);
    }

    private static final int useMeshBatch$u$8(SceneRenderer sceneRenderer, String str) {
        Integer num = sceneRenderer.mb.get(str);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
    
        if (r2 == null) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0080 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.exampletest.mobilestudiotest.model.Instance variantFor(com.exampletest.mobilestudiotest.model.Instance r14) {
        /*
            r13 = this;
            java.util.Map<java.lang.String, ? extends java.util.List<? extends com.exampletest.mobilestudiotest.model.Instance>> r0 = r13.variantIndex
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto La
            return r1
        La:
            com.exampletest.mobilestudiotest.model.PartData r0 = com.exampletest.mobilestudiotest.model.PartData.INSTANCE
            int r0 = r0.material(r14)
            java.lang.String r2 = "MaterialVariantSerialized"
            java.lang.Object r2 = r14.get(r2)
            if (r2 != 0) goto L1e
            java.lang.String r2 = "MaterialVariant"
            java.lang.Object r2 = r14.get(r2)
        L1e:
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3b
            java.lang.String r2 = r2.toString()
            if (r2 == 0) goto L3b
            r5 = r2
            r6 = 0
            r7 = r5
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 <= 0) goto L35
            r7 = r3
            goto L36
        L35:
            r7 = r4
        L36:
            if (r7 != 0) goto L39
            r2 = r1
        L39:
            if (r2 != 0) goto L81
        L3b:
            com.exampletest.mobilestudiotest.model.Enums r2 = com.exampletest.mobilestudiotest.model.Enums.INSTANCE
            java.lang.String r5 = "Material"
            java.lang.String r2 = r2.itemName(r5, r0)
            if (r2 == 0) goto L7d
            r5 = 0
            com.exampletest.mobilestudiotest.model.Instance r6 = r13.variantService
            if (r6 == 0) goto L62
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.StringBuilder r7 = r7.append(r2)
            java.lang.String r8 = "Name"
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object r6 = r6.get(r7)
            goto L63
        L62:
            r6 = r1
        L63:
            if (r6 == 0) goto L7d
            java.lang.String r2 = r6.toString()
            if (r2 == 0) goto L7d
            r5 = r2
            r6 = 0
            r7 = r5
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 <= 0) goto L78
            r7 = r3
            goto L79
        L78:
            r7 = r4
        L79:
            if (r7 != 0) goto L7e
            r2 = r1
            goto L7e
        L7d:
            r2 = r1
        L7e:
            if (r2 != 0) goto L81
            return r1
        L81:
            java.util.Map<java.lang.String, ? extends java.util.List<? extends com.exampletest.mobilestudiotest.model.Instance>> r5 = r13.variantIndex
            java.lang.Object r5 = r5.get(r2)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto Lc2
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r6 = 0
            java.util.Iterator r7 = r5.iterator()
        L92:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lbf
            java.lang.Object r8 = r7.next()
            r9 = r8
            com.exampletest.mobilestudiotest.model.Instance r9 = (com.exampletest.mobilestudiotest.model.Instance) r9
            r10 = 0
            java.lang.String r11 = "BaseMaterial"
            java.lang.Object r11 = r9.get(r11)
            boolean r12 = r11 instanceof com.exampletest.mobilestudiotest.model.EnumValue
            if (r12 == 0) goto Lad
            com.exampletest.mobilestudiotest.model.EnumValue r11 = (com.exampletest.mobilestudiotest.model.EnumValue) r11
            goto Lae
        Lad:
            r11 = r1
        Lae:
            if (r11 == 0) goto Lb5
            int r11 = r11.getValue()
            goto Lb6
        Lb5:
            r11 = r0
        Lb6:
            if (r11 != r0) goto Lba
            r9 = r3
            goto Lbb
        Lba:
            r9 = r4
        Lbb:
            if (r9 == 0) goto L92
            r1 = r8
            goto Lc0
        Lbf:
        Lc0:
            com.exampletest.mobilestudiotest.model.Instance r1 = (com.exampletest.mobilestudiotest.model.Instance) r1
        Lc2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.render.SceneRenderer.variantFor(com.exampletest.mobilestudiotest.model.Instance):com.exampletest.mobilestudiotest.model.Instance");
    }

    private final boolean visible(CFrame cf, Vector3 size, Vector3 camPos, Vector3 fwd) {
        return inView(cf, size, camPos);
    }

    private final int whiteTex() {
        if (this.whiteTexId == 0) {
            Bitmap createBitmap = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
            createBitmap.eraseColor(-1250068);
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(createBitmap, "apply(...)");
            this.whiteTexId = upload(createBitmap, true);
        }
        return this.whiteTexId;
    }

    public final float getFps() {
        return this.fps;
    }

    public final Function0<Unit> getOnFrame() {
        return this.onFrame;
    }

    public final float getQuality() {
        return this.quality;
    }

    public final Function4<Instance, Float, Float, Bitmap, Unit> getSurfacePainter() {
        return this.surfacePainter;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl) {
        long nanoTime;
        long nanoTime2;
        long nanoTime3;
        long nanoTime4;
        long nanoTime5 = System.nanoTime();
        float coerceIn = RangesKt.coerceIn(((float) (nanoTime5 - this.lastNs)) / 1.0E9f, 0.0f, 0.1f);
        this.lastNs = nanoTime5;
        this.time += coerceIn;
        this.fpsAcc += coerceIn;
        this.fpsFrames++;
        if (this.fpsAcc >= 0.5f) {
            this.fps = this.fpsFrames / this.fpsAcc;
            this.fpsAcc = 0.0f;
            this.fpsFrames = 0;
        }
        synchronized (this.studio.getLock()) {
            try {
                try {
                    try {
                        this.studio.frame(coerceIn);
                    } catch (Exception e) {
                        OutputLog.INSTANCE.error("Simulation error: " + e);
                    }
                    FlyCamera camera = this.studio.getCamera();
                    this.studio.getView().update(camera.getPos(), camera.getPos().plus(camera.getForward()), camera.getFov(), this.studio.getView().getWidth(), this.studio.getView().getHeight(), this.nearPlane);
                    updateLighting();
                    boolean z = this.shadowsOn && this.shadowOk && this.studio.getShadowsEnabled() && this.dayFactor > 0.05f;
                    Vector3 vector3 = null;
                    Pair<Vector3, Float> shadowFocus = z ? shadowFocus() : null;
                    nanoTime = System.nanoTime();
                    if (shadowFocus != null) {
                        try {
                            vector3 = shadowFocus.getFirst();
                        } catch (Exception e2) {
                            OutputLog outputLog = OutputLog.INSTANCE;
                            String message = e2.getMessage();
                            outputLog.warn("Renderer: " + (message != null ? message : e2));
                            this.batches.reset(true);
                            this.batches.getLoose().addAll(this.studio.renderParts());
                        }
                    }
                    updateBatches(coerceIn, vector3, (shadowFocus != null ? shadowFocus.getSecond().floatValue() : 0.0f) * 1.6f);
                    nanoTime2 = System.nanoTime();
                    this.closest = Float.MAX_VALUE;
                    if (shadowFocus != null) {
                        renderShadowMap(shadowFocus.getFirst(), shadowFocus.getSecond().floatValue());
                    }
                    nanoTime3 = System.nanoTime();
                    try {
                        GLES20.glViewport(0, 0, this.surfW, this.surfH);
                        GLES20.glClearColor(this.horizon[0], this.horizon[1], this.horizon[2], 1.0f);
                        GLES20.glClear(16640);
                        drawSky();
                        drawParts(z);
                        drawSelection();
                        drawHandles();
                        nanoTime4 = System.nanoTime();
                        this.tUpd += ((float) (nanoTime2 - nanoTime)) / 1000000.0f;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
                try {
                    this.tShadow += ((float) (nanoTime3 - nanoTime2)) / 1000000.0f;
                    this.tDraw += ((float) (nanoTime4 - nanoTime3)) / 1000000.0f;
                    this.tSim += ((float) (nanoTime - nanoTime5)) / 1000000.0f;
                    float coerceIn2 = RangesKt.coerceIn(this.closest * 0.35f, 0.1f, 20.0f);
                    this.nearPlane = coerceIn2 < this.nearPlane ? coerceIn2 : this.nearPlane + ((coerceIn2 - this.nearPlane) * 0.25f);
                    Unit unit = Unit.INSTANCE;
                    Function0<Unit> function0 = this.onFrame;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    this.cpuAcc += ((float) (System.nanoTime() - nanoTime5)) / 1000000.0f;
                    this.cpuN++;
                    this.statTimer += coerceIn;
                    if (this.statTimer > 5.0f) {
                        this.statTimer = 0.0f;
                        int coerceAtLeast = RangesKt.coerceAtLeast(this.cpuN, 1);
                        String format = String.format("draw: batches %.1f loose %.1f (%d) decals %.1f [clothing %.1f surfaceGuis %.1f, %d repaints] transparent %.1f (%d)", Arrays.copyOf(new Object[]{Float.valueOf(this.tB / coerceAtLeast), Float.valueOf(this.tL / coerceAtLeast), Integer.valueOf(this.nLoose / coerceAtLeast), Float.valueOf(this.tDec / coerceAtLeast), Float.valueOf(this.tClo / coerceAtLeast), Float.valueOf(this.tSg / coerceAtLeast), Integer.valueOf(this.nSgRender), Float.valueOf(this.tTr / coerceAtLeast), Integer.valueOf(this.nTr / coerceAtLeast)}, 9));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        Log.i("MobileStudioGfx", format);
                        this.tB = 0.0f;
                        this.tL = 0.0f;
                        this.tDec = 0.0f;
                        this.tTr = 0.0f;
                        this.nTr = 0;
                        this.nLoose = 0;
                        this.tClo = 0.0f;
                        this.tSg = 0.0f;
                        this.nSgRender = 0;
                        String format2 = String.format("fps=%.1f cpuMs=%.1f (sim %.1f upd %.1f shadow %.1f draw %.1f) parts=%d loose=%d chunks=%d visibleChunks=%d gpuMB=%.1f quality=%.2f near=%.2f depth=%d", Arrays.copyOf(new Object[]{Float.valueOf(this.fps), Float.valueOf(this.cpuAcc / coerceAtLeast), Float.valueOf(this.tSim / coerceAtLeast), Float.valueOf(this.tUpd / coerceAtLeast), Float.valueOf(this.tShadow / coerceAtLeast), Float.valueOf(this.tDraw / coerceAtLeast), Integer.valueOf(this.studio.renderParts().size()), Integer.valueOf(this.batches.getLoose().size()), Integer.valueOf(this.batches.getChunks().size()), Integer.valueOf(this.batches.getVisible().size()), Float.valueOf(((float) this.batches.getTotalBytes()) / 1048576.0f), Float.valueOf(this.quality), Float.valueOf(this.nearPlane), Integer.valueOf(ViewportView.INSTANCE.getDepthBits())}, 14));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                        Log.i("MobileStudioGfx", format2);
                        this.cpuAcc = 0.0f;
                        this.cpuN = 0;
                        this.tSim = 0.0f;
                        this.tUpd = 0.0f;
                        this.tShadow = 0.0f;
                        this.tDraw = 0.0f;
                    }
                    this.slowAvg = (this.slowAvg * 0.9f) + (coerceIn * 0.1f);
                    if (this.slowAvg > 0.045f) {
                        GLES20.glFinish();
                        try {
                            Thread.sleep(RangesKt.coerceIn(this.slowAvg * 1000.0f * 0.35f, 8L, 40L));
                        } catch (InterruptedException e3) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                throw th;
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        this.surfW = width;
        this.surfH = height;
        GLES20.glViewport(0, 0, width, height);
        synchronized (this.studio.getLock()) {
            this.studio.getView().setWidth(width);
            this.studio.getView().setHeight(height);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        LitLocs litLocs = litLocs(program(LIT_VS, LIT_FS));
        useLit(litLocs);
        this.litBasic = litLocs;
        this.litAdv = null;
        this.litTex = null;
        this.matTexGpu.clear();
        this.variantBinds.clear();
        this.whiteTexId = 0;
        this.frames = 0;
        this.line = program("\nuniform mat4 uVP; uniform mat4 uModel;\nattribute vec3 aPos;\nvoid main() { gl_Position = uVP * uModel * vec4(aPos, 1.0); }", LINE_FS);
        this.depthProg = program("\nuniform mat4 uVP; uniform mat4 uModel;\nattribute vec3 aPos;\nvoid main() { gl_Position = uVP * uModel * vec4(aPos, 1.0); }", DEPTH_FS);
        this.skyProg = program(SKY_VS, SKY_FS);
        this.decalProg = program(DECAL_VS, DECAL_FS);
        this.lVP = onSurfaceCreated$u$23(this.line, "uVP");
        this.lModel = onSurfaceCreated$u$23(this.line, "uModel");
        this.lColor = onSurfaceCreated$u$23(this.line, "uColor");
        this.laPos = GLES20.glGetAttribLocation(this.line, "aPos");
        this.dVP = onSurfaceCreated$u$23(this.depthProg, "uVP");
        this.dModel = onSurfaceCreated$u$23(this.depthProg, "uModel");
        this.daPos = GLES20.glGetAttribLocation(this.depthProg, "aPos");
        this.sInvVP = onSurfaceCreated$u$23(this.skyProg, "uInvVP");
        this.sCam = onSurfaceCreated$u$23(this.skyProg, "uCam");
        this.sSun = onSurfaceCreated$u$23(this.skyProg, "uSunDir");
        this.sZenith = onSurfaceCreated$u$23(this.skyProg, "uZenith");
        this.sHorizon = onSurfaceCreated$u$23(this.skyProg, "uHorizon");
        this.sSunColor = onSurfaceCreated$u$23(this.skyProg, "uSunColor");
        this.sTime = onSurfaceCreated$u$23(this.skyProg, "uTime");
        this.sDay = onSurfaceCreated$u$23(this.skyProg, "uDay");
        this.saPos = GLES20.glGetAttribLocation(this.skyProg, "aPos");
        this.cVP = onSurfaceCreated$u$23(this.decalProg, "uVP");
        this.cModel = onSurfaceCreated$u$23(this.decalProg, "uModel");
        this.cTex = onSurfaceCreated$u$23(this.decalProg, "uTex");
        this.cTint = onSurfaceCreated$u$23(this.decalProg, "uTint");
        this.cNormal = onSurfaceCreated$u$23(this.decalProg, "uNormal");
        this.cLight = onSurfaceCreated$u$23(this.decalProg, "uLight");
        this.cSun = onSurfaceCreated$u$23(this.decalProg, "uSun");
        this.cAmbient = onSurfaceCreated$u$23(this.decalProg, "uAmbient");
        this.cUv = onSurfaceCreated$u$23(this.decalProg, "uUv");
        this.caPos = GLES20.glGetAttribLocation(this.decalProg, "aPos");
        this.caUv = GLES20.glGetAttribLocation(this.decalProg, "aUv");
        this.cube = Meshes.INSTANCE.cube();
        this.sphere = Meshes.sphere$default(Meshes.INSTANCE, 0, 0, 3, null);
        this.cylinder = Meshes.cylinder$default(Meshes.INSTANCE, 0, 1, null);
        this.cylinderY = Meshes.cylinderY$default(Meshes.INSTANCE, 0, 1, null);
        this.wedge = Meshes.INSTANCE.wedge();
        this.corner = Meshes.INSTANCE.cornerWedge();
        this.head = Meshes.head$default(Meshes.INSTANCE, 0, 1, null);
        this.headFace = Meshes.INSTANCE.headFace();
        this.quad = Meshes.INSTANCE.quad();
        this.screen = Meshes.INSTANCE.screenQuad();
        this.boxLines = Meshes.INSTANCE.boxLines();
        setupMeshProgram();
        setupSkybox();
        this.gpuMeshes.clear();
        this.unionGpu.clear();
        this.storedUnionGpu.clear();
        this.meshFrame = -1;
        this.batches.reset(false);
        ArraysKt.fill$default(this.batchLit, (Object) null, 0, 0, 6, (Object) null);
        this.shadowValid = false;
        this.noBatch = new File(this.studio.getApp().getFilesDir(), "debug_nobatch").exists();
        this.textures.clear();
        this.surfaceTex.clear();
        String glGetString = GLES20.glGetString(7939);
        if (glGetString == null) {
            glGetString = "";
        }
        float f = 0.0f;
        if (StringsKt.contains$default((CharSequence) glGetString, (CharSequence) "GL_EXT_texture_filter_anisotropic", false, 2, (Object) null)) {
            float[] fArr = new float[1];
            GLES20.glGetFloatv(GL_MAX_ANISOTROPY, fArr, 0);
            if (fArr[0] > 1.0f) {
                f = RangesKt.coerceAtMost(fArr[0], 8.0f);
            }
        }
        this.aniso = f;
        Bitmap surfaces = MaterialTextures.INSTANCE.surfaces();
        this.surfTex = surfaces != null ? upload(surfaces, true) : 0;
        this.gridTex = 0;
        this.faceTex = upload(faceBitmap(), false);
        setupShadowMap();
        GLES20.glEnable(2929);
        GLES20.glEnable(2884);
        GLES20.glCullFace(1029);
        this.lastNs = System.nanoTime();
    }

    public final void setFps(float f) {
        this.fps = f;
    }

    public final void setOnFrame(Function0<Unit> function0) {
        this.onFrame = function0;
    }

    public final void setSurfacePainter(Function4<? super Instance, ? super Float, ? super Float, ? super Bitmap, Unit> function4) {
        this.surfacePainter = function4;
    }
}
