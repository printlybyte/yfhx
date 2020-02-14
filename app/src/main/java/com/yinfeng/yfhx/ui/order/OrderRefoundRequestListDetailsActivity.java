package com.yinfeng.yfhx.ui.order;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.kongzue.dialog.interfaces.OnDismissListener;
import com.kongzue.dialog.v3.TipDialog;
import com.kongzue.dialog.v3.WaitDialog;
import com.lgd.lgd_core.base.BaseActivity;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.counterview.IncDecView;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.IntentUtilsConstant;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.common.CommonStatusSuccessBean;
import com.yinfeng.yfhx.entity.order.OrderRefoundRequestListDetailsActivityBean;
import com.yinfeng.yfhx.entity.utils.UploadImgSuessBean;
import com.yinfeng.yfhx.ui.utils.FileUploadUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;

public class OrderRefoundRequestListDetailsActivity extends BaseActivity implements View.OnClickListener {

    private String order_id;
    private String rec_id;

    private TagFlowLayout mActivityOrderRefoundRequestListDetailsSizeTag;
    private NiceSpinner mActivityOrderRefoundRequestListDetailsSpinner;
    /**
     * 本次售后服务将由卖家山东龙大肉食品股份有限公司为您提供
     */
    private TextView mActivityOrderRefoundRequestListDetailsShopname;
    private IncDecView mActivityOrderRefoundRequestListDetailsDotview;
    private LinearLayout mActivityOrderRefoundRequestListDetailsPresoninfo;
    private EditText mActivityRefoundSubmitName;
    private EditText mActivityRefoundSubmitPhone;
    private EditText mActivityRefoundSubmitSelectedAddress;
    private EditText mActivityRefoundSubmitAddressDetails;
    /**
     * 2019051311484825270
     */
    private TextView mRiRefoundRequstlistDetailsOrderSn;
    /**
     * 下单时间：2019-05-13 11：40：56
     */
    private TextView mRiRefoundRequstlistDetailsOrderTime;
    private ImageView mRiRefoundRequstlistDetailsGoodsImg;
    /**
     * 得力大铅笔盒
     */
    private TextView mRiRefoundRequstlistDetailsGoodsName;
    /**
     * 黑色
     */
    private TextView mRiRefoundRequstlistDetailsPrice;
    /**
     * 提交申请
     */
    private TextView mActivityOrderRefoundRequestListDetailsBtn;
    /**
     * 请填写问题秒描述
     */
    private EditText mActivityRefoundSubmitBrief;
    /**
     * 请填写留言
     */
    private EditText mActivityRefoundSubmitRemark;

    @Override

    protected int getContentLayoutId() {
        return R.layout.activity_order_refound_request_list_details;
    }

    @Override
    protected void initView() {
        initNineView();
        Intent intent = getIntent();
        rec_id = intent.getStringExtra(IntentUtilsConstant.INTENT_PARAMS_1);
        order_id = intent.getStringExtra(IntentUtilsConstant.INTENT_PARAMS_2);
        if (TextUtils.isEmpty(rec_id)) {
            ToastUS.Error("请携带查询参数");
            return;
        }
        if (TextUtils.isEmpty(order_id)) {
            ToastUS.Error("请携带查询参数");
            return;
        }


        mActivityOrderRefoundRequestListDetailsSizeTag = (TagFlowLayout) findViewById(R.id.activity_order_refound_request_list_details_sizeTag);
        mActivityOrderRefoundRequestListDetailsSpinner = (NiceSpinner) findViewById(R.id.activity_order_refound_request_list_details_spinner);
        mActivityOrderRefoundRequestListDetailsShopname = (TextView) findViewById(R.id.activity_order_refound_request_list_details_shopname);
        mActivityOrderRefoundRequestListDetailsDotview = (IncDecView) findViewById(R.id.activity_order_refound_request_list_details_dotview);
        mActivityOrderRefoundRequestListDetailsPresoninfo = (LinearLayout) findViewById(R.id.activity_order_refound_request_list_details_presoninfo);
        mActivityRefoundSubmitName = (EditText) findViewById(R.id.activity_refound_submit_name);
        mActivityRefoundSubmitPhone = (EditText) findViewById(R.id.activity_refound_submit_phone);
        mActivityRefoundSubmitSelectedAddress = (EditText) findViewById(R.id.activity_refound_submit_selected_Address);
        mActivityRefoundSubmitAddressDetails = (EditText) findViewById(R.id.activity_refound_submit_address_details);
        mRiRefoundRequstlistDetailsOrderSn = (TextView) findViewById(R.id.ri_refound_requstlist_details_order_sn);
        mRiRefoundRequstlistDetailsOrderTime = (TextView) findViewById(R.id.ri_refound_requstlist_details_order_time);
        mRiRefoundRequstlistDetailsGoodsImg = (ImageView) findViewById(R.id.ri_refound_requstlist_details_goods_img);
        mRiRefoundRequstlistDetailsGoodsName = (TextView) findViewById(R.id.ri_refound_requstlist_details_goods_name);
        mRiRefoundRequstlistDetailsPrice = (TextView) findViewById(R.id.ri_refound_requstlist_details_price);
        mActivityOrderRefoundRequestListDetailsBtn = (TextView) findViewById(R.id.activity_order_refound_request_list_details_btn);
        mActivityOrderRefoundRequestListDetailsBtn.setOnClickListener(this);
        mActivityRefoundSubmitBrief = (EditText) findViewById(R.id.activity_refound_submit_brief);
        mActivityRefoundSubmitRemark = (EditText) findViewById(R.id.activity_refound_submit_remark);
    }

