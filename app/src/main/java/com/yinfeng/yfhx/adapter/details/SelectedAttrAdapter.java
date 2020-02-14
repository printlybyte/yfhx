package com.yinfeng.yfhx.adapter.details;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.CommonUtils;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.orhanobut.hawk.Hawk;
import com.yinfeng.yfhx.Apc;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.Trade_change_bean;
import com.yinfeng.yfhx.entity.common.CommodityDetailsActivityBean;
import com.yinfeng.yfhx.ui.utils.CouponUtils;
import com.yinfeng.yfhx.ui.utils.ShopCarUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ============================================
 * 描  述：商品规格选择
 * 包  名：com.yinfeng.yfhx.fragments.adapter
 * 类  名：NavAdapter
 * 创建人：liuguodong
 * 创建时间：2019/9/24 17:42
 * ============================================
 **/
public class SelectedAttrAdapter extends BaseQuickAdapter<CommodityDetailsActivityBean.DataBean.AttrBean, SelectedAttrAdapter.MyHolder> {

    private Context mContext;
    private TextView mName_textView;
    private TextView mBuy_textView;
    private TextView mAdd_textView;
    private String mGood_id;

    public SelectedAttrAdapter(String goods_id, Context context, int layoutResId, List data, TextView textView, TextView t_buy, TextView t_add) {
        super(layoutResId, data);
        mContext = context;
        mName_textView = textView;
        mBuy_textView = t_buy;
        mAdd_textView = t_add;
        mGood_id = goods_id;
        mBuy_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.size() != mMap_sel_id.size()) {
                    ToastUS.Warning("请选择与商品相对应的规格属性");
                    return;
                }
                ToastUS.Success("立即购买");
                ShopCarUtils.getInstance().add(mGood_id, CommonUtils.getMapValueToJsonArray(mMap_sel_id), true,true);
            }
        });
        mAdd_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.size() != mMap_sel_id.size()) {
                    ToastUS.Warning("请选择与商品相对应的规格属性");
                    return;
                }
                ShopCarUtils.getInstance().add(mGood_id, CommonUtils.getMapValueToJsonArray(mMap_sel_id), true,false);
            }
        });
    }


    @Override
    protected void convert(@NonNull MyHolder helper, CommodityDetailsActivityBean.DataBean.AttrBean item) {
//        GlideUS.loadPhoto(item.getPic(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.tab_selected_guige_item_attr_name, item.getAttr_name() == "" ? tipStr : item.getAttr_name());
        setTagDate(helper, item.getAttr_key());
    }


    Map<String, String> mMap_sel_title = new LinkedHashMap<>();
    Map<String, String> mMap_sel_id = new LinkedHashMap<>();

    public void setTagDate(MyHolder helper, List<CommodityDetailsActivityBean.DataBean.AttrBean.AttrKeyBean> mAttrBeanList) {
        List<String> mList_c = new ArrayList<>();
        List<String> mList_id = new ArrayList<>();
        List<String> mList_name = new ArrayList<>();
        for (int i = 0; i < mAttrBeanList.size(); i++) {
            if (i==0){
                cardListener.OnReceiveChangeCard(1,mAttrBeanList.get(i).getGoods_attr_id() + "" );
            }
            mList_c.add(mAttrBeanList.get(i).getAttr_value());
            mList_id.add(mAttrBeanList.get(i).getGoods_attr_id() + "");
            mList_name.add(mAttrBeanList.get(i).getAttr_name() + "");
        }
        String[] strings = new String[mList_c.size()];
        TagAdapter<String> tagAdapter = new TagAdapter<String>(mList_c.toArray(strings)) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.tag_selected_specification_layout, helper.tagFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
//        tagAdapter.setSelectedList(0);
        helper.tagFlowLayout.setAdapter(tagAdapter);
        helper.tagFlowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                if (selectPosSet.toString().length() == 3) {
                    String as = selectPosSet.toString().substring(1, 2);
                    String sel_id = mList_id.get(Integer.parseInt(as));
                    String sel_content = mList_c.get(Integer.parseInt(as));
                    mMap_sel_title.put(helper.getAdapterPosition() + "", sel_content);
                    mMap_sel_id.put(helper.getAdapterPosition() + "", sel_id);

                    String mapValue = CommonUtils.getMapValue(mMap_sel_title);
                    mName_textView.setText("已选 " + mapValue);

                    Hawk.put(Apc.Apc_car_sel_attr_id, mapValue);
                    cardListener.OnReceiveChangeCard(1,sel_id+"");
                } else {
                    mMap_sel_title.remove(helper.getAdapterPosition() + "");
                    mMap_sel_id.remove(helper.getAdapterPosition() + "");
                    String mapValue = CommonUtils.getMapValue(mMap_sel_title);
                    mName_textView.setText("已选 " + mapValue);
                    Hawk.put(Apc.Apc_car_sel_attr_id, mapValue);

                }
            }
        });

    }

    class MyHolder extends BaseViewHolder {
        TagFlowLayout tagFlowLayout;

        public MyHolder(View view) {
            super(view);
            tagFlowLayout = view.findViewById(R.id.tab_selected_guige_item_sizeTag);
        }
    }

    public interface OnReceiveChangeCardListener {
        void OnReceiveChangeCard(int status, String attr_id);
    }

    public void setOnChangeCardListener( OnReceiveChangeCardListener dialogListener) {
        this.cardListener = dialogListener;
    }

    private static  OnReceiveChangeCardListener cardListener;
}
