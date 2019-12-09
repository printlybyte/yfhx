package com.yinfeng.yfhx.adapter.me;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.MeAddressActivityBean;
import com.yinfeng.yfhx.entity.MeInvoiceActivityBean;

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

public class MeAddressAdapter extends BaseQuickAdapter<MeAddressActivityBean.DataBean, MeAddressAdapter.MyHolder> {
    private boolean isShowSingleCheck = false;

    public MeAddressAdapter(int layoutResId, List data, boolean isShowSingleCheckb) {
        super(layoutResId, data);
        isShowSingleCheck = isShowSingleCheckb;
    }

    @Override
    protected void convert(@NonNull MeAddressAdapter.MyHolder helper, MeAddressActivityBean.DataBean item) {

//        GlideUS.loadPhoto(item.getPic(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_me_meaddress_item_name, item.getName() == "" ? tipStr : item.getName());
//        helper.setText(R.id.ri_me_meinvoice_type, item.getAdd_time() == "" ? tipStr : item.getTitle());
        helper.setText(R.id.ri_me_meaddress_item_details, item.getAddress() == "" ? tipStr : item.getAddress());
        helper.addOnClickListener(R.id.ri_me_meaddress_item_checkbox);
        helper.addOnClickListener(R.id.ri_me_meaddress_item_selected_cb);
        helper.addOnClickListener(R.id.ri_me_meaddress_item_delete);
        if (item.getIs_checked()==1) {
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
            helper.setGone(R.id.ri_me_meaddress_item_selected_cb, true);
        }else {
            helper.setGone(R.id.ri_me_meaddress_item_selected_cb, false);
        }
    }

    class MyHolder extends BaseViewHolder {
        private CheckBox checkBox;
        private CheckBox checkBox_single;

        public MyHolder(View view) {
            super(view);
            checkBox = view.findViewById(R.id.ri_me_meaddress_item_checkbox);
            checkBox_single = view.findViewById(R.id.ri_me_meaddress_item_selected_cb);
        }
    }
}
