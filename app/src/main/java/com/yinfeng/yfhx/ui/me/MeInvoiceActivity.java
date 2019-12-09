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
import com.yinfeng.yfhx.adapter.me.MeInvoiceAdapter;
import com.yinfeng.yfhx.entity.CommonExternalBean;
import com.yinfeng.yfhx.entity.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.CommonStatusSuccessBean;
import com.yinfeng.yfhx.entity.MeInvoiceActivityBean;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * ============================================
 * 描  述：我的发票
 * 包  名：com.yinfeng.yfhx.ui.me
 * 类  名：MeInvoiceActivity
 * 创建人：liuguodong
 * 创建时间：2019/10/12 10:48
 * ============================================
 **/
public class MeInvoiceActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView mIncludeRecyclerview;
    private SmartRefreshLayout mRefreshLayout;
    private MultipleStatusView mMultipleStatusView;
    private LinearLayout mActivityMeInvoiceAdd;


    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_me_invoice;
    }

    boolean isShowSingleCheck = false;


    private String Inv_type;
    private String Company_name;
    private String Tax_id;
    private String Inv_id;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String flags = intent.getStringExtra(IntentUtilsConstant.INTENT_PARAMS_1);
        if (flags.equals("calculation")) {
            isShowSingleCheck = true;
            //结算页发票信息选择
            mTitletBtn.setText("确认");
            mTitletBtn.setVisibility(View.VISIBLE);
            mTitletBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent1 = new Intent();
                    intent1.putExtra("Inv_type", Inv_type);
                    intent1.putExtra("Company_name", Company_name);
                    intent1.putExtra("Inv_id", Inv_id);
                    intent1.putExtra("Tax_id", Tax_id);

                    setResult(686, intent1);
                    finish();


                }
            });

        }


        mIncludeRecyclerview = (RecyclerView) findViewById(R.id.include_multiple_recyclerview);
        mRefreshLayout = (SmartRefreshLayout) findViewById(R.id.include_multiple_refreshLayout);
        mMultipleStatusView = (MultipleStatusView) findViewById(R.id.include_multiple_status_view);
        mRefreshLayout.setOnRefreshListener(onRefreshListener);
        mMultipleStatusView.setOnRetryClickListener(mRetryClickListener);
        mRefreshLayout.autoRefresh();
        mActivityMeInvoiceAdd = (LinearLayout) findViewById(R.id.activity_me_invoice_add);
        mActivityMeInvoiceAdd.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        setTitle("我的发票");
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
                .setNetUrl(Api.invoice_list_get)
                .showLoading()
                .get()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        MeInvoiceActivityBean bean = GsonUS.getIns().getGosn(response, MeInvoiceActivityBean.class);
                        if (bean != null && bean.getData().size() > 0) {
                            setAdapter(bean);
                            mMultipleStatusView.showContent();

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

    private void setAdapter(MeInvoiceActivityBean bean) {

        for (int i = 0; i < bean.getData().size(); i++) {
            MeInvoiceActivityBean.DataBean dataBean = bean.getData().get(i);
            if (i == 0) {
                dataBean.setSeletced(true);
                dataBean.setSelected_single(false);


            } else {
                dataBean.setSeletced(false);
                dataBean.setSelected_single(false);

            }
        }


        MeInvoiceAdapter meInvoiceAdapter = new MeInvoiceAdapter(R.layout.ri_me_meinvoice_item, bean.getData(), isShowSingleCheck);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Latte.getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mIncludeRecyclerview.setLayoutManager(linearLayoutManager);
        mIncludeRecyclerview.setItemAnimator(new DefaultItemAnimator());
        mIncludeRecyclerview.setAdapter(meInvoiceAdapter);
        meInvoiceAdapter.openLoadAnimation();
        meInvoiceAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                List<MeInvoiceActivityBean.DataBean> datas = adapter.getData();
                MeInvoiceActivityBean.DataBean bean = (MeInvoiceActivityBean.DataBean) adapter.getData().get(position);
                switch (view.getId()) {
                    case R.id.ri_me_meinvoice_item_checkbox:
                        for (MeInvoiceActivityBean.DataBean data : datas) {
                            data.setSeletced(false);
                        }
                        bean.setSeletced(true);
                        meInvoiceAdapter.notifyDataSetChanged();
                        break;
                    case R.id.ri_me_meinvoice_item_checkbox_selected:

                        for (MeInvoiceActivityBean.DataBean data : datas) {
                            data.setSelected_single(false);
                        }
                        bean.setSelected_single(true);
                        meInvoiceAdapter.notifyDataSetChanged();


                        Inv_type = meInvoiceAdapter.getData().get(position).getInv_type() + "";
                        Company_name = meInvoiceAdapter.getData().get(position).getCompany_name();
                        Tax_id = meInvoiceAdapter.getData().get(position).getTax_id();
                        Inv_id = meInvoiceAdapter.getData().get(position).getId()+"";


                        break;
                    case R.id.ri_me_meinvoice_item_delete:
                        MessageDialog.show(mContext, "提示", "是否删除当前发票？", "是", "否", "")
                                .setButtonOrientation(LinearLayout.VERTICAL).setOnOkButtonClickListener(new OnDialogButtonClickListener() {
                            @Override
                            public boolean onClick(BaseDialog baseDialog, View v) {
                                requestDateDel(meInvoiceAdapter.getData().get(position).getId() + "", position, meInvoiceAdapter);
                                return false;
                            }
                        });
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
            case R.id.activity_me_invoice_add:
                ActivityUtils.startActivity(AddMeInvoiceActivity.class);
                break;
        }
    }


    private void requestDateDel(String id, int pos, MeInvoiceAdapter meInvoiceAdapter) {
        LinkedHashMap<String, String> mParamsMapx = new LinkedHashMap<>();
        mParamsMapx.put("id", id);
        new OKBuilder(this)
                .setNetUrl(Api.invoice_store_post)
                .setParamsMap(mParamsMapx)
                .showLoading("删除中...")
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {

                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("data")) {
                            CommonStatusSuccessBean bean_s = GsonUS.getIns().getGosn(response, CommonStatusSuccessBean.class);
                            if (beanx != null && bean_s.getData().getCode() == Api.NET_success) {
                                meInvoiceAdapter.remove(pos);
                                ToastUS.Success(bean_s.getData().getMessage());
                            } else {
                                ToastUS.Error(bean_s.getData().getMessage());
                            }
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
