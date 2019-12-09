package com.yinfeng.yfhx.ui.wheight.address_dialog;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.lgd.lgd_core.ui.utils.GsonUS;
import com.lgd.lgd_core.ui.utils.LogUS;
import com.yinfeng.yfhx.entity.AD_BEAN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import chihane.jdaddressselector.ADBottomDialog;
import chihane.jdaddressselector.DataProvider;
import chihane.jdaddressselector.ISelectAble;
import chihane.jdaddressselector.SelectedListener;
import chihane.jdaddressselector.Selector;

/**
 * ============================================
 * 描  述：
 * 包  名：com.yinfeng.yfhx.ui.wheight.address_dialog
 * 类  名：AD_dialog
 * 创建人：liuguodong
 * 创建时间：2019/11/26 14:03
 * ============================================
 **/
public class AD_dialog {
    int deep = 3;

    public AD_dialog(Context mContextx) {
        mContext = mContextx;
    }


    private Context mContext;

    public void showDialog() {
        Selector selector = new Selector(mContext, deep);
        selector.setDataProvider(new DataProvider() {
            @Override
            public void provideData(int currentDeep, int preId, DataReceiver receiver) {
                //根据tab的深度和前一项选择的id，获取下一级菜单项
                Log.i("testre", "provideData: currentDeep >>> " + currentDeep + " preId >>> " + preId);
                if (currentDeep == 0) {
                    receiver.send(getProvinceData());
                } else if (currentDeep == 1) {
                    receiver.send(getCityData(preId));
                } else {
                    receiver.send(getAreaData(preId));

                }
            }
        });
        selector.setSelectedListener(new SelectedListener() {
            @Override
            public void onAddressSelected(ArrayList<ISelectAble> selectAbles) {
                String result = "";
                String result_code = "";
                String proinceName = "";
                String proinceCode = "";
                String cityCode = "";
                String cityName = "";
                String acreName = "";
                String acreCode = "";
                for (ISelectAble selectAble : selectAbles) {
                    result += selectAble.getName() + " ";
                    result_code += selectAble.getCode() + " ";
                }

                for (int i = 0; i < selectAbles.size(); i++) {
                    if (i == 0) {
                        proinceName = selectAbles.get(i).getName() + "";
                        proinceCode = selectAbles.get(i).getCode() + "0000";
                    }
                    if (i == 1) {
                        cityName = selectAbles.get(i).getName() + "";
                        cityCode = selectAbles.get(i).getCode() + "00";
                    }
                    if (i == 2) {

                        acreName = selectAbles.get(i).getName() + "";
                        acreCode = selectAbles.get(i).getCode() + "";
                    }
                }

                if (mSelectedListener != null) {
                    mSelectedListener.onSelectedListener(proinceName, proinceCode, cityName, cityCode, acreName, acreCode);
                }
//                Toast.makeText(mContext, result + result_code, Toast.LENGTH_SHORT).show();
            }
        });
        dialog = new ADBottomDialog(mContext);
        dialog.init(mContext, selector);
        dialog.show();
    }

    private ADBottomDialog dialog;

    public void dismis() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private ArrayList<ISelectAble> getProvinceData() {
//        getAddress();
        String result = getJson("pca-code.json", mContext);
        AD_BEAN bean = GsonUS.getIns().getGosn(result, AD_BEAN.class);
        ArrayList<ISelectAble> data = new ArrayList<>(bean.getPrivice().size());
        for (int i = 0; i < bean.getPrivice().size(); i++) {
            LogUS.I(bean.getPrivice().get(i).getName() + "");
            int finalI = i;
            data.add(new ISelectAble() {
                @Override
                public String getName() {
                    return bean.getPrivice().get(finalI).getName();
                }

                @Override
                public String getCode() {
                    return bean.getPrivice().get(finalI).getCode();
                }

                @Override
                public int getId() {
                    return finalI;
                }

                @Override
                public Object getArg() {
                    return this;
                }
            });
        }
        return data;
    }

    private int mProvince_pos;

    private ArrayList<ISelectAble> getCityData(int province_pos) {
        mProvince_pos = province_pos;
//        getAddress();
        String result = getJson("pca-code.json", mContext);
        AD_BEAN bean = GsonUS.getIns().getGosn(result, AD_BEAN.class);
        ArrayList<ISelectAble> data = new ArrayList<>(bean.getPrivice().size());
        for (int i = 0; i < bean.getPrivice().get(province_pos).getChildren().size(); i++) {
            int finalI = i;
            data.add(new ISelectAble() {
                @Override
                public String getName() {
                    return bean.getPrivice().get(province_pos).getChildren().get(finalI).getName();
                }

                @Override
                public String getCode() {
                    return bean.getPrivice().get(province_pos).getChildren().get(finalI).getCode();
                }

                @Override
                public int getId() {
                    return finalI;
                }

                @Override
                public Object getArg() {
                    return this;
                }
            });
        }
        return data;
    }


    private ArrayList<ISelectAble> getAreaData(int city_pos) {
//        getAddress();
        String result = getJson("pca-code.json", mContext);
        AD_BEAN bean = GsonUS.getIns().getGosn(result, AD_BEAN.class);
        ArrayList<ISelectAble> data = new ArrayList<>(bean.getPrivice().size());
        for (int i = 0; i < bean.getPrivice().get(mProvince_pos).getChildren().get(city_pos).getChildren().size(); i++) {
            int finalI = i;
            data.add(new ISelectAble() {
                @Override
                public String getName() {
                    return bean.getPrivice().get(mProvince_pos).getChildren().get(city_pos).getChildren().get(finalI).getName();
                }

                @Override
                public String getCode() {
                    return bean.getPrivice().get(mProvince_pos).getChildren().get(city_pos).getChildren().get(finalI).getCode();
                }

                @Override
                public int getId() {
                    return finalI;
                }

                @Override
                public Object getArg() {
                    return this;
                }
            });
        }
        return data;
    }

//    public void getAddress() {
//        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
//        map.put("region", "1");
//        map.put("level", "1");
//        new OKBuilder(Latte.getApplicationContext())
//                .setNetUrl(Api.misc_region_get)
//                .setParamsMap(map)
//                .getStringFormBody()
//                .setOnCallBackResponse(new CallBackResponseListener() {
//                    @Override
//                    public void setOnCallBackResponseSuccess(String response) {
//
////                        CommonExternalBean beanx = GsonUS.getIns().getGosn(response, CommonExternalBean.class);
////                        if (beanx.getStatus().equals("success")) {
//////                            LoginBean bean_s = GsonUS.getIns().getGosn(response, LoginBean.class);
////                            ToastUS.Success("添加成功");
////                        } else if (beanx.getStatus().equals("failed")) {
////                            if (beanx != null) {
////                                CommonStatusErrorBean bean_e = GsonUS.getIns().getGosn(response, CommonStatusErrorBean.class);
////                                ToastUS.Error(bean_e.getErrors().getMessage());
////                            }
////                        }
//                    }
//
//                    @Override
//                    public void setOnCallBackResponseError(String response) {
//                    }
//                });
//    }

    public interface OnSelectedListener {
        void onSelectedListener(String province, String provinceCode, String city, String cityCode, String acre, String acreCode);
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListenerx) {
        this.mSelectedListener = onSelectedListenerx;
    }

    private static OnSelectedListener mSelectedListener;


    public static String getJson(String fileName, Context context) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
