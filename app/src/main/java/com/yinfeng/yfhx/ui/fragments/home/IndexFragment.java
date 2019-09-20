package com.yinfeng.yfhx.ui.fragments.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.base.BaseFragment;
import com.lgd.lgd_core.entity.XBannerImageBean;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ScreenUtilsx;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.XbannerUtils;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.entity.LocalImageInfo;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.MultipleTabHomeItem;
import com.yinfeng.yfhx.entity.TabFragment1Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================
 * 描  述：首页-
 * 包  名：com.yinfeng.yfhx.ui.fragments.home
 * 类  名：IndexFragment
 * 创建人：liuguodong
 * 创建时间：2019/9/9 9:52
 * ============================================
 **/
public class IndexFragment extends BaseFragment {
    private HomeAdapter mHomeAdapter;
    private RecyclerView mIncludeRecyclerview;

    private XBanner mBanner;


    public static IndexFragment newInstance() {
        Bundle args = new Bundle();
        IndexFragment sampleFragment = new IndexFragment();
        sampleFragment.setArguments(args);
        return sampleFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initView(View view) {
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_recyclerview);

        mBanner = view.findViewById(R.id.item_fragment_tab1_banners_layout_banner);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ScreenUtilsx.getScreenWidthx(getActivity()) / 2);
        mBanner.setLayoutParams(layoutParams);
    }

    @Override
    protected void initData() {
        String path = "https://t12.baidu.com/it/u=541581695,4055461334&fm=763";
//        GlideUS.loadHeader(path, mFragmentTab1Img);
//        GlideUS.loadPhoto(path, mFragmentTab1Imgheader);

        requestDate();
    }

    /**
     * 请求首页数据
     */
    private void requestDate() {
        new OKBuilder()
                .setNetUrl(Api.shop_get)
                .get()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        TabFragment1Bean bean = GsonUS.getIns().getGosn(response, TabFragment1Bean.class);
                        if (bean != null) {
                            setBannerDate(bean);
//                            setAdapter(bean);
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {

                    }
                })
        ;
    }


    /**
     * 设置xbanner数据
     */
    private void setBannerDate(TabFragment1Bean bean) {
        mBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                ToastUS.Normal("点击了第" + (position + 1) + "图片");
            }
        });
        List<XBannerImageBean> data = new ArrayList<>();
        for (int i = 0; i < bean.getBanners().size(); i++) {
            XBannerImageBean xBannerImageBean = new XBannerImageBean();
            xBannerImageBean.setPath(bean.getBanners().get(i).getPic() + "");
            data.add(xBannerImageBean);
        }
        XbannerUtils.getIns().setXbanner(mBanner, data);
    }

    /**
     * 初始化本地banner数据
     */
    private void initLocalImage() {
        List<LocalImageInfo> data = new ArrayList<>();
        data.add(new LocalImageInfo(R.drawable.splash_start));
        data.add(new LocalImageInfo(R.drawable.splash_start));
        data.add(new LocalImageInfo(R.drawable.splash_start));
        data.add(new LocalImageInfo(R.drawable.splash_start));
        mBanner.setBannerData(data);
        mBanner.setAutoPlayAble(true);
    }

    private void setAdapter(TabFragment1Bean bean) {
        mHomeAdapter = new HomeAdapter(getActivity(), bean.getBanners());
        mHomeAdapter.openLoadAnimation();
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 1);
        mIncludeRecyclerview.setLayoutManager(layoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mIncludeRecyclerview.setAdapter(mHomeAdapter);
    }

    public static List<TabFragment1Bean> getMultipleItemData(TabFragment1Bean response) {
        List<TabFragment1Bean> list = new ArrayList<>();
        List<TabFragment1Bean.BannersBean> listBanner = new ArrayList<>();
        for (int i = 0; i < response.getBanners().size(); i++) {
        }
        return list;
    }


    private class HomeAdapter extends BaseMultiItemQuickAdapter<MultipleTabHomeItem, HomeAdapter.MyHolder> {
        @Override
        protected void convert(MyHolder helper, MultipleTabHomeItem item) {
        }

        public HomeAdapter(Context context, List data) {
            super(data);
//            addItemType(MultipleTabHomeItem.ads, R.layout.item_fragment_tab1_ads_layout);
        }


        class MyHolder extends BaseViewHolder {
            public MyHolder(View view) {
                super(view);
            }
        }
    }


}
