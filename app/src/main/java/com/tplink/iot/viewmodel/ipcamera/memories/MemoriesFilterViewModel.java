package com.tplink.iot.viewmodel.ipcamera.memories;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpmediaother.memory.p;
import com.tplink.libtpmediaother.memory.r;
import com.tplink.libtpmediaother.memory.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MemoriesFilterViewModel extends AndroidViewModel {

    /* renamed from: b  reason: collision with root package name */
    t f10381b;

    /* renamed from: c  reason: collision with root package name */
    public ObservableBoolean f10382c = new ObservableBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public ObservableBoolean f10383d = new ObservableBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public ObservableBoolean f10384e = new ObservableBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public ObservableBoolean f10385f = new ObservableBoolean(false);
    public ObservableBoolean g = new ObservableBoolean(false);
    public ObservableBoolean h = new ObservableBoolean(true);
    private MutableLiveData<List<p>> i = new MutableLiveData<>();
    r a = r.f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements t {
        a() {
        }

        @Override // com.tplink.libtpmediaother.memory.t
        public void a(List<p> list) {
            if (list != null) {
                MemoriesFilterViewModel.this.i.postValue(new ArrayList(list));
            }
        }
    }

    public MemoriesFilterViewModel(@NonNull Application application) {
        super(application);
        i();
    }

    private void i() {
        a aVar = new a();
        this.f10381b = aVar;
        this.a.a(aVar);
    }

    private void j() {
        this.a.I(this.f10381b);
    }

    public MutableLiveData<List<p>> g() {
        return this.i;
    }

    public void h() {
        this.a.B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        j();
    }
}
