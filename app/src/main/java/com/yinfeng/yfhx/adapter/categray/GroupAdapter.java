package com.yinfeng.yfhx.adapter.categray;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.TabFragment2Bean_Group;

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
public class GroupAdapter extends BaseQuickAdapter<TabFragment2Bean_Group.DataBean, GroupAdapter.MyHolder> {

    public GroupAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(@NonNull MyHolder helper, TabFragment2Bean_Group.DataBean item) {

//        GlideUS.loadPhoto(item.getPic(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_group_item_name, item.getCat_name() == "" ? tipStr : item.getCat_name());
        helper.addOnClickListener(R.id.ri_group_item_group);

        if (item.isSelected()) {
            helper.setBackgroundColor(R.id.ri_group_item_name, Color.parseColor("#ffffff"));
            helper.setTextColor(R.id.ri_group_item_name, Color.parseColor("#ec2587"));
        } else {
            helper.setBackgroundColor(R.id.ri_group_item_name, Color.parseColor("#fafafa"));
            helper.setTextColor(R.id.ri_group_item_name, Color.parseColor("#000000"));
        }
    }

    class MyHolder extends BaseViewHolder {
        public MyHolder(View view) {
            super(view);
        }
    }
}
