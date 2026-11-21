package com.exampletest.mobilestudiotest.ui;

import com.exampletest.mobilestudiotest.net.CloudPlace;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: MainActions.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nH&J\"\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/MainActions;", "", "exportSelection", "", "addSelectionToToolbox", "importToToolbox", "saveBytesAs", "fileName", "", "producer", "Lkotlin/Function0;", "", "openPlaceBytes", "name", "bytes", "cloud", "Lcom/exampletest/mobilestudiotest/net/CloudPlace;", "pickPluginFile", "applyThemeChange", "pluginsChanged", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MainActions {
    void addSelectionToToolbox();

    void applyThemeChange();

    void exportSelection();

    void importToToolbox();

    void openPlaceBytes(String name, byte[] bytes, CloudPlace cloud);

    void pickPluginFile();

    void pluginsChanged();

    void saveBytesAs(String fileName, Function0<byte[]> producer);
}
