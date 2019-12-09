package com.yinfeng.yfhx.adapter.me;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.MeInvoiceActivityBean;
import com.yinfeng.yfhx.entity.TabFragment1Bean;

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

public class MeInvoiceAdapter extends BaseQuickAdapter<MeInvoiceActivityBean.DataBean, MeInvoiceAdapter.MyHolder> {

    private boolean isShowSingleCheck = false;

    public MeInvoiceAdapter(int layoutResId, List data, boolean isShowSingleCheckb) {
        super(layoutResId, data);
        isShowSingleCheck = isShowSingleCheckb;
    }


    @Override
    protected void convert(@NonNull MeInvoiceAdapter.MyHolder helper, MeInvoiceActivityBean.DataBean item) {

//        GlideUS.loadPhoto(item.getPic(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_me_meinvoice_tax_number, item.getTax_id() == "" ? tipStr : item.getTax_id());
//        helper.setText(R.id.ri_me_meinvoice_type, item.getAdd_time() == "" ? tipStr : item.getTitle());
        helper.setText(R.id.ri_me_meinvoice_company_name, item.getCompany_name() == "" ? tipStr : item.getCompany_name());
        helper.addOnClickListener(R.id.ri_me_meinvoice_item_checkbox);
        helper.addOnClickListener(R.id.ri_me_meinvoice_item_checkbox_selected);
        helper.addOnClickListener(R.id.ri_me_meinvoice_item_delete);
        if (item.isSeletced()) {
            helper.checkBox.setChecked(true);
        } else {
            helper.checkBox.setChecked(false);
        }


        if (item.isSelected_single()) {
            helper.checkBox_single.setChecked(true);
        } else {
            helper.checkBox_single.setChecked(false);
        }

        if (isShowSingleCheck) {
            helper.setGone(R.id.ri_me_meinvoice_item_checkbox_selected, true);
        }else {
            helper.setGone(R.id.ri_me_meinvoice_item_checkbox_selected, false);
        }

    }

    class MyHolder extends BaseViewHolder {
        private CheckBox checkBox ,checkBox_single;

        public MyHolder(View view) {
            super(view);
            checkBox = view.findViewById(R.id.ri_me_meinvoice_item_checkbox);
            checkBox_single = view.findViewById(R.id.ri_me_meinvoice_item_checkbox_selected);
        }
    }
}
