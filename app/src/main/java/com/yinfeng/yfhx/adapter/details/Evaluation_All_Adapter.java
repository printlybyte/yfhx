package com.yinfeng.yfhx.adapter.details;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.gproview.UserViewInfo;
import com.lgd.lgd_core.ui.utils.GlideUS;
import com.previewlibrary.GPreviewBuilder;
import com.yinfeng.yfhx.R;
import com.yinfeng.yfhx.entity.details.FragmentEvaluation_AllBean;

import java.util.ArrayList;
import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.adapter.me
 * 类  名：MeInvoiceAdapter
 * 创建人：liuguodong
 * 创建时间：2019/10/12 10:54
 * ============================================
 **/

public class Evaluation_All_Adapter extends BaseQuickAdapter<FragmentEvaluation_AllBean.DataBean, Evaluation_All_Adapter.MyHolder> {

    private Activity mActivity;
    public Evaluation_All_Adapter(Activity activity,int layoutResId, List data) {
        super(layoutResId, data);
        mActivity=activity;
    }


    @Override
    protected void convert(@NonNull Evaluation_All_Adapter.MyHolder helper, FragmentEvaluation_AllBean.DataBean item) {

        GlideUS.loadHeader(item.getUser_picture(), helper.getConvertView().findViewById(R.id.item_f_evaluation_all_layout_user_img));
        String tipStr = Latte.getApplicationContext().getResources().getString(R.string.re_empty_date_tip_txt);
        helper.setText(R.id.item_f_evaluation_all_layout_content, item.getContent() == "" ? tipStr : item.getContent());
        helper.setText(R.id.item_f_evaluation_all_layout_user_name, item.getUser_name() == "" ? tipStr : item.getUser_name());
        helper.setText(R.id.item_f_evaluation_all_layout_time, item.getAdd_time() == "" ? tipStr : item.getAdd_time());
        helper.ratingBar.setNumStars(item.getRank());


        helper.nineGridImageView.setAdapter(mAdapter);
        helper.nineGridImageView.setImagesData(item.getComment_img());


    }

    class MyHolder extends BaseViewHolder {
        private MaterialRatingBar ratingBar;
        private NineGridImageView nineGridImageView;

        public MyHolder(View view) {
            super(view);
            ratingBar = view.findViewById(R.id.item_f_evaluation_all_layout_ratingbar);
            nineGridImageView = view.findViewById(R.id.include_nine_gridview_ninegridview);
        }
    }

    private NineGridImageViewAdapter<String> mAdapter = new NineGridImageViewAdapter<String>() {
        @Override
        protected void onDisplayImage(Context context, ImageView imageView, String s) {
            GlideUS.loadPhoto(s, imageView);
        }

        @Override
        protected ImageView generateImageView(Context context) {
            return super.generateImageView(context);
        }

        @Override
        protected void onItemImageClick(Context context, ImageView imageView, int index, List<String> list) {
            ArrayList<UserViewInfo> mListImgBeanz = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                UserViewInfo userViewInfo = new UserViewInfo(list.get(i));
                mListImgBeanz.add(userViewInfo);
            }
            GPreviewBuilder.from(mActivity)//activity实例必须
                    .setData(mListImgBeanz)//集合
                    .setCurrentIndex(index)
                    .setSingleFling(false)//是否在黑屏区域点击返回
                    .setDrag(false)//是否禁用图片拖拽返回
                    .setType(GPreviewBuilder.IndicatorType.Dot)//指示器类型
                    .start();//启动
        }
    };

}


