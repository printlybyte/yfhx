package com.lgd.lgd_core.listener;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;

import com.lgd.lgd_core.event.ActResultRequest;

/**
 * ============================================
 * 描  述：
 * 包  名：com.caitiaobang.core.app.app
 * 类  名：OnActResultEventDispatcherFragment
 * 创建人：lgd
 * 创建时间：2019/7/5 11:31
 * ============================================
 **/
public class OnActResultEventDispatcherFragment extends Fragment {

    public static final String TAG = "on_act_result_event_dispatcher";

    private SparseArray<ActResultRequest.Callback> mCallbacks = new SparseArray<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void startForResult(Intent intent, ActResultRequest.Callback callback) {
        mCallbacks.put(callback.hashCode(), callback);
        startActivityForResult(intent, callback.hashCode());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ActResultRequest.Callback callback = mCallbacks.get(requestCode);
        mCallbacks.remove(requestCode);

        if (callback != null) {
            callback.onActivityResult(resultCode, data);
        }
    }

}


