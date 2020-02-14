package com.yinfeng.yfhx.ui.utils;

import com.lgd.lgd_core.event.Latte;
import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.ToastUS;
import com.lgd.lgd_core.ui.utils.okgoutils.CallBackResponseListener;
import com.lgd.lgd_core.ui.utils.okgoutils.OKBuilder;
import com.yinfeng.yfhx.Api;
import com.yinfeng.yfhx.entity.common.CommonExternalBean;
import com.yinfeng.yfhx.entity.common.CommonStatusErrorBean;
import com.yinfeng.yfhx.entity.utils.UploadImgSuessBean;

import java.util.LinkedHashMap;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.ui.details
 * 类  名：DetailsUtils
 * 创建人：liuguodong
 * 创建时间：2019/11/21 16:37
 * ============================================
 **/
public class FileUploadUtils {
    private static final FileUploadUtils ourInstance = new FileUploadUtils();

    public static FileUploadUtils getInstance() {
        return ourInstance;
    }

    private FileUploadUtils() {
    }


    public void user_material_post(String baseImg64Arr) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("file", baseImg64Arr);
        new OKBuilder(Latte.getApplicationContext())
                .setNetUrl(Api.user_material_post)
                .setParamsMap(map)
                .postStringFormBody()
                .setOnCallBackResponse(new CallBackResponseListener() {
                    @Override
                    public void setOnCallBackResponseSuccess(String response) {
                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
                        if (beanx.getStatus().equals("success")) {
                            UploadImgSuessBean bean_e = GsonUS.getIns().getGosn(response, UploadImgSuessBean.class);
//                            ToastUS.Error(bean_e.getData().getMessage());
                            if (onImgUploadChangeListener!=null){
                                onImgUploadChangeListener.OnImgUploadChange(1,bean_e,"");
                            }
                        } else if (beanx.getStatus().equals("failed")) {
                            if (beanx != null) {
                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
                                ToastUS.Error(bean_e.getErrors().getMessage());
                                if (onImgUploadChangeListener!=null){
                                    onImgUploadChangeListener.OnImgUploadChange(0,null,bean_e.getErrors().getMessage());
                                }
                            }
                        }
                    }

                    @Override
                    public void setOnCallBackResponseError(String response) {
                    }
                });
    }


    public interface OnImgUploadChangeListener {
        void OnImgUploadChange(int status, UploadImgSuessBean person, String msg);
    }

    public void setOnImgUploadChangeListener(OnImgUploadChangeListener dialogListener) {
        this.onImgUploadChangeListener = dialogListener;
    }

    private static OnImgUploadChangeListener onImgUploadChangeListener;


}
