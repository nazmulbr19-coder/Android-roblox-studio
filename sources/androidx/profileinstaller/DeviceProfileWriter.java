package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.ProfileInstaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class DeviceProfileWriter {
    private final String mApkName;
    private final AssetManager mAssetManager;
    private final File mCurProfile;
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;
    private final Executor mExecutor;
    private DexProfileData[] mProfile;
    private final String mProfileMetaSourceLocation;
    private final String mProfileSourceLocation;
    private byte[] mTranscodedProfile;
    private boolean mDeviceSupportsAotProfile = false;
    private final byte[] mDesiredVersion = desiredVersion();

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller.DiagnosticsCallback diagnosticsCallback, String str, String str2, String str3, File file) {
        this.mAssetManager = assetManager;
        this.mExecutor = executor;
        this.mDiagnostics = diagnosticsCallback;
        this.mApkName = str;
        this.mProfileSourceLocation = str2;
        this.mProfileMetaSourceLocation = str3;
        this.mCurProfile = file;
    }

    private DeviceProfileWriter addMetadata(DexProfileData[] dexProfileDataArr, byte[] bArr) {
        InputStream openStreamFromAssets;
        try {
            openStreamFromAssets = openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);
        } catch (FileNotFoundException e) {
            this.mDiagnostics.onResultReceived(9, e);
        } catch (IOException e2) {
            this.mDiagnostics.onResultReceived(7, e2);
        } catch (IllegalStateException e3) {
            this.mProfile = null;
            this.mDiagnostics.onResultReceived(8, e3);
        }
        if (openStreamFromAssets == null) {
            if (openStreamFromAssets != null) {
                openStreamFromAssets.close();
            }
            return null;
        }
        try {
            this.mProfile = ProfileTranscoder.readMeta(openStreamFromAssets, ProfileTranscoder.readHeader(openStreamFromAssets, ProfileTranscoder.MAGIC_PROFM), bArr, dexProfileDataArr);
            if (openStreamFromAssets != null) {
                openStreamFromAssets.close();
            }
            return this;
        } catch (Throwable th) {
            if (openStreamFromAssets != null) {
                try {
                    openStreamFromAssets.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (!this.mDeviceSupportsAotProfile) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] desiredVersion() {
        int i = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 31) {
            return ProfileVersion.V015_S;
        }
        switch (Build.VERSION.SDK_INT) {
            case 24:
            case 25:
                return ProfileVersion.V001_N;
            case 26:
                return ProfileVersion.V005_O;
            case 27:
                return ProfileVersion.V009_O_MR1;
            case 28:
            case 29:
            case 30:
                return ProfileVersion.V010_P;
            default:
                return null;
        }
    }

    private InputStream getProfileInputStream(AssetManager assetManager) {
        try {
            return openStreamFromAssets(assetManager, this.mProfileSourceLocation);
        } catch (FileNotFoundException e) {
            this.mDiagnostics.onResultReceived(6, e);
            return null;
        } catch (IOException e2) {
            this.mDiagnostics.onResultReceived(7, e2);
            return null;
        }
    }

    private InputStream openStreamFromAssets(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.mDiagnostics.onDiagnosticReceived(5, null);
            return null;
        }
    }

    private DexProfileData[] readProfileInternal(InputStream inputStream) {
        DexProfileData[] dexProfileDataArr = null;
        try {
            try {
                try {
                    try {
                        dexProfileDataArr = ProfileTranscoder.readProfile(inputStream, ProfileTranscoder.readHeader(inputStream, ProfileTranscoder.MAGIC_PROF), this.mApkName);
                        inputStream.close();
                    } catch (IOException e) {
                        this.mDiagnostics.onResultReceived(7, e);
                    }
                } catch (IllegalStateException e2) {
                    this.mDiagnostics.onResultReceived(8, e2);
                    inputStream.close();
                }
            } catch (IOException e3) {
                this.mDiagnostics.onResultReceived(7, e3);
                inputStream.close();
            }
            return dexProfileDataArr;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                this.mDiagnostics.onResultReceived(7, e4);
            }
            throw th;
        }
    }

    private static boolean requiresMetadata() {
        int i = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 31) {
            return true;
        }
        switch (Build.VERSION.SDK_INT) {
            case 24:
            case 25:
                return true;
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
                return false;
            default:
                return false;
        }
    }

    private void result(int i, Object obj) {
        this.mExecutor.execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(this, i, obj));
    }

    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion == null) {
            result(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.mCurProfile.exists()) {
            try {
                if (!this.mCurProfile.createNewFile()) {
                    result(4, null);
                    return false;
                }
            } catch (IOException e) {
                result(4, null);
                return false;
            }
        } else if (!this.mCurProfile.canWrite()) {
            result(4, null);
            return false;
        }
        this.mDeviceSupportsAotProfile = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$result$0$androidx-profileinstaller-DeviceProfileWriter, reason: not valid java name */
    public /* synthetic */ void m178lambda$result$0$androidxprofileinstallerDeviceProfileWriter(int i, Object obj) {
        this.mDiagnostics.onResultReceived(i, obj);
    }

    public DeviceProfileWriter read() {
        DeviceProfileWriter addMetadata;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion == null) {
            return this;
        }
        InputStream profileInputStream = getProfileInputStream(this.mAssetManager);
        if (profileInputStream != null) {
            this.mProfile = readProfileInternal(profileInputStream);
        }
        if (this.mProfile != null) {
            DexProfileData[] dexProfileDataArr = this.mProfile;
            if (requiresMetadata() && (addMetadata = addMetadata(dexProfileDataArr, this.mDesiredVersion)) != null) {
                return addMetadata;
            }
        }
        return this;
    }

    public DeviceProfileWriter transcodeIfNeeded() {
        ByteArrayOutputStream byteArrayOutputStream;
        DexProfileData[] dexProfileDataArr = this.mProfile;
        byte[] bArr = this.mDesiredVersion;
        if (dexProfileDataArr == null || bArr == null) {
            return this;
        }
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ProfileTranscoder.writeHeader(byteArrayOutputStream, bArr);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            this.mDiagnostics.onResultReceived(7, e);
        } catch (IllegalStateException e2) {
            this.mDiagnostics.onResultReceived(8, e2);
        }
        if (ProfileTranscoder.transcodeAndWriteBody(byteArrayOutputStream, bArr, dexProfileDataArr)) {
            this.mTranscodedProfile = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.mProfile = null;
            return this;
        }
        this.mDiagnostics.onResultReceived(5, null);
        this.mProfile = null;
        byteArrayOutputStream.close();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean write() {
        byte[] bArr = this.mTranscodedProfile;
        if (bArr == null) {
            return false;
        }
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.mCurProfile);
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        try {
                            FileLock tryLock = channel.tryLock();
                            try {
                                Encoding.writeAll(byteArrayInputStream, fileOutputStream, tryLock);
                                result(1, null);
                                if (tryLock != null) {
                                    tryLock.close();
                                }
                                if (channel != null) {
                                    channel.close();
                                }
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                return true;
                            } finally {
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e) {
                result(6, e);
                return false;
            } catch (IOException e2) {
                result(7, e2);
                return false;
            }
        } finally {
            this.mTranscodedProfile = null;
            this.mProfile = null;
        }
    }
}
