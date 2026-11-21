package com.github.luben.zstd.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public enum Native {
    ;

    private static final String nativePathOverride = "ZstdNativePath";
    private static final String libnameShort = "zstd-jni-1.5.6-3";
    private static final String libname = "libzstd-jni-1.5.6-3";
    private static final String errorMsg = "Unsupported OS/arch, cannot find " + resourceName() + " or load " + libnameShort + " from system libraries. Please try building from source the jar or providing " + libname + " in your system.";
    private static AtomicBoolean loaded = new AtomicBoolean(false);

    /* renamed from: com.github.luben.zstd.util.Native$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements PrivilegedAction<Void> {
        final /* synthetic */ String val$libName;

        AnonymousClass1(String str) {
            this.val$libName = str;
        }

        @Override // java.security.PrivilegedAction
        public /* bridge */ /* synthetic */ Void run() {
            return run2();
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: run, reason: avoid collision after fix types in other method */
        public Void run2() {
            System.loadLibrary(this.val$libName);
            return null;
        }
    }

    /* renamed from: com.github.luben.zstd.util.Native$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements PrivilegedAction<Void> {
        final /* synthetic */ String val$libFileName;

        AnonymousClass2(String str) {
            this.val$libFileName = str;
        }

        @Override // java.security.PrivilegedAction
        public /* bridge */ /* synthetic */ Void run() {
            return run2();
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: run, reason: avoid collision after fix types in other method */
        public Void run2() {
            System.load(this.val$libFileName);
            return null;
        }
    }

    public static synchronized void assumeLoaded() {
        synchronized (Native.class) {
            loaded.set(true);
        }
    }

    public static synchronized boolean isLoaded() {
        boolean z;
        synchronized (Native.class) {
            z = loaded.get();
        }
        return z;
    }

    private static String libExtension() {
        return (osName().contains("os_x") || osName().contains("darwin")) ? "dylib" : osName().contains("win") ? "dll" : "so";
    }

    public static synchronized void load() {
        synchronized (Native.class) {
            load(null);
        }
    }

    public static synchronized void load(File file) {
        synchronized (Native.class) {
            if (loaded.get()) {
                return;
            }
            String resourceName = resourceName();
            String property = System.getProperty(nativePathOverride);
            if (property != null) {
                loadLibraryFile(property);
                loaded.set(true);
                return;
            }
            try {
                Class.forName("org.osgi.framework.BundleEvent");
                loadLibrary(libname);
                loaded.set(true);
            } catch (Throwable th) {
                InputStream resourceAsStream = Native.class.getResourceAsStream(resourceName);
                if (resourceAsStream == null) {
                    try {
                        loadLibrary(libnameShort);
                        loaded.set(true);
                        return;
                    } catch (UnsatisfiedLinkError e) {
                        UnsatisfiedLinkError unsatisfiedLinkError = new UnsatisfiedLinkError(e.getMessage() + "\n" + errorMsg);
                        unsatisfiedLinkError.setStackTrace(e.getStackTrace());
                        throw unsatisfiedLinkError;
                    }
                }
                File file2 = null;
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        File createTempFile = File.createTempFile(libname, "." + libExtension(), file);
                        createTempFile.deleteOnExit();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(createTempFile);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = resourceAsStream.read(bArr);
                            if (read == -1) {
                                try {
                                    break;
                                } catch (IOException e2) {
                                }
                            } else {
                                fileOutputStream2.write(bArr, 0, read);
                            }
                        }
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        fileOutputStream2 = null;
                        try {
                            loadLibraryFile(createTempFile.getAbsolutePath());
                        } catch (UnsatisfiedLinkError e3) {
                            try {
                                loadLibrary(libnameShort);
                            } catch (UnsatisfiedLinkError e4) {
                                UnsatisfiedLinkError unsatisfiedLinkError2 = new UnsatisfiedLinkError(e3.getMessage() + "\n" + e4.getMessage() + "\n" + errorMsg);
                                unsatisfiedLinkError2.setStackTrace(e4.getStackTrace());
                                throw unsatisfiedLinkError2;
                            }
                        }
                        loaded.set(true);
                        try {
                            resourceAsStream.close();
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            if (createTempFile == null || !createTempFile.exists()) {
                                return;
                            }
                            createTempFile.delete();
                        } catch (IOException e5) {
                        }
                    } catch (IOException e6) {
                        ExceptionInInitializerError exceptionInInitializerError = new ExceptionInInitializerError("Cannot unpack libzstd-jni-1.5.6-3: " + e6.getMessage());
                        exceptionInInitializerError.setStackTrace(e6.getStackTrace());
                        throw exceptionInInitializerError;
                    }
                } catch (Throwable th2) {
                    try {
                        resourceAsStream.close();
                        if (0 != 0) {
                            fileOutputStream.close();
                        }
                        if (0 != 0 && file2.exists()) {
                            file2.delete();
                        }
                    } catch (IOException e7) {
                    }
                    throw th2;
                }
            }
        }
    }

    private static void loadLibrary(String str) {
        AccessController.doPrivileged(new AnonymousClass1(str));
    }

    private static void loadLibraryFile(String str) {
        AccessController.doPrivileged(new AnonymousClass2(str));
    }

    private static String osArch() {
        return System.getProperty("os.arch");
    }

    private static String osName() {
        String replace = System.getProperty("os.name").toLowerCase().replace(' ', '_');
        return replace.startsWith("win") ? "win" : replace.startsWith("mac") ? "darwin" : replace;
    }

    private static String resourceName() {
        return "/" + osName() + "/" + osArch() + "/" + libname + "." + libExtension();
    }
}
