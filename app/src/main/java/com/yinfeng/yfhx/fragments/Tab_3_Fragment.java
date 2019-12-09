package com.yinfeng.yfhx.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.classic.common.MultipleStatusView;
import com.lgd.lgd_core.base.BaseFragment;
import com.lgd.lgd_core.event.ActResultRequest;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.LogUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.shopcar.T3Adapter;
import com.yinfeng.yfhx.entity.t3.ShopCarCartValueBean;
import com.yinfeng.yfhx.entity.t3.T3_ContentsBean;
import com.yinfeng.yfhx.entity.t3.T3_Section;
import com.yinfeng.yfhx.entity.t3.Tab_3_FragmentBean;
import com.yinfeng.yfhx.ui.alculation.CalculationActivity;
import com.yinfeng.yfhx.ui.details.CommodityDetailsActivity;
import com.yinfeng.yfhx.ui.shop.ShopActivity;
import com.yinfeng.yfhx.ui.utils.ShopCarUtils;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.fragments
 * 类  名：Tab_1_Fragment
 * 创建人：liuguodong
 * 创建时间：2019/9/2 16:51
 * ============================================
 **/
public class Tab_3_Fragment extends BaseFragment implements View.OnClickListener {
    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;
    /**
     * 全选
     */
    private CheckBox mIncludeShopcarCalculationCheck;
    /**
     * 应付总额
     */
    private TextView mIncludeShopcarCalculationPeice;
    /**
     * （含运费￥30.00，已节省￥150.00）
     */
    private TextView mIncludeShopcarCalculationAmont;
    /**
     * 立即付款（3）
     */
    private TextView mIncludeShopcarCalculationConfirm;

    public static Tab_3_Fragment newInstance() {
        Bundle args = new Bundle();
        Tab_3_Fragment sampleFragment = new Tab_3_Fragment();
        sampleFragment.setArguments(args);
        return sampleFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_tab_3;
    }

