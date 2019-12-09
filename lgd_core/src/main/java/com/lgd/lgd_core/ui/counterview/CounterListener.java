package com.lgd.lgd_core.ui.counterview;

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core.ui.counterview
 * 类  名：CounterListener
 * 创建人：liuguodong
 * 创建时间：2019/10/17 16:13
 * ============================================
 **/
public interface CounterListener {
    void onIncClick(String value);
    void onDecClick(String value);
}