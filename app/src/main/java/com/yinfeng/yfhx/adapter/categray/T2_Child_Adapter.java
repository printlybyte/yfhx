package com.yinfeng.yfhx.adapter.categray;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.TabFragment2Bean_Child;

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
public class T2_Child_Adapter extends BaseQuickAdapter<TabFragment2Bean_Child.DataBean.ChildBean, T2_Child_Adapter.MyHolder> {

    public T2_Child_Adapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull T2_Child_Adapter.MyHolder helper, TabFragment2Bean_Child.DataBean.ChildBean item) {

        GlideUS.loadPhoto(item.getTouch_icon(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_category_child_child_item_txt, item.getCat_name() == "" ? tipStr : item.getCat_name());
        helper.addOnClickListener(R.id.ri_category_child_child_item_group);
    }

    class MyHolder extends BaseViewHolder {
        ImageView imageView;
        public MyHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.ri_category_child_child_item_img);
        }
    }
}