    @Override
    protected void initView(View view) {
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) view.findViewById(R.id.include_multiple_status_view);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);
        mRefreshLayout.autoRefresh();
        mIncludeShopcarCalculationCheck = (CheckBox) view.findViewById(R.id.include_shopcar_calculation_check);
        mIncludeShopcarCalculationPeice = (TextView) view.findViewById(R.id.include_shopcar_calculation_peice);
        mIncludeShopcarCalculationAmont = (TextView) view.findViewById(R.id.include_shopcar_calculation_amont);
        mIncludeShopcarCalculationConfirm = (TextView) view.findViewById(R.id.include_shopcar_calculation_confirm);
        mIncludeShopcarCalculationConfirm.setOnClickListener(this);
        mIncludeShopcarCalculationCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                //判断是不是点击触发的，否则当我setChecked()时会触发此listener
                if (!compoundButton.isPressed()) {
                    return;
                }

                if (b) {
                    ShopCarUtils.getInstance().check(null, "1", true);
                } else {
                    ShopCarUtils.getInstance().check(null, "0", true);
                }

                ShopCarUtils.getInstance().setOnChangeValueListener(new ShopCarUtils.OnCheckValueChangeListener() {
                    @Override
                    public void onChangeValueClick(int status, List<Integer> bean) {
                        if (status == 1) {
                            updatePrice(bean.toString());
                        } else {
                            mIncludeShopcarCalculationPeice.setText(0 + "");
                            mIncludeShopcarCalculationConfirm.setText("立即付款 ( " + 0 + " )");
                            mIncludeShopcarCalculationAmont.setText("已节省 (" + 0 + " )");
                        }
                        requestDate(0);
                    }
                });
            }
        });
    }

    @Override
    protected void initData() {

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

    /**
     * 请求首页数据
     * type==0 只更新数据
     */
    private void requestDate(int type) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("warehouse_id", "0");
        map.put("area_id", "0");
        new OKBuilder(getActivity())
                .setNetUrl(Api.cart_goodslist_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        Tab_3_FragmentBean bean = GsonUS.getIns().getGosn(response, Tab_3_FragmentBean.class);
                        if (bean != null) {
                            if (type == 0) {
                                List<T3_Section> mList = getSampleData(bean);
                                for (int i = 0; i < t3Adapter.getData().size(); i++) {
                                    if (t3Adapter.getData().get(i).getTag() == 1) {
                                        t3Adapter.getData().get(i).setChecked(mList.get(i).isChecked());
                                        t3Adapter.getData().get(i).setStore_name(mList.get(i).getStore_name());
                                        t3Adapter.getData().get(i).setStore_id(mList.get(i).getStore_id());
                                        t3Adapter.getData().get(i).setCoupuns_num(mList.get(i).getCoupuns_num());
                                        t3Adapter.getData().get(i).setUser_id(mList.get(i).getUser_id());
                                    } else {
                                        T3_Section mySection = mData.get(i);
                                        mySection.t = mList.get(i).t;
                                    }
                                }
                                t3Adapter.notifyDataSetChanged();
                            } else {
                                setAdapter(bean);
                            }
                            mIncludeShopcarCalculationConfirm.setEnabled(true);
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }


    private List<Integer> mFirstShopIds = new ArrayList<>();

    public List<T3_Section> getSampleData(Tab_3_FragmentBean response) {
        List<T3_Section> list = new ArrayList<>();
        mFirstShopIds.clear();
        for (int i = 0; i < response.getData().size(); i++) {
            T3_Section t3_section = new T3_Section(true, response.getData().get(i).getStore_name(), true);
            t3_section.setChecked(response.getData().get(i).isChecked());
            t3_section.setStore_name(response.getData().get(i).getStore_name());
            t3_section.setStore_id(response.getData().get(i).getStore_id());
            t3_section.setList(response.getData().get(i).getGoods());
            t3_section.setTag(1);
            list.add(t3_section);
            for (int i1 = 0; i1 < response.getData().get(i).getGoods().size(); i1++) {
                T3_ContentsBean bean = new T3_ContentsBean();
                Tab_3_FragmentBean.DataBean.GoodsBean goodsBean = response.getData().get(i).getGoods().get(i1);
                bean.setGoods_name(goodsBean.getGoods_name());
                mFirstShopIds.add(goodsBean.getRec_id());
                bean.setGoods_price(goodsBean.getGoods_price());
                bean.setGoods_price_format(goodsBean.getGoods_price_format());
                bean.setGoods_thumb(goodsBean.getGoods_thumb());
                bean.setGoods_number(goodsBean.getGoods_number());
                bean.setGoods_attr(goodsBean.getGoods_attr());
                bean.setGoods_attr_id(goodsBean.getGoods_attr_id());
                bean.setIs_checked(goodsBean.isIs_checked());
                bean.setRec_id(goodsBean.getRec_id());
                bean.setGoods_id(goodsBean.getGoods_id());
                bean.setMarket_price(goodsBean.getMarket_price());
                bean.setMarket_price_format(goodsBean.getMarket_price_format());
                list.add(new T3_Section(bean));
            }
        }
        return list;
    }


    private T3Adapter t3Adapter;
    private List<T3_Section> mData;


    private void setAdapter(Tab_3_FragmentBean bean) {
        mData = getSampleData(bean);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(layoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //消除嵌套卡顿
        t3Adapter = new T3Adapter(R.layout.item_fragment_tab3_content_layout, R.layout.item_fragment_tab3_header_layout, mData);

        t3Adapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(t3Adapter);

        if (mFirstShopIds != null) {
            updatePrice(mFirstShopIds.toString());
        }

        t3Adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                T3_Section mySection = mData.get(position);
                T3_ContentsBean contentsBean = mySection.t;
                JSONArray jsonArray = new JSONArray();
                switch (view.getId()) {
                    case R.id.item_fragment_tab3_content_layout_checkbox:
//                        ToastUS.Warning(position + "" + contentsBean.getGoods_name() + contentsBean.isIs_checked());
                        jsonArray.put(contentsBean.getRec_id());
                        if (contentsBean.isIs_checked()) {
                            ShopCarUtils.getInstance().check(jsonArray, "0", false);
                        } else {
                            ShopCarUtils.getInstance().check(jsonArray, "1", false);
                        }
                        ShopCarUtils.getInstance().setOnChangeValueListener(new ShopCarUtils.OnCheckValueChangeListener() {
                            @Override
                            public void onChangeValueClick(int status, List<Integer> bean) {
                                if (status == 1) {
                                    updatePrice(bean.toString());
                                } else {
                                    mIncludeShopcarCalculationPeice.setText(0 + "");
                                    mIncludeShopcarCalculationConfirm.setText("立即付款 ( " + 0 + " )");
                                    mIncludeShopcarCalculationAmont.setText("已节省 (" + 0 + " )");
                                }
                                requestDate(0);
                            }
                        });
                        break;
                    case R.id.item_fragment_tab3_header_layout_checkbox:
                        ToastUS.Warning(position + "" + mySection.isChecked());
                        List<Tab_3_FragmentBean.DataBean.GoodsBean> mList = mySection.getList();
                        for (int i = 0; i < mList.size(); i++) {
                            jsonArray.put(mList.get(i).getRec_id());
                        }
                        if (mySection.isChecked()) {
                            ShopCarUtils.getInstance().check(jsonArray, "0", false);
                        } else {
                            ShopCarUtils.getInstance().check(jsonArray, "1", false);
                        }

                        ShopCarUtils.getInstance().setOnChangeValueListener(new ShopCarUtils.OnCheckValueChangeListener() {
                            @Override
                            public void onChangeValueClick(int status, List<Integer> bean) {
                                if (status == 1) {
                                    updatePrice(bean.toString());
                                } else {
                                    mIncludeShopcarCalculationPeice.setText(0 + "");
                                    mIncludeShopcarCalculationConfirm.setText("立即付款 ( " + 0 + " )");
                                    mIncludeShopcarCalculationAmont.setText("已节省 (" + 0 + " )");
                                }
                                requestDate(0);
                            }
                        });
                        LogUS.I("=======" + mList.size());
                        break;
                    case R.id.item_fragment_tab3_header_layout_title:
//                        ToastUS.Warning(position + "" + mySection.header);

                        ITTUtils.Jump(ShopActivity.class, mySection.getStore_id() + "");

                        break;
                    case R.id.item_fragment_tab3_content_layout_del:
                        ShopCarUtils.getInstance().deleteCart(contentsBean.getRec_id() + "", position);
                        ShopCarUtils.getInstance().setOnDelListener(new ShopCarUtils.OnDelListener() {
                            @Override
                            public void onDelClick(int status, int pos) {
                                if (status == 1) {
                                    t3Adapter.remove(position);
                                    requestDate(1);
//                                    t3Adapter.notifyDataSetChanged();
                                }
                            }
                        });
                        break;
                    case R.id.item_fragment_tab3_content_layout_group:
                        ITTUtils.Jump(CommodityDetailsActivity.class, contentsBean.getGoods_id() + "");
                        break;
                }
            }
        });

    }

    private void updatePrice(String str_id) {
        ShopCarUtils.getInstance().cartValue(str_id);
        ShopCarUtils.getInstance().setOnCartValueChangeListener(new ShopCarUtils.OnCartValueChangeListener() {
            @Override
            public void OnCartValueChange(int status, ShopCarCartValueBean person) {
                if (status == 1) {
                    mIncludeShopcarCalculationPeice.setText(person.getData().getGoods_amount_formated() + "");
                    mIncludeShopcarCalculationConfirm.setText("立即付款 ( " + person.getData().getCart_number() + " )");
                    mIncludeShopcarCalculationAmont.setText("已节省 (" + person.getData().getDiscount_formated() + " )");

                    int unselected = person.getData().getUnselected();
                    if (unselected == 0) {
                        mIncludeShopcarCalculationCheck.setChecked(true);
                    } else {
                        mIncludeShopcarCalculationCheck.setChecked(false);

                    }
                } else {
                    mIncludeShopcarCalculationPeice.setText(0 + "");
                    mIncludeShopcarCalculationConfirm.setText("立即付款 ( " + 0 + " )");
                    mIncludeShopcarCalculationAmont.setText("已节省 (" + 0 + " )");
                }
            }
        });
    }

    OnRefreshListener onRefreshListener = new OnRefreshListener() {
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            requestDate(1);
            mRefreshLayout.finishRefresh(1000);
        }
    };


    final View.OnClickListener mRetryClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mMultipleStatusView.showLoading();
            mRefreshLayout.autoRefresh();
        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.include_shopcar_calculation_confirm:
                actResultRequest.startForResult(new Intent(getActivity(), CalculationActivity.class)
//                                .putExtra(FinalUtils.JUMP_INTENT_KEY, bean.getScripId() + "")
                        , new ActResultRequest.Callback() {
                            @Override
                            public void onActivityResult(int resultCode, Intent data) {
                                if (resultCode == 26) { //
//                                    if (data != null) {
                                        requestDate(0);
//                                    }
                                }
                            }
                        });

//                ActivityUtils.startActivity(CalculationActivity.class);
                break;
        }
    }


}
