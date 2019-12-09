package com.yinfeng.yfhx.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.lgd.lgd_core.base.BaseFragment;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.Tab_4_FragmentBean;
import com.yinfeng.yfhx.ui.me.HistoryIndexActivity;
import com.yinfeng.yfhx.ui.me.MeAddressActivity;
import com.yinfeng.yfhx.ui.me.MeCelledGoodsActivity;
import com.yinfeng.yfhx.ui.me.MeCelledStorgeActivity;
import com.yinfeng.yfhx.ui.me.MeInvoiceActivity;
import com.yinfeng.yfhx.ui.me.PersonalInfoActivity;
import com.yinfeng.yfhx.ui.me.coupon.MeCouponActivity;
import com.yinfeng.yfhx.ui.me.redpack.MeReadPackActivity;
import com.yinfeng.yfhx.ui.me.redpack.MeRedPackFragmentNot;
import com.yinfeng.yfhx.ui.me.savecard.MeSaveCardActivity;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.fragments
 * 类  名：Tab_1_Fragment
 * 创建人：liuguodong
 * 创建时间：2019/9/2 16:51
 * ============================================
 **/
public class Tab_4_Fragment extends BaseFragment implements View.OnClickListener {

    private ImageView mFragmentTab4Headerimg;
    /**
     * 287253237
     */
    private TextView mFragmentTab4Name;
    private View view;
    private LinearLayout mFragmentTab4PersonalInfo;
    private LinearLayout mFragmentTab4MeInvoice;
    private LinearLayout mFragmentTab4MeAddress;
    private LinearLayout mFragmentTab4MeCoupon;
    private LinearLayout mFragmentTab4AccountManagementOc;
    private LinearLayout mFragmentTab4MeCelledOc;
    private LinearLayout mFragmentTab4FollowStoresOc;
    private LinearLayout mFragmentTab4MyFootprintOc;
    private LinearLayout mFragmentTab4MyInviteFriendsOc;
    private LinearLayout mFragmentTab4RedpackOc;
    private LinearLayout mFragmentTab4SavecadeOc;

    public static Tab_4_Fragment newInstance() {
        Bundle args = new Bundle();
        Tab_4_Fragment sampleFragment = new Tab_4_Fragment();
        sampleFragment.setArguments(args);
        return sampleFragment;
    }


    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_tab_4;
    }

    @Override
    protected void initView(View view) {
        mFragmentTab4Headerimg = (ImageView) view.findViewById(R.id.fragment_tab_4_headerimg);
        mFragmentTab4Name = (TextView) view.findViewById(R.id.fragment_tab_4_name);
        mFragmentTab4PersonalInfo = (LinearLayout) view.findViewById(R.id.fragment_tab_4_personal_info);
        mFragmentTab4PersonalInfo.setOnClickListener(this);
        mFragmentTab4MeInvoice = (LinearLayout) view.findViewById(R.id.fragment_tab_4_me_invoice);
        mFragmentTab4MeInvoice.setOnClickListener(this);
        mFragmentTab4MeAddress = (LinearLayout) view.findViewById(R.id.fragment_tab_4_me_address);
        mFragmentTab4MeAddress.setOnClickListener(this);
        mFragmentTab4MeCoupon = (LinearLayout) view.findViewById(R.id.fragment_tab_4_me_coupon);
        mFragmentTab4MeCoupon.setOnClickListener(this);
        mFragmentTab4AccountManagementOc = (LinearLayout) view.findViewById(R.id.fragment_tab_4_account_management_oc);
        mFragmentTab4AccountManagementOc.setOnClickListener(this);
        mFragmentTab4MeCelledOc = (LinearLayout) view.findViewById(R.id.fragment_tab_4_me_celled_oc);
        mFragmentTab4MeCelledOc.setOnClickListener(this);
        mFragmentTab4FollowStoresOc = (LinearLayout) view.findViewById(R.id.fragment_tab_4_follow_stores_oc);
        mFragmentTab4FollowStoresOc.setOnClickListener(this);
        mFragmentTab4MyFootprintOc = (LinearLayout) view.findViewById(R.id.fragment_tab_4_my_footprint_oc);
        mFragmentTab4MyFootprintOc.setOnClickListener(this);
        mFragmentTab4MyInviteFriendsOc = (LinearLayout) view.findViewById(R.id.fragment_tab_4_my_invite_friends_oc);
        mFragmentTab4MyInviteFriendsOc.setOnClickListener(this);
        mFragmentTab4RedpackOc = (LinearLayout) view.findViewById(R.id.fragment_tab_4_redpack_oc);
        mFragmentTab4RedpackOc.setOnClickListener(this);
        mFragmentTab4SavecadeOc = (LinearLayout) view.findViewById(R.id.fragment_tab_4_savecade_oc);
        mFragmentTab4SavecadeOc.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        requestDate();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            //TODO now visible to user
        } else {
            //TODO now invisible to user
        }
    }

    private void requestDate() {
        new OKBuilder(getActivity())
                .setNetUrl(Api.user_profile_get)
                .showLoading("loading...")
                .get()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        Tab_4_FragmentBean bean = GsonUS.getIns().getGosn(response, Tab_4_FragmentBean.class);
                        if (bean != null && bean.getData() != null) {
                            setProfileDate(bean.getData());
                        } else {

                        }

                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }

    private void setProfileDate(Tab_4_FragmentBean.DataBean bean) {
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        mFragmentTab4Name.setText(bean.getName() == null ? tipStr : bean.getName());
        GlideUS.loadHeader("https://pic3.58cdn.com.cn/anjuke_58/cf39a43ebaf88a2b0ad75259c89ff402", mFragmentTab4Headerimg);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fragment_tab_4_personal_info:
                ActivityUtils.startActivity(PersonalInfoActivity.class);
                break;
            case R.id.fragment_tab_4_me_invoice:
                ActivityUtils.startActivity(MeInvoiceActivity.class);
                break;
            case R.id.fragment_tab_4_me_address:
                ActivityUtils.startActivity(MeAddressActivity.class);
                break;
            case R.id.fragment_tab_4_me_coupon:
                ActivityUtils.startActivity(MeCouponActivity.class);
                break;
            case R.id.fragment_tab_4_account_management_oc:

                break;
            case R.id.fragment_tab_4_me_celled_oc:
                ActivityUtils.startActivity(MeCelledGoodsActivity.class);
                break;
            case R.id.fragment_tab_4_follow_stores_oc:
                ActivityUtils.startActivity(MeCelledStorgeActivity.class);

                break;
            case R.id.fragment_tab_4_my_footprint_oc:
                ActivityUtils.startActivity(HistoryIndexActivity.class);
                break;
            case R.id.fragment_tab_4_my_invite_friends_oc:

                break;
            case R.id.fragment_tab_4_redpack_oc:
                ActivityUtils.startActivity(MeReadPackActivity.class);
                break;
            case R.id.fragment_tab_4_savecade_oc:
                ActivityUtils.startActivity(MeSaveCardActivity.class);

                break;
        }
    }



}
