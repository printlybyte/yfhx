package com.yinfeng.yfhx.ui.wheight.dialog;

import android.view.Gravity;
import android.view.View;

import com.lgd.lgd_core.ui.dialogFragment.BaseDialogFragment;
import com.yinfeng.yfhx.R;

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core.ui.dialogFragment
 * 类  名：ADBottomDialog
 * 创建人：liuguodong
 * 创建时间：2019/10/12 16:11
 * ============================================
 **/
public class BottomDialog extends BaseDialogFragment {
    @Override
    protected int getContentLayoutId() {
        return R.layout.df_bottom;
    }

    @Override
    protected int getContentGravity() {
        return Gravity.BOTTOM;
    }

    @Override
    protected void initView(View view) {

    }
}
