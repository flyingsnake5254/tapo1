package com.tplink.iot.view.ipcamera.play.functionintroduce;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.List;

/* loaded from: classes2.dex */
public class CameraIntroduceVideoPlayPager2Adapter extends FragmentStateAdapter {
    private List<CameraIntroduceVideoPlayItemFragment> a;

    public CameraIntroduceVideoPlayPager2Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, List<CameraIntroduceVideoPlayItemFragment> list) {
        super(fragmentManager, lifecycle);
        this.a = list;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NonNull
    public Fragment createFragment(int i) {
        return this.a.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }
}
