package com.yinfeng.yfhx.adapter.shopcar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.counterview.CounterListener;
import com.lgd.lgd_core.ui.counterview.IncDecView;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.TAB3CounterUpdateBean;
import com.yinfeng.yfhx.entity.t3.Tab_3_FragmentBean;

import java.util.LinkedHashMap;
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
public class T3_Child_Adapter extends BaseQuickAdapter<Tab_3_FragmentBean.DataBean.GoodsBean, T3_Child_Adapter.MyHolder> {
    protected Context mContext;

    public T3_Child_Adapter(int layoutResId, List data, Context context) {
        super(layoutResId, data);
        mContext = context;
    }

    @Override
    protected void convert(@NonNull T3_Child_Adapter.MyHolder helper, Tab_3_FragmentBean.DataBean.GoodsBean item) {

        GlideUS.loadPhoto(item.getGoods_thumb(), helper.imageView);
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.ri_shapcar_child_child_item_txt, item.getGoods_name() == "" ? tipStr : item.getGoods_name());
        helper.setText(R.id.ri_shapcar_child_child_item_sku, item.getGoods_attr() == "" ? "" : item.getGoods_attr());
        if (item.isIs_checked()) {
            helper.checkBox.setChecked(true);
        } else {
            helper.checkBox.setChecked(false);
        }
        helper.addOnClickListener(R.id.ri_shapcar_child_child_item_group);
        helper.incDecView.setStartCounterValue(item.getGoods_number() + "");
        helper.incDecView.setCounterListener(new CounterListener() {
            @Override
            public void onIncClick(String value) {
                requestDate(item.getRec_id() + "", value);
            }

            @Override
            public void onDecClick(String value) {
                requestDate(item.getRec_id() + "", value);
            }
        });
    }

    class MyHolder extends BaseViewHolder {
        ImageView imageView;
        IncDecView incDecView;
        CheckBox checkBox;

        public MyHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.ri_shapcar_child_child_item_img);
            incDecView = view.findViewById(R.id.ri_shapcar_child_child_item_counter);
            checkBox = view.findViewById(R.id.item_fragment_tab3_content_layout_checkbox);
        }
    }

    private void requestDate(String rec_id, String num) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("rec_id", rec_id);
        map.put("num", num);
        new OKBuilder(mContext)
                .setNetUrl(Api.cart_update_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            TAB3CounterUpdateBean bean_s = GsonUS.getIns().getGosn(response, TAB3CounterUpdateBean.class);
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }
}
