package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.internal.MaterialCheckable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class CheckableGroup<T extends MaterialCheckable<T>> {
    private final Map<Integer, T> checkables = new HashMap();
    private final Set<Integer> checkedIds = new HashSet();
    private OnCheckedStateChangeListener onCheckedStateChangeListener;
    private boolean selectionRequired;
    private boolean singleSelection;

    /* renamed from: com.google.android.material.internal.CheckableGroup$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements MaterialCheckable.OnCheckedChangeListener<T> {
        AnonymousClass1() {
        }

        public void onCheckedChanged(T t, boolean z) {
            CheckableGroup checkableGroup = CheckableGroup.this;
            if (z) {
                if (!CheckableGroup.access$000(checkableGroup, t)) {
                    return;
                }
            } else if (!CheckableGroup.access$200(checkableGroup, t, CheckableGroup.access$100(CheckableGroup.this))) {
                return;
            }
            CheckableGroup.access$300(CheckableGroup.this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.internal.MaterialCheckable.OnCheckedChangeListener
        public /* bridge */ /* synthetic */ void onCheckedChanged(Object obj, boolean z) {
            onCheckedChanged((AnonymousClass1) obj, z);
        }
    }

    /* loaded from: classes.dex */
    public interface OnCheckedStateChangeListener {
        void onCheckedStateChanged(Set<Integer> set);
    }

    static /* synthetic */ boolean access$000(CheckableGroup checkableGroup, MaterialCheckable materialCheckable) {
        return checkableGroup.checkInternal(materialCheckable);
    }

    static /* synthetic */ boolean access$100(CheckableGroup checkableGroup) {
        return checkableGroup.selectionRequired;
    }

    static /* synthetic */ boolean access$200(CheckableGroup checkableGroup, MaterialCheckable materialCheckable, boolean z) {
        return checkableGroup.uncheckInternal(materialCheckable, z);
    }

    static /* synthetic */ void access$300(CheckableGroup checkableGroup) {
        checkableGroup.onCheckedStateChanged();
    }

    private boolean checkInternal(MaterialCheckable<T> materialCheckable) {
        int id = materialCheckable.getId();
        if (this.checkedIds.contains(Integer.valueOf(id))) {
            return false;
        }
        T t = this.checkables.get(Integer.valueOf(getSingleCheckedId()));
        if (t != null) {
            uncheckInternal(t, false);
        }
        boolean add = this.checkedIds.add(Integer.valueOf(id));
        if (!materialCheckable.isChecked()) {
            materialCheckable.setChecked(true);
        }
        return add;
    }

    private void onCheckedStateChanged() {
        if (this.onCheckedStateChangeListener != null) {
            this.onCheckedStateChangeListener.onCheckedStateChanged(getCheckedIds());
        }
    }

    private boolean uncheckInternal(MaterialCheckable<T> materialCheckable, boolean z) {
        int id = materialCheckable.getId();
        if (!this.checkedIds.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z && this.checkedIds.size() == 1 && this.checkedIds.contains(Integer.valueOf(id))) {
            materialCheckable.setChecked(true);
            return false;
        }
        boolean remove = this.checkedIds.remove(Integer.valueOf(id));
        if (materialCheckable.isChecked()) {
            materialCheckable.setChecked(false);
        }
        return remove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addCheckable(T t) {
        this.checkables.put(Integer.valueOf(t.getId()), t);
        if (t.isChecked()) {
            checkInternal(t);
        }
        t.setInternalOnCheckedChangeListener(new AnonymousClass1());
    }

    public void check(int i) {
        T t = this.checkables.get(Integer.valueOf(i));
        if (t != null && checkInternal(t)) {
            onCheckedStateChanged();
        }
    }

    public void clearCheck() {
        boolean z = !this.checkedIds.isEmpty();
        Iterator<T> it = this.checkables.values().iterator();
        while (it.hasNext()) {
            uncheckInternal(it.next(), false);
        }
        if (z) {
            onCheckedStateChanged();
        }
    }

    public Set<Integer> getCheckedIds() {
        return new HashSet(this.checkedIds);
    }

    public List<Integer> getCheckedIdsSortedByChildOrder(ViewGroup viewGroup) {
        Set<Integer> checkedIds = getCheckedIds();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MaterialCheckable) && checkedIds.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int getSingleCheckedId() {
        if (!this.singleSelection || this.checkedIds.isEmpty()) {
            return -1;
        }
        return this.checkedIds.iterator().next().intValue();
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    public void removeCheckable(T t) {
        t.setInternalOnCheckedChangeListener(null);
        this.checkables.remove(Integer.valueOf(t.getId()));
        this.checkedIds.remove(Integer.valueOf(t.getId()));
    }

    public void setOnCheckedStateChangeListener(OnCheckedStateChangeListener onCheckedStateChangeListener) {
        this.onCheckedStateChangeListener = onCheckedStateChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.selectionRequired = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.singleSelection != z) {
            this.singleSelection = z;
            clearCheck();
        }
    }

    public void uncheck(int i) {
        T t = this.checkables.get(Integer.valueOf(i));
        if (t != null && uncheckInternal(t, this.selectionRequired)) {
            onCheckedStateChanged();
        }
    }
}
