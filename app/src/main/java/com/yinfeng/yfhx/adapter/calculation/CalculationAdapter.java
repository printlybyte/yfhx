package com.yinfeng.yfhx.adapter.calculation;

import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.CalculationActivityBean;
import com.yinfeng.yfhx.ui.details.CommodityDetailsActivity;
import com.yinfeng.yfhx.ui.shop.ShopActivity;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.adapter.me
 * 类  名：MeInvoiceAdapter
 * 创建人：liuguodong
 * 创建时间：2019/10/12 10:54
 * ============================================
 **/

public class CalculationAdapter extends BaseQuickAdapter<CalculationActivityBean.DataBean.GoodsListBean, CalculationAdapter.MyHolder> {

    public CalculationAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull CalculationAdapter.MyHolder helper, CalculationActivityBean.DataBean.GoodsListBean item) {

        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_calculation_item_shop_name, item.getShop_name() == "" ? tipStr : item.getShop_name());
        helper.setText(R.id.ri_calculation_item_total_nums, item.getGoods()+"" == "" ? tipStr : "共"+item.getGoods().size()+"件商品，合计： ");
        helper.setText(R.id.ri_calculation_item_total_price, item.getAmount()+"" == "" ? tipStr :  item.getAmount()+"");

        helper.addOnClickListener(R.id.ri_calculation_item_shop_name);

        CalculationChildAdapter calculationChildAdapter = new CalculationChildAdapter(R.layout.ri_calculation_child_item, item.getGoods());
        helper.recyclerView.setAdapter(calculationChildAdapter);
        calculationChildAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.ri_calculation_child_item_group:
                        String mGoods_id= calculationChildAdapter.getData().get(position).getGoods_id()+"";
                        ITTUtils.Jump(CommodityDetailsActivity.class, mGoods_id);
                        break;

                }
            }
        });



    }

    class MyHolder extends BaseViewHolder {
        RecyclerView recyclerView;

        public MyHolder(View view) {
            super(view);
            recyclerView = view.findViewById(R.id.ri_calculation_item_recyclerview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
    }
}
