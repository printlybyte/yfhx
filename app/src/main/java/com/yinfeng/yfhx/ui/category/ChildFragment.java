package com.yinfeng.yfhx.ui.category;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lgd.lgd_core.base.BaseFragment;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.LogUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.categray.ChildAdapter;
import com.yinfeng.yfhx.adapter.categray.MultipleTab2ChildItem;
import com.yinfeng.yfhx.entity.TabFragment2Bean_Child;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================
 * 描  述：首页-通用fragment
 * 包  名：com.yinfeng.yfhx.fragments.home
 * 类  名：GeneralPurposeFragment
 * 创建人：liuguodong
 * 创建时间：2019/9/20 15:39
 * ============================================
 **/
public class ChildFragment extends BaseFragment {

    private RecyclerView mIncludeRecyclerview;

    public static ChildFragment newInstance(String f_name, String f_id) {
        Bundle args = new Bundle();
        args.putString("f_name", f_name);
        args.putString("f_id", f_id);
        ChildFragment generalPurposeFragment = new ChildFragment();
        generalPurposeFragment.setArguments(args);
        return generalPurposeFragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_tab2_child_layout;
    }

    @Override
    protected void initView(View view) {
        String f_id = "";
        Bundle bundle = getArguments();
        if (bundle != null && !TextUtils.isEmpty(bundle.getString("f_name"))) {
            String f_name = bundle.getString("f_name");
            f_id = bundle.getString("f_id");
        } else {
        }

        mIncludeRecyclerview = (RecyclerView) view.findViewById(R.id.include_multiple_recyclerview);
        requestDate(f_id);
    }

    @Override
    protected void initData() {

    }


    /**
     * 请求首页数据
     */
    private void requestDate(String categray_id) {
        new OKBuilder(getActivity())
                .setNetUrl(Api.catalog_list_get + "/" + categray_id)
                .showLoading("loading...")
                .get()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        TabFragment2Bean_Child bean = GsonUS.getIns().getGosn(response, TabFragment2Bean_Child.class);
                        if (bean != null) {
                            mParserList = parserMultipleItemData(bean);
                            LogUS.I("mParserList.size: " + mParserList.size());
                            if (mParserList == null) {
                                ToastUS.Error("暂未请求到数据");
                                return;
                            }
                            setAdapter();
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }

    private ChildAdapter childAdapter;
    private List<MultipleTab2ChildItem> mParserList = null;

    private void setAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(layoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        //消除嵌套卡顿
        mIncludeRecyclerview.setNestedScrollingEnabled(false);
        childAdapter = new ChildAdapter(mParserList, getActivity());
        childAdapter.openLoadAnimation();
        mIncludeRecyclerview.setAdapter(childAdapter);
        childAdapter.setOnItemChildClickListener(onItemChildClickListener);
    }




    public List<MultipleTab2ChildItem> parserMultipleItemData(TabFragment2Bean_Child response) {
        List<MultipleTab2ChildItem> list = new ArrayList<>();

        if (response.getData() != null) {
            for (int i = 0; i < response.getData().size(); i++) {
                List<String> mList = new ArrayList<>();
                mList.add(response.getData().get(i).getCat_name());
                list.add(new MultipleTab2ChildItem(MultipleTab2ChildItem.header, MultipleTab2ChildItem.TEXT_SPAN_SIZE, mList));
                list.add(new MultipleTab2ChildItem(MultipleTab2ChildItem.contents, MultipleTab2ChildItem.TEXT_SPAN_SIZE, response.getData().get(i).getChild()));
            }
        }
        return list;
    }


    private BaseQuickAdapter.OnItemChildClickListener onItemChildClickListener = new BaseQuickAdapter.OnItemChildClickListener() {
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            switch (view.getId()) {
                default:
            }
        }
    };
}
