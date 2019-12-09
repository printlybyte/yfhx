package com.yinfeng.yfhx.ui.wheight.dialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.dialogFragment.BaseDialogFragment;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.details.SelectedAttrAdapter;
import com.yinfeng.yfhx.entity.CommodityDetailsActivityBean;
import com.yinfeng.yfhx.entity.CommonExternalBean;
import com.yinfeng.yfhx.entity.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.t3.ShopCarCartValueBean;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * ============================================
 * 描  述：购物车详情=已选规格
 * 包  名：com.lgd.lgd_core.ui.dialogFragment
 * 类  名：ADBottomDialog
 * 创建人：liuguodong
 * 创建时间：2019/10/12 16:11
 * ============================================
 **/
@SuppressLint("ValidFragment")
public class BottomSelectedSpecificationDialog extends BaseDialogFragment implements View.OnClickListener {
    private ImageView mDfBottomSelectedSpecificationImg;

    private TextView mDfBottomSelectedSpecificationPrice;

    private List<CommodityDetailsActivityBean.DataBean.AttrBean> mList;
    private RecyclerView mIncludeRecyclerview;
    private SelectedAttrAdapter selectedAttrAdapter;
    private View view;
    /**
     * 立即购买
     */
    private TextView mDfBottomSelectedSpecificationBuy;
    /**
     * 加入购物车
     */
    private TextView mDfBottomSelectedSpecificationAdd;
    private ImageView mDfBottomSelectedSpecificationDismis;
    /**
     * 请选择尺码  颜色款式
     */
    private TextView mDfBottomSelectedSpecificationTitle;

    private String mGood_id;
    CommodityDetailsActivityBean bean;

    public BottomSelectedSpecificationDialog(CommodityDetailsActivityBean beanx) {
        mList = beanx.getData().getAttr();
        mGood_id = beanx.getData().getGoods_id() + "";
        bean = beanx;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.df_bottom_selected_specification;
    }

    @Override
    protected int getContentGravity() {
        return Gravity.BOTTOM;
    }

    @Override
    protected void initView(View view) {
        mDfBottomSelectedSpecificationImg = (ImageView) view.findViewById(R.id.df_bottom_selected_specification_img);
        mDfBottomSelectedSpecificationPrice = (TextView) view.findViewById(R.id.df_bottom_selected_specification_price);
        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_recyclerview);
        mDfBottomSelectedSpecificationBuy = (TextView) view.findViewById(R.id.df_bottom_selected_specification_buy);
        mDfBottomSelectedSpecificationAdd = (TextView) view.findViewById(R.id.df_bottom_selected_specification_add);
        mDfBottomSelectedSpecificationDismis = (ImageView) view.findViewById(R.id.df_bottom_selected_specification_dismis);
        mDfBottomSelectedSpecificationDismis.setOnClickListener(this);
        mDfBottomSelectedSpecificationTitle = (TextView) view.findViewById(R.id.df_bottom_selected_specification_title);


        setAdapter();
    }

    private void setAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(layoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //消除嵌套卡顿
        mIncludeRecyclerview.setNestedScrollingEnabled(false);
        selectedAttrAdapter = new SelectedAttrAdapter(mGood_id, getActivity(), R.layout.tab_selected_guige_item, mList, mDfBottomSelectedSpecificationTitle
                , mDfBottomSelectedSpecificationBuy, mDfBottomSelectedSpecificationAdd);
        selectedAttrAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(selectedAttrAdapter);
        selectedAttrAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {

                }
            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;

            case R.id.df_bottom_selected_specification_dismis:
                this.dismiss();
                break;
        }
    }


}
