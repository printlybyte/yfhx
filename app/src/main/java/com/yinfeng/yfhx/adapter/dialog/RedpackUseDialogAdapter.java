package com.yinfeng.yfhx.adapter.dialog;

import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.CalculationActivityBean;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.fragments.adapter
 * 类  名：NavAdapter
 * 创建人：liuguodong
 * 创建时间：2019/9/24 17:42
 * ============================================
 **/
public class RedpackUseDialogAdapter extends BaseQuickAdapter<CalculationActivityBean.DataBean.ValueCardBean, RedpackUseDialogAdapter.MyHolder> {

    public RedpackUseDialogAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull MyHolder helper, CalculationActivityBean.DataBean.ValueCardBean item) {

//        GlideUS.loadPhoto(item.getPic(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        if (item.getTid() == 1) {
            helper.setText(R.id.df_bottom_redcard_use_item_cou_moeny, item.getCard_money() == "" ? tipStr : item.getCard_money());
            helper.setText(R.id.df_redcard_use_dialog_item_cou_name, item.getName() + "" == "" ? tipStr : item.getName() + "");
            helper.setText(R.id.df_bottom_redcard_use_item_cou_time, item.getEnd_time() + "" == "" ? "过期时间：" + tipStr : item.getEnd_time());

            helper.setGone(R.id.df_bottom_redpack_use_item_group, false);
        } else {  //===2 红包
            helper.setGone(R.id.df_bottom_redcard_use_item_group, false);

            helper.setText(R.id.df_bottom_redpack_use_item_cou_moeny, item.getCard_money() == "" ? tipStr : item.getCard_money());
            helper.setText(R.id.df_redcard_use_dialog_item_cou_name, item.getName() + "" == "" ? tipStr : item.getName() + "");
            helper.setText(R.id.df_bottom_redpack_use_item_cou_time, item.getEnd_time() + "" == "" ? "过期时间：" + tipStr : item.getEnd_time());
        }

        helper.addOnClickListener(R.id.df_bottom_redpack_use_item_btn);
        helper.addOnClickListener(R.id.df_bottom_redcard_use_item_btn);


    }

    class MyHolder extends BaseViewHolder {
        public MyHolder(View view) {
            super(view);
        }
    }


}
