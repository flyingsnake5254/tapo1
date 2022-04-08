package com.tplink.iot.view.authflip;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.thirdpartlink.ThirdPartLinkNetworkType;
import com.tplink.iot.widget.PointTextView;
import com.tplink.libtpgoogleassistant.bean.params.AuthCodeParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import java.util.Objects;

/* loaded from: classes2.dex */
public class AuthFragment extends BaseAppFlipFragment implements View.OnClickListener {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<String> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(String str) {
            s0.g();
            if (b.a[AuthFragment.this.f8328f.t().ordinal()] == 1) {
                AuthFragment.this.G0(str);
            } else if (!TextUtils.isEmpty(str)) {
                b.d.w.c.a.e("AuthFragment", "getAuthCode Success");
                Intent intent = new Intent();
                intent.putExtra("AUTHORIZATION_CODE", str);
                FragmentActivity activity = AuthFragment.this.getActivity();
                Objects.requireNonNull(activity);
                activity.setResult(-1, intent);
            } else {
                b.d.w.c.a.e("AuthFragment", "getAuthCode Fail");
                Intent intent2 = new Intent();
                intent2.putExtra("ERROR_TYPE", 1);
                intent2.putExtra("ERROR_CODE", 1);
                intent2.putExtra("ERROR_DESCRIPTION", "Invalid Request");
                FragmentActivity activity2 = AuthFragment.this.getActivity();
                Objects.requireNonNull(activity2);
                activity2.setResult(-2, intent2);
            }
            AuthFragment.this.getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ThirdPartLinkNetworkType.values().length];
            a = iArr;
            try {
                iArr[ThirdPartLinkNetworkType.AMAZON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ThirdPartLinkNetworkType.GOOGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(String str) {
        if (!TextUtils.isEmpty(str)) {
            b.d.w.c.a.e("AuthFragment", "getAuthCode Success");
            Uri data = getActivity().getIntent().getData();
            Uri.Builder buildUpon = Uri.parse(data.getQueryParameter("REDIRECT_URI".toLowerCase())).buildUpon();
            buildUpon.appendQueryParameter(DefaultStatesBean.KEY_STATE, data.getQueryParameter(DefaultStatesBean.KEY_STATE));
            buildUpon.appendQueryParameter("code", str);
            requireActivity().startActivity(new Intent("android.intent.action.VIEW", buildUpon.build()));
        }
    }

    private void H0(String str) {
        s0.l(getActivity());
        AuthCodeParams authCodeParams = new AuthCodeParams();
        authCodeParams.setToken(str);
        authCodeParams.setClientIdInternal(b.d.k.d.a.b());
        this.f8328f.n(authCodeParams);
    }

    @StringRes
    private int I0() {
        return b.a[this.f8328f.t().ordinal()] != 1 ? R.string.google_auth_with_title : R.string.alexa_link_title_tapo;
    }

    private void J0() {
        final String str;
        final String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        TextView textView = (TextView) this.f8326c.findViewById(R.id.tv_user);
        TextView textView2 = (TextView) this.f8326c.findViewById(R.id.tv_google_privacy);
        TextView textView3 = (TextView) this.f8326c.findViewById(R.id.tv_unbind_link);
        this.f8326c.findViewById(R.id.img_close).setOnClickListener(this);
        this.f8326c.findViewById(R.id.btn_agree).setOnClickListener(this);
        String r = this.f8328f.r();
        if (!TextUtils.isEmpty(r)) {
            textView.setText(getString(R.string.google_auth_user_is, r));
        }
        String string = getString(R.string.about_item_title_privacy);
        if (b.a[this.f8328f.t().ordinal()] != 1) {
            str7 = getString(R.string.google_auth_privacy_policy, string);
            str6 = getString(R.string.google_auth_will_be_able);
            str5 = getString(R.string.google_auth_able_tips2);
            str4 = getString(R.string.google_auth_able_tips3);
            str3 = getString(R.string.google_auth_able_tips4);
            str2 = "https://myaccount.google.com/";
            str = "https://policies.google.com/";
        } else {
            str7 = getString(R.string.alexa_auth_privacy_policy, string);
            str6 = getString(R.string.alexa_auth_will_be_able);
            str5 = getString(R.string.alexa_auth_able_tips2);
            str4 = getString(R.string.alexa_auth_able_tips3);
            str3 = getString(R.string.alexa_auth_able_tips4);
            str2 = "https://alexa.amazon.com/";
            str = "https://www.alexa.com/help/privacy";
        }
        d0.c(textView2, str7, string, ContextCompat.getColor(requireActivity(), R.color.common_iot_purple), new d0.g() { // from class: com.tplink.iot.view.authflip.b
            @Override // com.tplink.iot.Utils.d0.g
            public final void a() {
                AuthFragment.this.L0(str);
            }
        });
        String string2 = getString(R.string.common_here);
        d0.c(textView3, getString(R.string.google_auth_unlink, string2), string2, ContextCompat.getColor(requireActivity(), R.color.common_iot_purple), new d0.g() { // from class: com.tplink.iot.view.authflip.a
            @Override // com.tplink.iot.Utils.d0.g
            public final void a() {
                AuthFragment.this.O0(str2);
            }
        });
        ((TextView) this.f8326c.findViewById(R.id.tv_title)).setText(I0());
        ((TextView) this.f8326c.findViewById(R.id.tv_link_able_title)).setText(str6);
        ((PointTextView) this.f8326c.findViewById(R.id.tv_tips2)).setContent(str5);
        ((PointTextView) this.f8326c.findViewById(R.id.tv_tips3)).setContent(str4);
        ((PointTextView) this.f8326c.findViewById(R.id.tv_tips4)).setContent(str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ void L0(String str) {
        if (this.f8327d != null) {
            this.f8328f.B(str);
            this.f8327d.e0("WebViewFragment", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ void O0(String str) {
        if (this.f8327d != null) {
            this.f8328f.B(str);
            this.f8327d.e0("WebViewFragment", null);
        }
    }

    private void P0() {
        this.f8328f.o().observe(this, new a());
    }

    private void Q0() {
        if (getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().getData() != null) {
            Uri data = getActivity().getIntent().getData();
            String queryParameter = data.getQueryParameter("CLIENT_ID".toLowerCase());
            String queryParameter2 = data.getQueryParameter("response_type");
            String queryParameter3 = data.getQueryParameter(DefaultStatesBean.KEY_STATE);
            String queryParameter4 = data.getQueryParameter("SCOPE".toLowerCase());
            String queryParameter5 = data.getQueryParameter("REDIRECT_URI".toLowerCase());
            Uri.Builder buildUpon = Uri.parse(b.d.k.d.a.a()).buildUpon();
            buildUpon.appendQueryParameter("CLIENT_ID".toLowerCase(), queryParameter);
            buildUpon.appendQueryParameter("response_type", queryParameter2);
            buildUpon.appendQueryParameter(DefaultStatesBean.KEY_STATE, queryParameter3);
            buildUpon.appendQueryParameter("SCOPE".toLowerCase(), queryParameter4);
            buildUpon.appendQueryParameter("REDIRECT_URI".toLowerCase(), queryParameter5);
            Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
            intent.addFlags(268435456);
            requireActivity().startActivity(intent);
        }
    }

    @Override // com.tplink.iot.view.authflip.BaseAppFlipFragment
    public int A0() {
        return R.layout.fragment_auth;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_agree) {
            String m = this.f8328f.m();
            int i = b.a[this.f8328f.t().ordinal()];
            if (i == 1) {
                H0(m);
            } else if (i == 2) {
                s0.l(getActivity());
                AuthCodeParams authCodeParams = new AuthCodeParams();
                authCodeParams.setToken(m);
                authCodeParams.setClientIdInternal(b.d.k.d.a.b());
                this.f8328f.n(authCodeParams);
            }
        } else if (id == R.id.img_close) {
            int i2 = b.a[this.f8328f.t().ordinal()];
            if (i2 == 1) {
                Q0();
            } else if (i2 == 2) {
                Intent intent = new Intent();
                FragmentActivity activity = getActivity();
                Objects.requireNonNull(activity);
                activity.setResult(0, intent);
            }
            getActivity().finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f8327d.q0();
        J0();
        P0();
    }
}
