package com.yinfeng.yfhx.adapter.home;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.entity.XBannerImageBean;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.marqueenview.AutoVerticalViewDataData;
import com.lgd.lgd_core.ui.marqueenview.AutoVerticalViewView;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.XbannerUtils;
import com.stx.xhb.xbanner.XBanner;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.MultipleTabHomeItem;
import com.yinfeng.yfhx.entity.TabFragment1Bean;
import com.yinfeng.yfhx.ui.details.CommodityDetailsActivity;
import com.yinfeng.yfhx.ui.shop.ShopActivity;
import com.yinfeng.yfhx.ui.utils.ShopCarUtils;
import com.yinfeng.yfhx.ui.webview.BrowserActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.fragments.adapter
 * 类  名：HomeIndexAdapter
 * 创建人：liuguodong
 * 创建时间：2019/9/24 17:16
 * ============================================
 **/
public class HomeIndexAdapter extends BaseMultiItemQuickAdapter<MultipleTabHomeItem, HomeIndexAdapter.MyHolder> {
    private Context mContext;

    @Override
    protected void convert(MyHolder helper, MultipleTabHomeItem item) {
        addOnClickListener(helper);
        switch (helper.getItemViewType()) {
            case MultipleTabHomeItem.banners:
                List<TabFragment1Bean.DataBean.BannersBean> mListBanner = item.getBean();
                setBannerDate(helper, mListBanner);
                break;
            case MultipleTabHomeItem.navs:
                List<TabFragment1Bean.DataBean.NavsBean> mListNav = item.getBean();
                setNavAdapter(helper, mListNav);
                break;
            case MultipleTabHomeItem.topic:
                List<TabFragment1Bean.DataBean.TopicBean> mListTopic = item.getBean();
                setTopicAdapter(helper, mListTopic);

                break;
            case MultipleTabHomeItem.noticelist:
                List<TabFragment1Bean.DataBean.NoticelistBean> mListNotice = item.getBean();
                setNoticeAdapter(helper, mListNotice);
                break;
            case MultipleTabHomeItem.seckills:
                List<TabFragment1Bean.DataBean.SeckillsBean> mListSeckills = item.getBean();
                setSeckillsAdapter(helper, mListSeckills);
                break;
            case MultipleTabHomeItem.ads:
                List<TabFragment1Bean.DataBean.AdsBean> mListAds = item.getBean();
                setAdsAdapter(helper, mListAds);
                break;

            case MultipleTabHomeItem.stores:
                List<TabFragment1Bean.DataBean.StoresBean> mListStores = item.getBean();
                setStoresAdapter(helper, mListStores);
                break;
            case MultipleTabHomeItem.newgoods:
                List<TabFragment1Bean.DataBean.NewgoodsBean> mListNewgoods = item.getBean();
                setNewGoodsAdapter(helper, mListNewgoods);
                break;
        }


    }

    /**
     * 设置xbanner数据
     */
    private void setBannerDate(MyHolder helper, List<TabFragment1Bean.DataBean.BannersBean> mList) {
        if (mList != null && mList.size() > 0) {
            helper.mBanner.setOnItemClickListener(new XBanner.OnItemClickListener() {
                @Override
                public void onItemClick(XBanner banner, Object model, View view, int position) {
                    ToastUS.Error(mList.get(position).getUrl());
                    ITTUtils.Jump(BrowserActivity.class, "" + mList.get(position).getUrl());
                }
            });
            List<XBannerImageBean> data = new ArrayList<>();
            for (int i = 0; i < mList.size(); i++) {
                XBannerImageBean xBannerImageBean = new XBannerImageBean();
                xBannerImageBean.setPath(mList.get(i).getPic() + "");
                data.add(xBannerImageBean);
            }
            XbannerUtils.getIns().setXbanner(helper.mBanner, data);
        }
    }

