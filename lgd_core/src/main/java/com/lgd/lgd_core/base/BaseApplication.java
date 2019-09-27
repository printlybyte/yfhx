package com.lgd.lgd_core.base;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.lgd.lgd_core.BuildConfig;
import com.lgd.lgd_core.event.Latte;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper;
import es.dmoral.toasty.Toasty;


public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initW();
    }

    private void initW() {
        Latte.init(this);
        /**
         * 必须在 Application 的 onCreate 方法中执行 BGASwipeBackHelper.init 来初始化滑动返回
         * 第一个参数：应用程序上下文
         * 第二个参数：如果发现滑动返回后立即触摸界面时应用崩溃，请把该界面里比较特殊的 View 的 class 添加到该集合中，目前在库中已经添加了 WebView 和 SurfaceView
         */
        BGASwipeBackHelper.init(this, null);

        Hawk.init(this).build();



//        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
//                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
////                .methodCount(0)         // (Optional) How many method line to show. Default 2
////                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
////                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
//                .tag("Testre")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
//                .build();
        Logger.addLogAdapter(new AndroidLogAdapter());


//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
////                .addInterceptor(new LoggerInterceptor("TAG"))
//                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
//                .readTimeout(10000L, TimeUnit.MILLISECONDS)
//                //其他配置
//                .build();
//        OkHttpUtils.initClient(okHttpClient);

//        setupDatabase();
    }



//    private static DaoSession daoSession;

    /**
     * greendao 数据库  配置数据库
     */
//    private void setupDatabase() {
//        //创建数据库shop.db" 创建SQLite数据库的SQLiteOpenHelper的具体实现
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db.db", null);
//        //获取可写数据库
//        SQLiteDatabase db = helper.getWritableDatabase();
//        //获取数据库对象  GreenDao的顶级对象，作为数据库对象、用于创建表和删除表
//        DaoMaster daoMaster = new DaoMaster(db);
//        //获取Dao对象管理者  管理所有的Dao对象，Dao对象中存在着增删改查等API
//        daoSession = daoMaster.newSession();
//    }

//    public static DaoSession getDaoInstant() {
//        return daoSession;
//    }



}
