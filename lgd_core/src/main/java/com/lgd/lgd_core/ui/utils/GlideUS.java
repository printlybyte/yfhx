package com.lgd.lgd_core.ui.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lgd.lgd_core.R;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.glideTransformation.CropCircleTransformation;
import com.lgd.lgd_core.ui.glideTransformation.RoundedCornersTransformation;

/**
 * ============================================
 * 描  述：Glide 工具类
 * 包  名：com.lgd.lgd_core.ui.utils
 * 类  名：GlideUS
 * 创建人：liuguodong
 * 创建时间：2019/9/5 10:32
 * ============================================
 **/
public class GlideUS {

    private static Context mContext = Latte.getApplicationContext();

    private static int PhotoPlaceholderImg = R.mipmap.ic_svg_glide_photo_placeholder;
    private static int PhotoErrorImg = R.drawable.ic_svg_glide_photo_error;

    private static int HeaderPlaceholderImg = R.drawable.ic_svg_glide_header_placeholder;
    private static int HeaderErrorImg = R.drawable.ic_svg_glide_header_erray;

    public static void loadPhoto(String ImgPath, ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(PhotoPlaceholderImg)
                .centerCrop()
                .error(PhotoErrorImg);
        Glide.with(mContext).load(ImgPath)
                .apply(requestOptions)
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(5, 3)))
                .into(imageView);
    }

    public static void loadHeader(String ImgPath, ImageView imageView) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(HeaderPlaceholderImg)
                .error(HeaderErrorImg);
        Glide.with(mContext).load(ImgPath)
                .apply(requestOptions)
                .apply(RequestOptions.bitmapTransform(new CropCircleTransformation()))
                .into(imageView);
    }


}
