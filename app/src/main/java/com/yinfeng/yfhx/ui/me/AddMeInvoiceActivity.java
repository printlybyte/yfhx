package com.yinfeng.yfhx.ui.me;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.LogUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.common.CommonStatusSuccessBean;
import com.yinfeng.yfhx.ui.wheight.address_dialog.AD_dialog;

import java.util.LinkedHashMap;

public class AddMeInvoiceActivity extends BaseActivity implements View.OnClickListener {


    /**
     * 增值税普票
     */
    private TextView mTvFpType;
    /**
     * 请填写单位名称
     */
    private EditText mEtDwName;
    /**
     * 请输入纳税人识别码
     */
    private EditText mEtNashuiRenCode;
    /**
     * 请输入注册地址
     */
    private EditText mEtRegistAddress;
    /**
     * 请输入注册电话
     */
    private EditText mEtRegistPhone;
    /**
     * 请输入开户银行
     */
    private EditText mEtBank;
    /**
     * 请输入银行账户
     */
    private EditText mEtBankAccount;
    /**
     * 请输入姓名
     */
    private EditText mEtName;
    /**
     * 请输入收票人手机号
     */
    private EditText mEtPhone;
    /**
     * 请选择地区
     */
    private TextView mTvChooseAddress;
    /**
     * 请输入详细地址
     */
    private EditText mEtAddress;
    /**
     * 保存
     */
    private Button mActivityAddMeInvoiceSave;
    private RelativeLayout mActivityAddMeInvoiceSlAddress;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_add_me_invoice;
    }

    @Override
    protected void initView() {
        initAddressDialog();
        mTvFpType = (TextView) findViewById(R.id.tvFpType);
        mEtDwName = (EditText) findViewById(R.id.etDwName);
        mEtNashuiRenCode = (EditText) findViewById(R.id.etNashuiRenCode);
        mEtRegistAddress = (EditText) findViewById(R.id.etRegistAddress);
        mEtRegistPhone = (EditText) findViewById(R.id.etRegistPhone);
        mEtBank = (EditText) findViewById(R.id.etBank);
        mEtBankAccount = (EditText) findViewById(R.id.etBankAccount);
        mEtName = (EditText) findViewById(R.id.etName);
        mEtPhone = (EditText) findViewById(R.id.etPhone);
        mTvChooseAddress = (TextView) findViewById(R.id.tvChooseAddress);
        mEtAddress = (EditText) findViewById(R.id.etAddress);
        mActivityAddMeInvoiceSave = (Button) findViewById(R.id.activity_add_me_invoice_save);
        mActivityAddMeInvoiceSave.setOnClickListener(this);
        mActivityAddMeInvoiceSlAddress = (RelativeLayout) findViewById(R.id.activity_add_me_invoice_sl_address);
        mActivityAddMeInvoiceSlAddress.setOnClickListener(this);
    }

    private String company_name, tax_id, company_address, company_telephone, bank_of_deposit, bank_account, consignee_name, consignee_mobile_phone, consignee_address, consignee_address_details;

    private void checkInput() {
        company_name = mEtDwName.getText().toString();
        tax_id = mEtNashuiRenCode.getText().toString();
        company_address = mEtRegistAddress.getText().toString();
        company_telephone = mEtRegistPhone.getText().toString();
        bank_of_deposit = mEtBank.getText().toString();
        bank_account = mEtBankAccount.getText().toString();
        consignee_name = mEtName.getText().toString();
        consignee_mobile_phone = mEtPhone.getText().toString();
        consignee_address = mTvChooseAddress.getText().toString();
        consignee_address = "66666";
        consignee_address_details = mEtAddress.getText().toString();

        if (TextUtils.isEmpty(company_name)) {
            ToastUS.Warning("请填写单位名称");
            return;
        }
        if (TextUtils.isEmpty(tax_id)) {
            ToastUS.Warning("请输入纳税人识别码");
            return;
        }
        if (TextUtils.isEmpty(company_address)) {
            ToastUS.Warning("请输入注册地址");
            return;
        }
        if (TextUtils.isEmpty(company_telephone)) {
            ToastUS.Warning("请输入注册电话");
            return;
        }

        if (TextUtils.isEmpty(bank_of_deposit)) {
            ToastUS.Warning("请输入开户银行");
            return;
        }
        if (TextUtils.isEmpty(bank_account)) {
            ToastUS.Warning("请输入银行账户");
            return;
        }
        if (TextUtils.isEmpty(consignee_name)) {
            ToastUS.Warning("请输入姓名");
            return;
        }
        if (TextUtils.isEmpty(consignee_mobile_phone)) {
            ToastUS.Warning("请输入收票人手机号");
            return;
        }
        if (TextUtils.isEmpty(consignee_address)) {
            ToastUS.Warning("请选择地区");
            return;
        }
        if (TextUtils.isEmpty(consignee_address_details)) {
            ToastUS.Warning("请输入详细地址");
            return;
        }
        requestDate();
    }

    @Override
    protected void initData() {
        setTitle("发票管理");
    }

    private String mProvince = "110000", mCity = "659009502", mDistrict = "110101";

    private void requestDate() {
        LinkedHashMap<String, String> mParamsMapx = new LinkedHashMap<>();
        mParamsMapx.put("inv_type", "1");
        mParamsMapx.put("company_name", company_name);
        mParamsMapx.put("tax_id", tax_id);
        mParamsMapx.put("company_address", company_address);
        mParamsMapx.put("company_telephone", company_telephone);
        mParamsMapx.put("bank_of_deposit", bank_of_deposit);
        mParamsMapx.put("bank_account", bank_account);
        mParamsMapx.put("consignee_name", consignee_name);
        mParamsMapx.put("consignee_mobile_phone", consignee_mobile_phone);
        mParamsMapx.put("consignee_address", consignee_address);
        mParamsMapx.put("province", mProvince);
        mParamsMapx.put("city", mCity);
        mParamsMapx.put("district", mDistrict);
        new OKBuilder(this)
                .setNetUrl(Api.invoice_store_post)
                .setParamsMap(mParamsMapx)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonStatusSuccessBean bean = GsonUS.getIns().getGosn(response, CommonStatusSuccessBean.class);
                        if (bean != null && bean.getData().getCode() == Api.NET_success) {
                            ToastUS.Success(bean.getData().getMessage());
                            finish();
                        } else {
                            ToastUS.Error(bean.getData().getMessage());
                        }

                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }

    private AD_dialog ad_dialog;

    private void initAddressDialog() {
        ad_dialog = new AD_dialog(AddMeInvoiceActivity.this);
        ad_dialog.setOnSelectedListener(new AD_dialog.OnSelectedListener() {
            @Override
            public void onSelectedListener(String province, String provinceCode, String city, String cityCode, String acre, String acreCode) {
                mTvChooseAddress.setText(province + city + acre);
                mProvince = provinceCode + "";
                mCity = cityCode+"";
                mDistrict = acreCode;
                LogUS.I("地址选择： " +"mProvince "+ mProvince +" mCity: "+ cityCode +" acreCode : "+ acreCode);
                ad_dialog.dismis();
            }
        });
    }

    private void showAddressDialog() {
        if (ad_dialog != null) {
            ad_dialog.showDialog();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.activity_add_me_invoice_save:
                checkInput();
//                ADBottomDialog bottomDialog = new ADBottomDialog();
//                bottomDialog.show(getSupportFragmentManager(), "");
//                bottomDialog.setOnDialogListener(new BaseDialogFragment.OnDialogListener() {
//                    @Override
//                    public void onDialogClick(int type) {
//
//                    }
//                });

                break;
            case R.id.activity_add_me_invoice_sl_address:
                showAddressDialog();
                break;
        }
    }


}
