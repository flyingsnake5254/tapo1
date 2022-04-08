package com.tplink.iot.musicphonerhythm.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;

/* loaded from: classes2.dex */
public class MusicPhoneRhythmActivity extends BaseActivity {
    private String y;
    private String z;

    public static void e1(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, MusicPhoneRhythmActivity.class);
        intent.putExtra("device_id_md5", str);
        intent.putExtra("USER_DEVICE_IP", str2);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_music_rhythm_empty_activity);
        if (getIntent() != null) {
            this.y = getIntent().getStringExtra("device_id_md5");
            this.z = getIntent().getStringExtra("USER_DEVICE_IP");
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            MusicPhoneRhythmFragment musicPhoneRhythmFragment = new MusicPhoneRhythmFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putString("device_id_md5", this.y);
            bundle2.putString("USER_DEVICE_IP", this.z);
            musicPhoneRhythmFragment.setArguments(bundle2);
            beginTransaction.add(R.id.container_layout, musicPhoneRhythmFragment);
            beginTransaction.commitAllowingStateLoss();
        }
    }
}
