package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.Map;

/* loaded from: classes.dex */
final class ColorResourcesLoaderCreator {
    private static final String TAG = "ColorResLoaderCreator";

    private ColorResourcesLoaderCreator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ResourcesLoader create(Context context, Map<Integer, Integer> map) {
        try {
            byte[] create = ColorResourcesTableCreator.create(context, map);
            Log.i(TAG, "Table created, length: " + create.length);
            if (create.length == 0) {
                return null;
            }
            FileDescriptor fileDescriptor = null;
            try {
                fileDescriptor = Os.memfd_create("temp.arsc", 0);
                if (fileDescriptor == null) {
                    Log.w(TAG, "Cannot create memory file descriptor.");
                    return null;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(fileDescriptor);
                try {
                    fileOutputStream.write(create);
                    ParcelFileDescriptor dup = ParcelFileDescriptor.dup(fileDescriptor);
                    try {
                        ResourcesLoader resourcesLoader = new ResourcesLoader();
                        resourcesLoader.addProvider(ResourcesProvider.loadFromTable(dup, null));
                        if (dup != null) {
                            dup.close();
                        }
                        fileOutputStream.close();
                        if (fileDescriptor != null) {
                            Os.close(fileDescriptor);
                        }
                        return resourcesLoader;
                    } finally {
                    }
                } finally {
                }
            } finally {
                if (fileDescriptor != null) {
                    Os.close(fileDescriptor);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to create the ColorResourcesTableCreator.", e);
            return null;
        }
    }
}
