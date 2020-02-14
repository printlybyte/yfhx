package com.yinfeng.yfhx.ui.shop;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lgd.lgd_core.base.BaseFragment;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.ShopActivityBean;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ShopFragmentHome extends BaseFragment implements View.OnClickListener {
    private ArrayList<Fragment> mFragments = null;

    private ViewPager mFragmentTab1Viewpager;
    private TabLayout mTabLayout;
    private ArrayList<String> mTitles = null;
    private ImageView mActivityShopBga;
    private ImageView mActivityShopNameHeader;
    /**
     * 格力电器期旗舰店
     */
    private TextView mActivityShopName;
    /**
     * 1.1万粉丝
     */
    private TextView mActivityShopNameFs;
    private ImageView mActivityShopCelledImg;
    private LinearLayout mActivityShopCelledOc;

    private static String mRu_id;
    private ImageView mActivityShopSearch;

    private MainShopActivity mActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (MainShopActivity) activity;

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_shop;
    }

    public static ShopFragmentHome newInstance(String ru_id) {
        Bundle args = new Bundle();
        mRu_id = ru_id;

        ShopFragmentHome generalPurposeFragment = new ShopFragmentHome();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    protected void initView(View view) {

        mTabLayout = view.findViewById(R.id.activity_shop_tablayout);
        mFragmentTab1Viewpager = (ViewPager) view.findViewById(R.id.activity_shop_vp);
        mActivityShopBga = (ImageView) view.findViewById(R.id.activity_shop_bga);
        mActivityShopNameHeader = (ImageView) view.findViewById(R.id.activity_shop_name_header);
        mActivityShopName = (TextView) view.findViewById(R.id.activity_shop_name);
        mActivityShopNameFs = (TextView) view.findViewById(R.id.activity_shop_name_fs);
        mActivityShopCelledImg = (ImageView) view.findViewById(R.id.activity_shop_celled_img);
        mActivityShopCelledOc = (LinearLayout) view.findViewById(R.id.activity_shop_celled_oc);
        mActivityShopCelledOc.setOnClickListener(this);
        mActivityShopSearch = (ImageView) view.findViewById(R.id.activity_shop_search);
        mActivityShopSearch.setOnClickListener(this);
    }


    @Override
    protected void initData() {


        requestDate();
    }


    private void setTitleDate(List<String> mList) {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        if (mTitles == null) {
            mTitles = new ArrayList<>();
        }
        mTitles.add("精选");
        mTitles.add("商品");
        mTitles.add("上新");
        mTitles.add("活动");
        mFragments.add(ShopFeaturedFragment.newInstance(mRu_id, mList));
        mFragments.add(ShopCategrayFragment.newInstance(mRu_id));
        mFragments.add(ShopNewFragment.newInstance(mRu_id));
        mFragments.add(ShopCouponFragment.newInstance(mRu_id));

        mAdapter = new MyPagerAdapter(getChildFragmentManager());
        mFragmentTab1Viewpager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mFragmentTab1Viewpager);
        mFragmentTab1Viewpager.setCurrentItem(0);
    }

    private MyPagerAdapter mAdapter;


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.activity_shop_celled_oc:
                if (mCollect_shop == 0) {
                    mActivityShopCelledImg.setImageResource(R.mipmap.ic_shop_celled_yes);
                    mCollect_shop = 1;
                } else {
                    mActivityShopCelledImg.setImageResource(R.mipmap.ic_shop_celled_no);
                    mCollect_shop = 0;
                }
                break;
            case R.id.activity_shop_search:
                mActivity.selectFragmentBtn(1);
                break;
        }
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override

        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    private int mCollect_shop = 0;

    private void requestDate() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("ru_id", mRu_id);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.visual_storein_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            ShopActivityBean bean = GsonUS.getIns().getGosn(response, ShopActivityBean.class);
                            ShopActivityBean.DataBean bean1 = bean.getData().get(0);

                            setTitleDate(bean1.getShop_banner());
                            GlideUS.loadPhoto(bean1.getShop_top(), mActivityShopBga);
                            GlideUS.loadHeader(bean1.getLogo_thumb(), mActivityShopNameHeader);
                            String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
                            mActivityShopName.setText(bean1.getRz_shopName() + "" == "" ? tipStr : bean1.getRz_shopName());
                            mActivityShopNameFs.setText(bean1.getLike_num() + "" == "" ? tipStr : bean1.getLike_num() + "粉丝");
                            mCollect_shop = bean1.getCount_gaze();
                            if (bean1.getCount_gaze() == 1) {
                                mActivityShopCelledImg.setImageResource(R.mipmap.ic_shop_celled_yes);
                            } else {
                                mActivityShopCelledImg.setImageResource(R.mipmap.ic_shop_celled_no);
                            }


                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                            }
                        }


                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {

                    }
                });
    }


}
