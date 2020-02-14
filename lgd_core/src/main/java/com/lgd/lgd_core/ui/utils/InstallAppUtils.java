package com.lgd.lgd_core.ui.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.util.List;

/**
 * ============================================
 * 描  述：判断是否安装应用实体工具
 * 包  名：com.wlkj.tanyanpersonage.Umeng
 * 类  名：TanYanPersonage
 * 创建人：zhangjiye
 * 创建时间：2019/4/24 13:47
 * ============================================
 **/
public class InstallAppUtils {
    private InstallAppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 检测是否安装支付宝
     *
     * @param context
     * @return
     */
    public static boolean checkAliPayInstalled(Context context) {
        Uri uri = Uri.parse("alipays://platformapi/startApp");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        ComponentName componentName = intent.resolveActivity(context.getPackageManager());
        return componentName != null;
    }

    /**
     * 判断 用户是否安装微信客户端
     */
    public static boolean isWeixinAvilible(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断 用户是否安装QQ客户端
     */
    public static boolean isQQClientAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equalsIgnoreCase("com.tencent.qqlite") || pn.equalsIgnoreCase("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * sina
     * 判断是否安装新浪微博
     */
    public static boolean isSinaInstalled(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;

                if (pn.equals("com.sina.weibo")) {
                    return true;
                }
            }
        }
        return false;
    }


    //检测是否安装了应用宝
    public static boolean isYingyongbaoExist(Context context) {
        PackageManager manager = context.getPackageManager();
        List<PackageInfo> pkgList = manager.getInstalledPackages(0);
        for (int i = 0; i < pkgList.size(); i++) {
            PackageInfo pI = pkgList.get(i);
            if (pI.packageName.equalsIgnoreCase("com.tencent.android.qqdownloader"))
                return true;
        }
        return false;
    }


    //检测是否安装了应用宝
    public static void JumpYingyongbao(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse("market://details?id=" + context.getPackageName());
        try {
            intent.setClassName("com.tencent.android.qqdownloader", "com.tencent.pangu.link.LinkProxyActivity");
            intent.setData(content_url);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
