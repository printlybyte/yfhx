package com.yinfeng.yfhx.adapter.categray;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.IntentUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.ITTUtils;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.TabFragment2Bean_Child;
import com.yinfeng.yfhx.ui.details.CommodityListActivity;

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
public class ChildAdapter extends BaseMultiItemQuickAdapter<MultipleTab2ChildItem, ChildAdapter.MyHolder> {

    public ChildAdapter(List data, Context context) {
        super(data);
        mContext = context;
        addItemType(MultipleTab2ChildItem.header, R.layout.item_fragment_tab2_header_layout);
        addItemType(MultipleTab2ChildItem.contents, R.layout.item_fragment_tab2_contents_layout);
    }

    @Override
    protected void convert(ChildAdapter.MyHolder helper, MultipleTab2ChildItem item) {
        switch (helper.getItemViewType()) {
            case MultipleTab2ChildItem.header:
                List<String> mListNameDate = item.getBean();
                setNameDate(helper, mListNameDate);
                break;
            case MultipleTab2ChildItem.contents:
                List<TabFragment2Bean_Child.DataBean.ChildBean> mListContents = item.getBean();
                setContentDate(helper, mListContents);
                break;
        }

    }


    private void setNameDate(ChildAdapter.MyHolder helper, List<String> mList) {
        if (mList != null && mList.size() > 0) {
            for (int i = 0; i < mList.size(); i++) {
                String cat_name = mList.get(0);
                String tipStr = "暂无数据";
                helper.setText(R.id.item_fragment_tab2_header_layout_title, cat_name == "" ? tipStr : cat_name);
            }
        }

    }

    private void setContentDate(ChildAdapter.MyHolder helper, List<TabFragment2Bean_Child.DataBean.ChildBean> mList) {
        if (mList != null && mList.size() > 0) {
            Child_Child_Adapter child_child_adapter = new Child_Child_Adapter(R.layout.ri_category_child_child_item, mList);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(Latte.getApplicationContext(), 3) {
                @Override
                public boolean canScrollVertically() {
                    //禁止滑动
                    return false;
                }
            };
            helper.recyclerView_contents.setLayoutManager(gridLayoutManager);
            helper.recyclerView_contents.setAdapter(child_child_adapter);
            child_child_adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                    ToastUS.Warning("" + child_child_adapter.getData().get(position).getCat_name());

                    ITTUtils.Jump(CommodityListActivity.class, "" + child_child_adapter.getData().get(position).getCat_id());
                }
            });
        }
    }


    class MyHolder extends BaseViewHolder {
        private RecyclerView recyclerView_contents;

        public MyHolder(View view) {
            super(view);
            recyclerView_contents = view.findViewById(R.id.item_fragment_tab2_contents_layout_recyclerview);
        }
    }
}
