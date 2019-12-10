package com.yinfeng.yfhx.ui.me;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ActivityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.classic.common.MultipleStatusView;
import com.kongzue.dialog.interfaces.OnDialogButtonClickListener;
import com.kongzue.dialog.util.BaseDialog;
import com.kongzue.dialog.v3.MessageDialog;
import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.IntentUtilsConstant;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.adapter.me.MeAddressAdapter;
import com.yinfeng.yfhx.entity.CommonAddAddressStatusBean;
import com.yinfeng.yfhx.entity.CommonExternalBean;
import com.yinfeng.yfhx.entity.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.CommonStatusSuccessBean;
import com.yinfeng.yfhx.entity.MeAddressActivityBean;
import com.yinfeng.yfhx.entity.MeInvoiceActivityBean;
import com.yinfeng.yfhx.entity.details.FragmentEvaluation_AllBean;

import java.util.LinkedHashMap;
import java.util.List;

public class MeAddressActivity extends BaseActivity {

    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;
    private LinearLayout mActivityMeAddressAdd;
    boolean isShowSingleCheck = false;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_me_address;
    }

    @Override
    protected void initView() {
        mIncludeRecyclerview = (RecyclerView) findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) findViewById(R.id.include_multiple_status_view);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);

        mActivityMeAddressAdd = (LinearLayout) findViewById(R.id.activity_me_address_add);
        mActivityMeAddressAdd.setOnClickListener(this);


        Intent intent = getIntent();
        String flags = intent.getStringExtra(IntentUtilsConstant.INTENT_PARAMS_1);
        if (!TextUtils.isEmpty(flags)) {
            if (flags.equals("address")) {
                isShowSingleCheck = false;
                //结算页发票信息选择
                mTitletBtn.setText("确认");
                mTitletBtn.setVisibility(View.VISIBLE);
                mTitletBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

//                    Intent intent1 = new Intent();
//                    intent1.putExtra("Inv_type", Inv_type);
//                    intent1.putExtra("Company_name", Company_name);
//                    intent1.putExtra("Inv_id", Inv_id);
//                    intent1.putExtra("Tax_id", Tax_id);
                        setResult(786);
                        finish();
                    }
                });

            }
        }

    }

    @Override
    protected void initData() {
        setTitle("地址管理");
    }

    OnRefreshListener onRefreshListener = new OnRefreshListener() {
        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            requestDate();
            mRefreshLayout.finishRefresh(1000);
        }
    };


    final View.OnClickListener mRetryClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mMultipleStatusView.showLoading();
            mRefreshLayout.autoRefresh();
        }
    };

    private void requestDate() {
        new OKBuilder(this)
                .setNetUrl(Api.address_list)
                .get()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        MeAddressActivityBean bean = GsonUS.getIns().getGosn(response, MeAddressActivityBean.class);
                        if (bean != null && bean.getData().size() > 0) {
                            setAdapter(bean);

                        } else {
                            mMultipleStatusView.showEmpty();
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                        mMultipleStatusView.showError();
                    }
                });
    }

    private void setAdapter(MeAddressActivityBean bean) {
        for (int i = 0; i < bean.getData().size(); i++) {
            MeAddressActivityBean.DataBean dataBean = bean.getData().get(i);
            if (i == 0) {
                dataBean.setSelected_single(false);
            } else {
                dataBean.setSelected_single(false);
            }
        }

        MeAddressAdapter meAddressAdapter = new MeAddressAdapter(R.layout.ri_me_meaddress_item, bean.getData(), isShowSingleCheck);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(linearLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mIncludeRecyclerview.setAdapter(meAddressAdapter);
        meAddressAdapter.openLoadAnimation();
        meAddressAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                MeAddressActivityBean.DataBean bean = (MeAddressActivityBean.DataBean) adapter.getData().get(position);
                List<MeAddressActivityBean.DataBean> datas = adapter.getData();
                switch (view.getId()) {
                    case R.id.ri_me_meaddress_item_checkbox:
//                        for (MeAddressActivityBean.DataBean data : datas) {
////                            data.setSeletced(false);
////                        }
////                        bean.setSeletced(true);
////                        meAddressAdapter.notifyDataSetChanged();

                        address_default_post(datas.get(position).getId() + "");
                        mRefreshLayout.autoRefresh();
                        break;

                    case R.id.ri_me_meaddress_item_delete:
                        MessageDialog.show(mContext, "提示", "是否删除当前地址？", "是", "否", "")
                                .setButtonOrientation(LinearLayout.VERTICAL).setOnOkButtonClickListener(new OnDialogButtonClickListener() {
                            @Override
                            public boolean onClick(BaseDialog baseDialog, View v) {
                                requestDateDel(meAddressAdapter.getData().get(position).getId() + "", position, meAddressAdapter);
                                return false;
                            }
                        });
                        break;


                    case R.id.ri_me_meaddress_item_selected_cb:

                        for (MeAddressActivityBean.DataBean data : datas) {
                            data.setSelected_single(false);
                        }
                        bean.setSelected_single(true);
                        meAddressAdapter.notifyDataSetChanged();


                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.activity_me_address_add:

                ActivityUtils.startActivity(AddAddressActivity.class);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRefreshLayout.autoRefresh();
    }

    private void requestDateDel(String id, int pos, MeAddressAdapter meAddressAdapter) {
        LinkedHashMap<String, String> mParamsMapx = new LinkedHashMap<>();
        mParamsMapx.put("address_id", id);
        new OKBuilder(this)
                .setNetUrl(Api.address_delete)
                .setParamsMap(mParamsMapx)
                .showLoading("删除中...")
                .deleteStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            meAddressAdapter.remove(pos);
                            ToastUS.Success("删除成功");
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


    private void address_default_post(String address_id) {
        LinkedHashMap<String, String> mParamsMapx = new LinkedHashMap<>();
        mParamsMapx.put("address_id", address_id);
        new OKBuilder(this)
                .setNetUrl(Api.address_default_post)
                .setParamsMap(mParamsMapx)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            ToastUS.Success("设置成功");
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
