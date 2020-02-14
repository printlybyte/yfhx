package com.yinfeng.yfhx.ui.details;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.SlidingTabLayout;
import com.lgd.lgd_core.base.BaseFragment;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.details.FragmentEvaluationListTitleBean;
import com.yinfeng.yfhx.ui.details.evaluation.FragmentEvaluation_All;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.ui.details
 * 类  名：FragmentEvaluationList
 * 创建人：liuguodong
 * 创建时间：2019/11/15 10:15
 * ============================================
 **/
public class FragmentEvaluationList extends BaseFragment {
    private ArrayList<Fragment> mFragments = null;

    private ViewPager mFragmentTab1Viewpager;
    private SlidingTabLayout mTabLayout;
    private ArrayList<String> mTitles = null;

    private static String mGoods_id="";
    public static FragmentEvaluationList newInstance(String good_id) {
        Bundle args = new Bundle();
        mGoods_id=good_id;
        FragmentEvaluationList generalPurposeFragment = new FragmentEvaluationList();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_evaluation_list;
    }

    @Override
    protected void initView(View view) {

        mTabLayout = view.findViewById(R.id.include_tablayout);
        mFragmentTab1Viewpager = (ViewPager) view.findViewById(R.id.fragment_evaluation_list_vp);

    }

    @Override
    protected void initData() {

        requestDate();
    }


    private void requestDate() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("goods_id", mGoods_id);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.cart_comment_title_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            FragmentEvaluationListTitleBean bean = GsonUS.getIns().getGosn(response, FragmentEvaluationListTitleBean.class);

                            if (bean != null) {
                                setTitleDate(bean);
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
                })
        ;
    }

    private void setTitleDate(FragmentEvaluationListTitleBean bean) {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        if (mTitles == null) {
            mTitles = new ArrayList<>();
        }
        mTitles.add("全部评价\n" + "" + bean.getData().getAll());
        mTitles.add("好评\n" + "" + bean.getData().getGood());
        mTitles.add("中评\n" + "" + bean.getData().getIn());
        mTitles.add("差评\n" + "" + bean.getData().getRotten());
        mTitles.add("图片\n" + "" + bean.getData().getImg());
        mFragments.add(FragmentEvaluation_All.newInstance(mGoods_id));
        mFragments.add(FragmentEvaluation_All.newInstance(mGoods_id));
        mFragments.add(FragmentEvaluation_All.newInstance(mGoods_id));
        mFragments.add(FragmentEvaluation_All.newInstance(mGoods_id));
        mFragments.add(FragmentEvaluation_All.newInstance(mGoods_id));


        mAdapter = new MyPagerAdapter(getChildFragmentManager());
        mFragmentTab1Viewpager.setAdapter(mAdapter);
        mTabLayout.setViewPager(mFragmentTab1Viewpager);
        mFragmentTab1Viewpager.setCurrentItem(0);
    }

    private MyPagerAdapter mAdapter;

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
}
