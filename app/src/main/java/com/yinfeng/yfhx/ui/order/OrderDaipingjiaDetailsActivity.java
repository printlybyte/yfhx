package com.yinfeng.yfhx.ui.order;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
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
import com.yinfeng.yfhx.entity.order.OrderDaipingjiaDetailsActivityBean;
import com.yinfeng.yfhx.entity.utils.UploadImgSuessBean;
import com.yinfeng.yfhx.ui.utils.FileUploadUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class OrderDaipingjiaDetailsActivity extends BaseActivity implements View.OnClickListener {

    private String order_id;
    private String rec_id;
    /**
     * 2019051311484825270
     */
    private ImageView mRiDaipingjiadetailsGoodsImg;
    /**
     * 得力大铅笔盒
     */
    private TextView mRiDaipingjiadetailsGoodsName;
    /**
     * 黑色
     */
    private TextView mRiDaipingjiadetailsPrice;
    /**
     * ￥25.00
     */
    private TextView mRiDaipingjiadetailsGoodsPrice;
    /**
     * X1
     */
    private TextView mRiDaipingjiadetailsGoodsNums;
    private LinearLayout mRiDaipingjiadetailsGroup;
    private MaterialRatingBar mActivityDaipingjiaDetailsRatingbar;
    /**
     * 产品质量如何？大小合适吗？快写下你的评价！（0-100字）
     */
    private EditText mActivityDaipingjiaDetailsInput;
    private BGASortableNinePhotoLayout mSnplMomentAddPhotos;
    /**
     * 提交申请
     */
    private TextView mActivityDaipingjiaDetailsBtn;


    @Override

    protected int getContentLayoutId() {
        return R.layout.activity_daipingjia_details;
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


        mRiDaipingjiadetailsGoodsImg = (ImageView) findViewById(R.id.ri_daipingjiadetails_goods_img);
        mRiDaipingjiadetailsGoodsName = (TextView) findViewById(R.id.ri_daipingjiadetails_goods_name);
        mRiDaipingjiadetailsPrice = (TextView) findViewById(R.id.ri_daipingjiadetails_price);
        mRiDaipingjiadetailsGoodsPrice = (TextView) findViewById(R.id.ri_daipingjiadetails_goods_price);
        mRiDaipingjiadetailsGoodsNums = (TextView) findViewById(R.id.ri_daipingjiadetails_goods_nums);
        mRiDaipingjiadetailsGroup = (LinearLayout) findViewById(R.id.ri_daipingjiadetails_group);
        mRiDaipingjiadetailsGroup.setOnClickListener(this);
        mActivityDaipingjiaDetailsRatingbar = (MaterialRatingBar) findViewById(R.id.activity_daipingjia_details_ratingbar);
        mActivityDaipingjiaDetailsInput = (EditText) findViewById(R.id.activity_daipingjia_details_input);
        mSnplMomentAddPhotos = (BGASortableNinePhotoLayout) findViewById(R.id.snpl_moment_add_photos);
        mActivityDaipingjiaDetailsBtn = (TextView) findViewById(R.id.activity_daipingjia_details_btn);
        mActivityDaipingjiaDetailsBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        setTitle("评价晒单");
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
            Intent photoPickerPreviewIntent = new BGAPhotoPickerPreviewActivity.IntentBuilder(OrderDaipingjiaDetailsActivity.this)
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
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.comment_addcomment_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {

                            OrderDaipingjiaDetailsActivityBean bean_e = GsonUS.getIns().getGosn(response, OrderDaipingjiaDetailsActivityBean.class);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ri_daipingjiadetails_group:
                break;
            case R.id.activity_daipingjia_details_btn:
                if (mActivityDaipingjiaDetailsRatingbar.getNumStars() == 0) {
                    ToastUS.Error("请选择星级");
                    return;
                }
                rank = mActivityDaipingjiaDetailsRatingbar.getNumStars() + "";
                content = mActivityDaipingjiaDetailsInput.getText().toString();

                if (TextUtils.isEmpty(content)) {
                    ToastUS.Error("请输入内容");
                    return;
                }
                if (jsonArray != null && jsonArray.length() > 0) {
                    WaitDialog.show(OrderDaipingjiaDetailsActivity.this, "上传图片中...");
                    FileUploadUtils.getInstance().user_material_post(jsonArray.toString());
                    FileUploadUtils.getInstance().setOnImgUploadChangeListener(new FileUploadUtils.OnImgUploadChangeListener() {
                        @Override
                        public void OnImgUploadChange(int status, UploadImgSuessBean person, String msg) {
                            if (status == 1) {
                                TipDialog.show(OrderDaipingjiaDetailsActivity.this, "上传成功！", TipDialog.TYPE.SUCCESS).setOnDismissListener(new OnDismissListener() {
                                    @Override
                                    public void onDismiss() {
                                        comment_addgoodscomment_post(person.getData().toString());
                                    }
                                });
                            }
                        }
                    });
                } else {
                    //没有选择图片
                    comment_addgoodscomment_post("");
                }
                break;
        }
    }



    private void setDate(OrderDaipingjiaDetailsActivityBean bean_e) {
        GlideUS.loadPhoto(bean_e.getData().getGoods_thumb() + "", mRiDaipingjiadetailsGoodsImg);
        mRiDaipingjiadetailsGoodsName.setText(bean_e.getData().getGoods_name() + "");
        mRiDaipingjiadetailsGoodsPrice.setText(bean_e.getData().getGoods_price() + " x" + bean_e.getData().getGoods_number());
        id = bean_e.getData().getGoods_id() + "";

    }



    private String content = "", type = "0", rank = "", server = "0", delivery = "0", id = "";

    public void comment_addgoodscomment_post(String arr_imgs) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        map.put("content", content);
        map.put("type", type);
        map.put("rank", rank);
        map.put("server", server);
        map.put("delivery", delivery);
        map.put("order_id", order_id);
        map.put("rec_id", rec_id);
        map.put("pic", arr_imgs);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.comment_addgoodscomment_post)
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
