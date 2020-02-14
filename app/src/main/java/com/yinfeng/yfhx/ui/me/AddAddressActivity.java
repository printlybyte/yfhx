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
import com.yinfeng.yfhx.entity.common.CommonAddAddressStatusBean;
import com.yinfeng.yfhx.ui.wheight.address_dialog.AD_dialog;

import java.util.LinkedHashMap;

public class AddAddressActivity extends BaseActivity implements View.OnClickListener {


    /**
     * 请输入收货人姓名
     */
    private EditText mEtName;
    /**
     * 请输入收货人电话
     */
    private EditText mEtPhone;
    /**
     * 山东省 济南市 历阳大街6号
     */
    private TextView mTvAddress;
    private RelativeLayout mActivityAddAddressSdAddress;
    /**
     * 请输入详细信息
     */
    private EditText mEtDescription;
    /**
     * 保存
     */
    private Button mBtSave;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_add_address;
    }

    @Override
    protected void initView() {
        initAddressDialog();
        mEtName = (EditText) findViewById(R.id.etName);
        mEtPhone = (EditText) findViewById(R.id.etPhone);
        mTvAddress = (TextView) findViewById(R.id.tvAddress);
        mActivityAddAddressSdAddress = (RelativeLayout) findViewById(R.id.activity_add_address_sd_address);
        mActivityAddAddressSdAddress.setOnClickListener(this);
        mEtDescription = (EditText) findViewById(R.id.etDescription);
        mBtSave = (Button) findViewById(R.id.btSave);
        mBtSave.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        setTitle("地址管理");
    }

    private String mProvince = "110000", mCity = "659009502", mDistrict = "110101";

    private AD_dialog ad_dialog;

    private void initAddressDialog() {
        ad_dialog = new AD_dialog(AddAddressActivity.this);
        ad_dialog.setOnSelectedListener(new AD_dialog.OnSelectedListener() {
            @Override
            public void onSelectedListener(String province, String provinceCode, String city, String cityCode, String acre, String acreCode) {
                mTvAddress.setText(province + city + acre);
                mProvince = provinceCode + "";
                mCity = cityCode;
                mDistrict = acreCode;
                LogUS.I("地址选择： " + provinceCode + cityCode + acreCode);
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
            case R.id.activity_add_address_sd_address:
                showAddressDialog();
                break;
            case R.id.btSave:
                checkInput();
                break;
        }
    }

    String mName, mPhone, mCountry = "1", mDesription;

    private void checkInput() {
        mName = mEtName.getText().toString().trim();
        mPhone = mEtPhone.getText().toString().trim();
        mDesription = mEtDescription.getText().toString().trim();
        if (TextUtils.isEmpty(mName)) {
            ToastUS.Warning("请输入收货人姓名");
            return;
        }

        if (TextUtils.isEmpty(mPhone)) {
            ToastUS.Warning("请输入收货人电话");
            return;
        }
        if (TextUtils.isEmpty(mProvince)) {
            ToastUS.Warning("请选择所在地区");
            return;
        }
        if (TextUtils.isEmpty(mDesription)) {
            ToastUS.Warning("请输入详细信息");
            return;
        }

        requestDate();
    }

    private void requestDate() {
        LinkedHashMap<String, String> mParamsMapx = new LinkedHashMap<>();
//        mParamsMapx.put("address_id", "0");
        mParamsMapx.put("address", mDesription);
        mParamsMapx.put("consignee", mName);
        mParamsMapx.put("mobile", mPhone);

        mParamsMapx.put("province", mProvince);
        mParamsMapx.put("city", mCity);
        mParamsMapx.put("country", mCountry);
        mParamsMapx.put("district", mDistrict);
        new OKBuilder(this)
                .setNetUrl(Api.address_store_post)
                .setParamsMap(mParamsMapx)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonAddAddressStatusBean bean = GsonUS.getIns().getGosn(response, CommonAddAddressStatusBean.class);
                        if (bean != null && bean.isData()) {
                            ToastUS.Success(bean.isData() + "");
                            finish();
                        } else {
                            ToastUS.Success(bean.isData() + "");
                        }

                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {

                    }
                });
    }
}
