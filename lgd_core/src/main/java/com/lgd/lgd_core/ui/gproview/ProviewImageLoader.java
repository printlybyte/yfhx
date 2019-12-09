package com.lgd.lgd_core.ui.gproview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.glideTransformation.CropCircleTransformation;
import com.lgd.lgd_core.ui.glideTransformation.RoundedCornersTransformation;
import com.previewlibrary.loader.IZoomMediaLoader;
import com.previewlibrary.loader.MySimpleTarget;

import static com.lgd.lgd_core.ui.utils.GlideUS.PhotoErrorImg;
import static com.lgd.lgd_core.ui.utils.GlideUS.PhotoPlaceholderImg;

/**
 * ============================================
 * 描  述：
 * 包  名：com.wlkj.tanyanpersonage.activitys.home
 * 类  名：ProviewImageLoader
 * 创建人：lgd
 * 创建时间：2019/4/29 18:01
 * ============================================
 **/
public class ProviewImageLoader implements IZoomMediaLoader {

    private static Context mContext = Latte.getApplicationContext();


    @Override
    public void displayImage(@NonNull Fragment context, @NonNull String path, ImageView imageView, @NonNull final MySimpleTarget simpleTarget) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(PhotoPlaceholderImg)
                .centerCrop()
                .error(PhotoErrorImg);
        Glide.with(mContext).load(path)
                .apply(requestOptions)
//                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(5, 3)))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        simpleTarget.onResourceReady();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        simpleTarget.onLoadFailed(null);
                        return false;
                    }
                })
                .into(imageView);
    }

    @Override
    public void displayGifImage(@NonNull Fragment context, @NonNull String path, ImageView imageView, @NonNull final MySimpleTarget simpleTarget) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(PhotoPlaceholderImg)
                .centerCrop()
                .error(PhotoErrorImg);
        Glide.with(mContext).load(path)
                .apply(requestOptions)
//                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(5, 3)))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        simpleTarget.onResourceReady();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        simpleTarget.onLoadFailed(null);
                        return false;
                    }
                })
                .into(imageView);

    }
    @Override
    public void onStop(@NonNull Fragment context) {
        Glide.with(context).onStop();
    }
    @Override
    public void clearMemory(@NonNull Context c) {
        Glide.get(c).clearMemory();
    }}