    @Override
    protected void initData() {
        setTitle("申请售后");
        refound_applyreturn_post();
//        refound_submit_return_post();
    }


    private static final int RC_CHOOSE_PHOTO = 1;
    private static final int RC_PHOTO_PREVIEW = 2;
    private BGASortableNinePhotoLayout mPhotosSnpl;

    private void initNineView() {
        mPhotosSnpl = findViewById(R.id.snpl_moment_add_photos);
        mPhotosSnpl.setDelegate(delegate);
        mPhotosSnpl.setMaxItemCount(5);
    }

    private void choicePhotoWrapper() {
        File takePhotoDir = new File(Environment.getExternalStorageDirectory(), "BGAPhotoPickerTakePhoto");
        Intent photoPickerIntent = new BGAPhotoPickerActivity.IntentBuilder(this)
                .cameraFileDir(true ? takePhotoDir : null) // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话则不开启图库里的拍照功能
                .maxChooseCount(mPhotosSnpl.getMaxItemCount() - mPhotosSnpl.getItemCount()) // 图片选择张数的最大值
                .selectedPhotos(null) // 当前已选中的图片路径集合
                .pauseOnScroll(false) // 滚动列表时是否暂停加载图片
                .build();
        startActivityForResult(photoPickerIntent, RC_CHOOSE_PHOTO);
    }

    BGASortableNinePhotoLayout.Delegate delegate = new BGASortableNinePhotoLayout.Delegate() {
        @Override
        public void onClickAddNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, ArrayList<String> models) {
            choicePhotoWrapper();
        }

