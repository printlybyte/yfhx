package com.yinfeng.yfhx.ui.me;

import android.content.ContentUris;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.CommonUtils;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.Tab_4_FragmentBean;

/**
 * ============================================
 * 描  述：个人信息
 * 包  名：com.yinfeng.yfhx.ui.me
 * 类  名：PersonalInfoActivity
 * 创建人：liuguodong
 * 创建时间：2019/10/12 10:48
 * ============================================
 **/
public class PersonalInfoActivity extends BaseActivity {


    private ImageView mActivityPersonalInfoHeader;
    /**
     * 会员名称
     */
    private EditText mActivityPersonalInfoName;
    /**
     * 1234678901
     */
    private TextView mActivityPersonalInfoPhone;
    /**
     * 男
     */
    private TextView mActivityPersonalInfoSex;
    /**
     * 张三
     */
    private TextView mActivityPersonalInfoRealname;
    /**
     * 372389282828828282
     */
    private TextView mActivityPersonalCardId;
    /**
     * 银丰电子商务有限公司
     */
    private TextView mActivityPersonalCompany;
    /**
     * 运营部
     */
    private TextView mActivityPersonalDepartment;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_personal_info;
    }

    @Override
    protected void initView() {

        mActivityPersonalInfoHeader = (ImageView) findViewById(R.id.activity_personal_info_header);
        mActivityPersonalInfoName = (EditText) findViewById(R.id.activity_personal_info_name);
        mActivityPersonalInfoPhone = (TextView) findViewById(R.id.activity_personal_info_phone);
        mActivityPersonalInfoSex = (TextView) findViewById(R.id.activity_personal_info_sex);
        mActivityPersonalInfoRealname = (TextView) findViewById(R.id.activity_personal_info_realname);
        mActivityPersonalCardId = (TextView) findViewById(R.id.activity_personal_card_id);
        mActivityPersonalCompany = (TextView) findViewById(R.id.activity_personal_company);
        mActivityPersonalDepartment = (TextView) findViewById(R.id.activity_personal_department);
    }

    @Override
    protected void initData() {
        setTitle("个人信息");
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestDate();
    }

    private void requestDate() {
        new OKBuilder(this)
                .setNetUrl(Api.user_profile_get)
                .showLoading("loading...")
                .get()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        Tab_4_FragmentBean bean = GsonUS.getIns().getGosn(response, Tab_4_FragmentBean.class);
                        if (bean != null) {
                            setProfileDate(bean.getData());
                        } else {

                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }

    private void setProfileDate(Tab_4_FragmentBean.DataBean bean) {

        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        mActivityPersonalInfoName.setText(bean.getName() == "" ? tipStr : bean.getName());
        mActivityPersonalCardId.setText(bean.getEmp().getIdcard() == "" ? tipStr : bean.getEmp().getIdcard());
        mActivityPersonalInfoRealname.setText(bean.getEmp().getEmployee_name() == "" ? tipStr : bean.getEmp().getEmployee_name());
        mActivityPersonalInfoPhone.setText(bean.getEmp().getMobile() == "" ? tipStr : bean.getEmp().getMobile());
        mActivityPersonalCompany.setText(bean.getEmp().getCompany_name() == "" ? tipStr : bean.getEmp().getCompany_name());
        mActivityPersonalDepartment.setText(bean.getEmp().getDepartment() == "" ? tipStr : bean.getEmp().getDepartment());

        GlideUS.loadHeader("https://pic3.58cdn.com.cn/anjuke_58/cf39a43ebaf88a2b0ad75259c89ff402", mActivityPersonalInfoHeader);

        String idCard = bean.getEmp().getIdcard();
        mActivityPersonalInfoSex.setText(CommonUtils.getSex(idCard) == "" ? tipStr : CommonUtils.getSex(idCard));
    }


}
