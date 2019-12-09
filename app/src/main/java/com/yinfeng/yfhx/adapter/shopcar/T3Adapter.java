package com.yinfeng.yfhx.adapter.shopcar;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.counterview.CounterListener;
import com.lgd.lgd_core.ui.counterview.IncDecView;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.t3.T3_Section;
import com.yinfeng.yfhx.entity.t3.T3_ContentsBean;
import com.yinfeng.yfhx.ui.utils.ShopCarUtils;

import java.util.List;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.adapter.categray
 * 类  名：ChildAdapter
 * 创建人：liuguodong
 * 创建时间：2019/10/8 11:01
 * ============================================
 **/
//public class T3Adapter extends BaseMultiItemQuickAdapter<MultipleTab3ChildItem, T3Adapter.MyHolder> {
public class T3Adapter extends BaseSectionQuickAdapter<T3_Section, T3Adapter.MyHolder> {

    public T3Adapter(int layoutResId, int sectionHeadResId, List data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(MyHolder helper, final T3_Section item) {
        helper.setText(R.id.item_fragment_tab3_header_layout_title, item.header);
        helper.addOnClickListener(R.id.item_fragment_tab3_header_layout_checkbox);
        helper.addOnClickListener(R.id.item_fragment_tab3_header_layout_title);
        if (item.isChecked()) {
            helper.checkBox_header.setChecked(true);
        } else {
            helper.checkBox_header.setChecked(false);
        }


//        helper.checkBox_header.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                ToastUS.Warning(b+"");
//            }
//        });

    }


    @Override
    protected void convert(MyHolder helper, T3_Section itemx) {
        T3_ContentsBean item = (T3_ContentsBean) itemx.t;
        GlideUS.loadPhoto(item.getGoods_thumb(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_shapcar_child_child_item_txt, item.getGoods_name() == "" ? tipStr : item.getGoods_name());
        helper.setText(R.id.ri_shapcar_child_child_item_sku, item.getGoods_attr() == "" ? "" : item.getGoods_attr());

        helper.setText(R.id.tvPriceProduct, item.getGoods_price_format() == "" ? "" : item.getGoods_price_format());
        if (item.isIs_checked()) {
            helper.checkBox.setChecked(true);
        } else {
            helper.checkBox.setChecked(false);
        }
        helper.addOnClickListener(R.id.item_fragment_tab3_content_layout_group);
        helper.addOnClickListener(R.id.item_fragment_tab3_content_layout_del);
        helper.addOnClickListener(R.id.item_fragment_tab3_content_layout_checkbox);
        helper.incDecView.setStartCounterValue(item.getGoods_number() + "");
        helper.incDecView.setCounterListener(new CounterListener() {
            @Override
            public void onIncClick(String value) {
                ShopCarUtils.getInstance().cart_update(item.getRec_id() + "", value);
            }

            @Override
            public void onDecClick(String value) {
                ShopCarUtils.getInstance().cart_update(item.getRec_id() + "", value);
            }
        });
    }
    class MyHolder extends BaseViewHolder {
        ImageView imageView;
        IncDecView incDecView;
        CheckBox checkBox;
        CheckBox checkBox_header;

        public MyHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.ri_shapcar_child_child_item_img);
            incDecView = view.findViewById(R.id.ri_shapcar_child_child_item_counter);
            checkBox = view.findViewById(R.id.item_fragment_tab3_content_layout_checkbox);
            checkBox_header = view.findViewById(R.id.item_fragment_tab3_header_layout_checkbox);
        }
    }




}