        @Override
        public void onClickDeleteNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
            mPhotosSnpl.removeItem(position);
        }

        @Override
        public void onClickNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
            Intent photoPickerPreviewIntent = new BGAPhotoPickerPreviewActivity.IntentBuilder(OrderRefoundRequestListDetailsActivity.this)
                    .previewPhotos(models) // 当前预览的图片路径集合
                    .selectedPhotos(models) // 当前已选中的图片路径集合
                    .maxChooseCount(mPhotosSnpl.getMaxItemCount()) // 图片选择张数的最大值
                    .currentPosition(position) // 当前预览图片的索引
                    .isFromTakePhoto(false) // 是否是拍完照后跳转过来
                    .build();
            startActivityForResult(photoPickerPreviewIntent, RC_PHOTO_PREVIEW);

        }

        @Override
        public void onNinePhotoItemExchanged(BGASortableNinePhotoLayout sortableNinePhotoLayout, int fromPosition, int toPosition, ArrayList<String> models) {
//            Toast.makeText(this, "排序发生变化", Toast.LENGTH_SHORT).show();
        }
    };

    boolean mSingleChoiceCb = false;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == RC_CHOOSE_PHOTO) {
            ArrayList<String> mStrList = BGAPhotoPickerActivity.getSelectedPhotos(data);
            if (mSingleChoiceCb) {//是佛单选
                mPhotosSnpl.setData(mStrList);
            } else {
                mPhotosSnpl.addMoreData(mStrList);
                dealWithImg(mStrList);
            }
        } else if (requestCode == RC_PHOTO_PREVIEW) {
            mPhotosSnpl.setData(BGAPhotoPickerPreviewActivity.getSelectedPhotos(data));
        }
    }


    private JSONArray jsonArray = new JSONArray();

    private void dealWithImg(ArrayList<String> mStrList) {
        for (int i = 0; i < mStrList.size(); i++) {
            Bitmap mb = ImageUtils.getBitmap(mStrList.get(i));
            byte[] bxc = ImageUtils.bitmap2Bytes(mb, Bitmap.CompressFormat.JPEG);
            String bs4 = EncodeUtils.base64Encode2String(bxc).replace("/", "");
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("content", "data:image/png;base64," + bs4);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArray.put(jsonObject);
        }
    }


    public void refound_applyreturn_post() {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("rec_id", rec_id);
        map.put("order_id", order_id);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.refound_applyreturn_post)
                .setParamsMap(map)
                .getStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {

                            OrderRefoundRequestListDetailsActivityBean bean_e = GsonUS.getIns().getGosn(response, OrderRefoundRequestListDetailsActivityBean.class);

                            setStatus(bean_e.getData().getGoods_cause());
                            setSpinnerDate(bean_e.getData().getParent_cause());
                            setDate(bean_e);
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


    /**
     * 设置服务类型
     */
    private void setStatus(List<OrderRefoundRequestListDetailsActivityBean.DataBean.GoodsCauseBean> mList) {
        if (mList != null && mList.size() > 0) {
            List<String> mList_c = new ArrayList<>();
            for (int i = 0; i < mList.size(); i++) {
                mList_c.add(mList.get(i).getLang());
            }
            String[] strings = new String[mList_c.size()];
            TagAdapter<String> tagAdapter = new TagAdapter<String>(mList_c.toArray(strings)) {
                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.tag_selected_specification_layout, mActivityOrderRefoundRequestListDetailsSizeTag, false);
                    tv.setText(s);
                    return tv;
                }
            };
            tagAdapter.setSelectedList(0);
            mActivityOrderRefoundRequestListDetailsSizeTag.setAdapter(tagAdapter);
            mActivityOrderRefoundRequestListDetailsSizeTag.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
                @Override
                public void onSelected(Set<Integer> selectPosSet) {
                    if (selectPosSet.toString().length() == 3) {
                        String as = selectPosSet.toString().substring(1, 2);
                        String sel_id = mList_c.get(Integer.parseInt(as));
                        return_type = mList.get(Integer.parseInt(as)).getCause() + "";
                        if (sel_id.equals("换货")) {
                            mActivityOrderRefoundRequestListDetailsPresoninfo.setVisibility(View.VISIBLE);
                        } else {
                            mActivityOrderRefoundRequestListDetailsPresoninfo.setVisibility(View.GONE);
                        }
                    } else {
                    }
                }
            });
        }
    }

    private void setSpinnerDate(List<OrderRefoundRequestListDetailsActivityBean.DataBean.ParentCauseBean> mList) {
        if (mList != null && mList.size() > 0) {
            List<String> dataset = new ArrayList<>();
            for (int i = 0; i < mList.size(); i++) {
                dataset.add(mList.get(i).getCause_name());
            }
            last_option = mList.get(0).getCause_id() + "";
            mActivityOrderRefoundRequestListDetailsSpinner.attachDataSource(dataset);
            mActivityOrderRefoundRequestListDetailsSpinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
                @Override
                public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                    String item = dataset.get(position);
//                    ToastUS.Error(item);
                    last_option = mList.get(position).getCause_id() + "";
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;

            case R.id.activity_order_refound_request_list_details_btn:

                return_brief = mActivityRefoundSubmitBrief.getText().toString();
                return_remark = mActivityRefoundSubmitRemark.getText().toString();

                if (TextUtils.isEmpty(return_brief)) {
                    ToastUS.Error("请填写问题描述");
                    return;
                }

                if (jsonArray != null && jsonArray.length() > 0) {
                    WaitDialog.show(OrderRefoundRequestListDetailsActivity.this, "上传图片中...");
                    FileUploadUtils.getInstance().user_material_post(jsonArray.toString());
                    FileUploadUtils.getInstance().setOnImgUploadChangeListener(new FileUploadUtils.OnImgUploadChangeListener() {
                        @Override
                        public void OnImgUploadChange(int status, UploadImgSuessBean person, String msg) {
                            if (status == 1) {
                                TipDialog.show(OrderRefoundRequestListDetailsActivity.this, "上传成功！", TipDialog.TYPE.SUCCESS).setOnDismissListener(new OnDismissListener() {
                                    @Override
                                    public void onDismiss() {
                                        refound_submit_return_post(person.getData().toString());

                                    }
                                });
                            }
                        }
                    });
                } else {
                    //没有选择图片
                    refound_submit_return_post("");
                }
                break;
        }
    }


    /**
     * if (checked) {
     * mPhotosSnpl.setData(null);
     * mPhotosSnpl.setMaxItemCount(1);
     * } else {
     * mPhotosSnpl.setMaxItemCount(9);
     * }
     */

    private void setDate(OrderRefoundRequestListDetailsActivityBean bean_e) {
        if (bean_e.getData().getGoods_info().getGet_seller_shop_info() != null) {
            mActivityOrderRefoundRequestListDetailsShopname.setText("本次售后服务将由卖家" + bean_e.getData().getGoods_info().getGet_seller_shop_info().getShop_name() + "为您提供");
        }
        mActivityOrderRefoundRequestListDetailsDotview.setStartCounterValue(bean_e.getData().getReturn_goods_num() + "");
        return_number = bean_e.getData().getReturn_goods_num() + "";

        mActivityRefoundSubmitName.setText(bean_e.getData().getConsignee().getConsignee() + "");
        mActivityRefoundSubmitPhone.setText(bean_e.getData().getConsignee().getMobile() + "");
        mActivityRefoundSubmitAddressDetails.setText(bean_e.getData().getConsignee().getAddress() + "");

        mRiRefoundRequstlistDetailsOrderSn.setText(bean_e.getData().getOrder().getOrder_sn() + "");
        mRiRefoundRequstlistDetailsOrderTime.setText(bean_e.getData().getOrder().getPay_time() + "");
        mRiRefoundRequstlistDetailsGoodsName.setText(bean_e.getData().getGoods_info().getGoods_name() + "");
        mRiRefoundRequstlistDetailsPrice.setText(bean_e.getData().getGoods_info().getAttr_name() + "");
        GlideUS.loadPhoto(bean_e.getData().getGoods_info().getGoods_thumb() + "", mRiRefoundRequstlistDetailsGoodsImg);

        province_region_id = bean_e.getData().getConsignee().getProvince() + "";
        city_region_id = bean_e.getData().getConsignee().getCity() + "";
        district_region_id = bean_e.getData().getConsignee().getDistrict() + "";
        addressee = bean_e.getData().getConsignee().getAddress() + "";
        mobile=bean_e.getData().getConsignee().getMobile();
        street="0";

    }

    /**
     * chargeoff_status' => $chargeoff_status, // 账单 0 未结账 1 已出账 2 已结账单 默认0
     * 'cause_id' => $last_option, //退换货原因
     * return_type '退换货标识：0：维修，1：退货，2：换货，3：仅退款'，
     */


    String return_remark = "", return_brief = "", return_number = "";

    String chargeoff_status = "0", return_type = "1", last_option = "";
    String addressee = "", mobile = "", return_address = "", province_region_id = "", city_region_id = "", district_region_id = "", street = "";

    public void refound_submit_return_post(String arr_imgs) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("rec_id", rec_id);
        map.put("return_images", arr_imgs);
        map.put("return_remark", return_remark);
        map.put("return_brief", return_brief);
        map.put("return_number", return_number);

        map.put("chargeoff_status", chargeoff_status);
        map.put("return_type", return_type);
        map.put("last_option", last_option);

        map.put("addressee", addressee);
        map.put("mobile", mobile);
        map.put("province_region_id", province_region_id);
        map.put("return_address", return_address);
        map.put("city_region_id", city_region_id);
        map.put("district_region_id", district_region_id);
        map.put("street", street);

        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.refound_submit_return_post)
                .showLoading("1111")
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            CommonStatusSuccessBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusSuccessBean.class);

                            ToastUS.Success(bean_e.getData().getMessage());

                            finish();
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