    /**
     * 初始化本地banner数据
     */
//    private void initLocalImage() {
//        List<LocalImageInfo> data = new ArrayList<>();
//        data.add(new LocalImageInfo(R.drawable.splash_start));
//        data.add(new LocalImageInfo(R.drawable.splash_start));
//        data.add(new LocalImageInfo(R.drawable.splash_start));
//        data.add(new LocalImageInfo(R.drawable.splash_start));
//        mBanner.setBannerData(data);
//        mBanner.setAutoPlayAble(true);
//    }
    private void setNavAdapter(MyHolder helper, List<TabFragment1Bean.DataBean.NavsBean> mList) {
        if (mList != null && mList.size() > 0) {
            NavAdapter navAdapter = new NavAdapter(R.layout.ri_home_nav_item, mList);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(Latte.getApplicationContext(), 4);
            helper.recyclerView_nav.setLayoutManager(gridLayoutManager);
            helper.recyclerView_nav.setAdapter(navAdapter);
            navAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    ToastUS.Warning(position + "");
                }
            });
        }
    }

    private void setTopicAdapter(MyHolder helper, List<TabFragment1Bean.DataBean.TopicBean> mList) {
        if (mList != null && mList.size() > 0) {
            String mPath = mList.get(0).getPic();
            GlideUS.loadPhoto(mPath, helper.imageView_topic);

        }
    }

    private void setNoticeAdapter(MyHolder helper, List<TabFragment1Bean.DataBean.NoticelistBean> mList) {
        if (mList != null && mList.size() > 0) {
            final List<AutoVerticalViewDataData> data = new ArrayList<AutoVerticalViewDataData>();
            for (int i = 0; i < mList.size(); i++) {
                data.add(new AutoVerticalViewDataData("公告", mList.get(i).getTitle() + "", mList.get(i).getUrl() + ""));
                data.add(new AutoVerticalViewDataData("公告", mList.get(i).getTitle() + "", mList.get(i).getUrl() + ""));
                data.add(new AutoVerticalViewDataData("互动", "特朗普任内对朝采取军事行动？ 美或为此付出代价", "5"));
                data.add(new AutoVerticalViewDataData("互动", "特朗普任内对朝采取军事行动？ 美或为此付出代价", "5"));
            }
            helper.autoVerticalViewView_notice.setViews(data);
            helper.autoVerticalViewView_notice.setOnItemClickListener(new AutoVerticalViewView.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Toast.makeText(mContext, "你点击了" + data.get(position).getValue(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void setSeckillsAdapter(MyHolder helper, List<TabFragment1Bean.DataBean.SeckillsBean> mList) {
        if (mList != null && mList.size() > 0 && mList.size() == 3) {
            GlideUS.loadPhoto(mList.get(0).getGoods_img(), helper.imageView_seckils1);
            GlideUS.loadPhoto(mList.get(1).getGoods_img(), helper.imageView_seckils2);
            GlideUS.loadPhoto(mList.get(2).getGoods_img(), helper.imageView_seckils3);
            helper.linearLayout_seckils1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUS.Error("" + mList.get(0).getGoods_name());
                }
            });
            helper.linearLayout_seckils2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUS.Error("" + mList.get(1).getGoods_name());
                }
            });
            helper.linearLayout_seckils3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUS.Error("" + mList.get(2).getGoods_name());
                }
            });
            helper.textView_seckils_query_all.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUS.Error("all");
                }
            });
        }
    }

    private void setAdsAdapter(MyHolder helper, List<TabFragment1Bean.DataBean.AdsBean> mList) {
        if (mList != null && mList.size() > 0 && mList.size() == 4) {
            GlideUS.loadPhoto(mList.get(0).getPic(), helper.imageView_ads1);
            GlideUS.loadPhoto(mList.get(1).getPic(), helper.imageView_ads2);
            GlideUS.loadPhoto(mList.get(2).getPic(), helper.imageView_ads3);
            GlideUS.loadPhoto(mList.get(3).getPic(), helper.imageView_ads4);
            helper.imageView_ads1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ITTUtils.Jump(BrowserActivity.class, mList.get(0).getUrl());
                }
            });
            helper.imageView_ads2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ITTUtils.Jump(BrowserActivity.class, mList.get(1).getUrl());

                }
            });
            helper.imageView_ads3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ITTUtils.Jump(BrowserActivity.class, mList.get(2).getUrl());

                }
            });
            helper.imageView_ads4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ITTUtils.Jump(BrowserActivity.class, mList.get(3).getUrl());

                }
            });
        }


    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                default:

            }
        }
    };

    private void setStoresAdapter(MyHolder helper, List<TabFragment1Bean.DataBean.StoresBean> mList) {
        if (mList != null && mList.size() > 0) {
            StoresAdapter storesAdapter = new StoresAdapter(R.layout.ri_home_stores_item, mList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext()) {
                @Override
                public boolean canScrollVertically() {
                    //禁止滑动
                    return false;
                }
            };
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            helper.recyclerView_stores.setLayoutManager(linearLayoutManager);
            helper.recyclerView_stores.setAdapter(storesAdapter);
            storesAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    TabFragment1Bean.DataBean.StoresBean bean = storesAdapter.getData().get(position);
                    switch (view.getId()) {
                        case R.id.ri_home_stores_item_group:
                            ITTUtils.Jump(ShopActivity.class, bean.getRu_id() + "");
                            break;
                        case R.id.ri_home_stores_item_mark_group1:
                            TabFragment1Bean.DataBean.StoresBean.GoodsBean goodsBean1 = bean.getGoods().get(0);
                            ITTUtils.Jump(CommodityDetailsActivity.class, goodsBean1.getGoods_id() + "");
                            break;
                        case R.id.ri_home_stores_item_mark_group2:
                            TabFragment1Bean.DataBean.StoresBean.GoodsBean goodsBean2 = bean.getGoods().get(1);
//                            ToastUS.Error(""+goodsBean2.getGoods_name() + "");
                            ITTUtils.Jump(CommodityDetailsActivity.class, goodsBean2.getGoods_id() + "");

                            break;
                        case R.id.ri_home_stores_item_mark_group3:
                            TabFragment1Bean.DataBean.StoresBean.GoodsBean goodsBean3 = bean.getGoods().get(2);
                            ITTUtils.Jump(CommodityDetailsActivity.class, goodsBean3.getGoods_id() + "");
                            break;


                        default:
                    }
                }
            });
        }
    }


    private void setNewGoodsAdapter(MyHolder helper, List<TabFragment1Bean.DataBean.NewgoodsBean> mList) {
        if (mList != null && mList.size() > 0) {
            NewGoodsAdapter newGoodsAdapter = new NewGoodsAdapter(R.layout.ri_home_newgoods_item, mList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext()) {
                @Override
                public boolean canScrollVertically() {
                    //禁止滑动
                    return false;
                }
            };
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            helper.recyclerView_newgoods.setLayoutManager(linearLayoutManager);
            helper.recyclerView_newgoods.setAdapter(newGoodsAdapter);
            newGoodsAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                    TabFragment1Bean.DataBean.NewgoodsBean bean = newGoodsAdapter.getData().get(position);
                    String Goods_id = newGoodsAdapter.getData().get(position).getGoods_id() + "";
                    switch (view.getId()) {
                        case R.id.ri_home_newgoods_item_group:
                            ITTUtils.Jump(CommodityDetailsActivity.class, Goods_id + "");

//                            ToastUS.Warning(position + "" + bean.getGoods_name());
                            break;
                        case R.id.ri_home_newgoods_item_add_shop:
                            String mProd = newGoodsAdapter.getData().get(position).getProd() + "";
                            if (!TextUtils.isEmpty(mProd)) {
                                if (mProd.equals("1")) {
                                    ShopCarUtils.getInstance().add(Goods_id, null, false);
                                } else {
                                    ITTUtils.Jump(CommodityDetailsActivity.class, Goods_id);
                                }
                            } else {
                                ToastUS.Warning("err err");
                            }
//                            ToastUS.Error(position + "" + bean.getGoods_name());
                            break;
                        default:
                    }

                }
            });


        }
    }

    private void addOnClickListener(MyHolder helper) {
        helper.addOnClickListener(R.id.item_fragment_tab1_topic_layout_img);
    }

    public HomeIndexAdapter(List data, Context context) {
        super(data);
        mContext = context;
        addItemType(MultipleTabHomeItem.banners, R.layout.item_fragment_tab1_banners_layout);
        addItemType(MultipleTabHomeItem.navs, R.layout.item_fragment_tab1_navs_layout);
        addItemType(MultipleTabHomeItem.topic, R.layout.item_fragment_tab1_topic_layout);
        addItemType(MultipleTabHomeItem.noticelist, R.layout.item_fragment_tab1_notice_layout);
        addItemType(MultipleTabHomeItem.seckills, R.layout.item_fragment_tab1_seckills_layout);
        addItemType(MultipleTabHomeItem.ads, R.layout.item_fragment_tab1_ads_layout);
        addItemType(MultipleTabHomeItem.stores, R.layout.item_fragment_tab1_stores_layout);
        addItemType(MultipleTabHomeItem.newgoods, R.layout.item_fragment_tab1_newgoods_layout);
    }


    class MyHolder extends BaseViewHolder {
        XBanner mBanner;
        RecyclerView recyclerView_nav, recyclerView_stores, recyclerView_newgoods;
        ImageView imageView_topic, imageView_ads1, imageView_ads2, imageView_ads3, imageView_ads4, imageView_seckils1, imageView_seckils2, imageView_seckils3;
        AutoVerticalViewView autoVerticalViewView_notice;
        LinearLayout linearLayout_seckils1, linearLayout_seckils2, linearLayout_seckils3;
        TextView textView_seckils_query_all;

        public MyHolder(View view) {
            super(view);
            mBanner = view.findViewById(R.id.item_fragment_tab1_banners_layout_banner);
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ScreenUtilsx.getScreenWidthx(mContext) / 2);
//            mBanner.setLayoutParams(layoutParams);
            recyclerView_nav = view.findViewById(R.id.item_fragment_tab1_navs_layout_recyclerview);
            imageView_topic = view.findViewById(R.id.item_fragment_tab1_topic_layout_img);
            autoVerticalViewView_notice = view.findViewById(R.id.item_fragment_tab1_notice_layout_sview);
            imageView_ads1 = view.findViewById(R.id.item_fragment_tab1_ads_layout_img1);
            imageView_ads2 = view.findViewById(R.id.item_fragment_tab1_ads_layout_img2);
            imageView_ads3 = view.findViewById(R.id.item_fragment_tab1_ads_layout_img3);
            imageView_ads4 = view.findViewById(R.id.item_fragment_tab1_ads_layout_img4);
            recyclerView_stores = view.findViewById(R.id.item_fragment_tab1_stores_layout_recyclerview);
            recyclerView_newgoods = view.findViewById(R.id.item_fragment_tab1_newgoods_layout_recyclerview);
            imageView_seckils1 = view.findViewById(R.id.item_fragment_tab1_seckills_layout_img1);
            imageView_seckils2 = view.findViewById(R.id.item_fragment_tab1_seckills_layout_img2);
            imageView_seckils3 = view.findViewById(R.id.item_fragment_tab1_seckills_layout_img3);
            linearLayout_seckils1 = view.findViewById(R.id.item_fragment_tab1_seckills_layout_group1);
            linearLayout_seckils2 = view.findViewById(R.id.item_fragment_tab1_seckills_layout_group2);
            linearLayout_seckils3 = view.findViewById(R.id.item_fragment_tab1_seckills_layout_group3);
            textView_seckils_query_all = view.findViewById(R.id.item_fragment_tab1_seckills_layout_query_all);
        }
    }
}