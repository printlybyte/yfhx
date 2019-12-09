package com.lgd.lgd_core.ui.utils.behahior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * ============================================
 * 描  述：
 * 包  名：com.lgd.lgd_core.ui.utils.behahior
 * 类  名：DetailsTitleBehavior
 * 创建人：liuguodong
 * 创建时间：2019/11/21 11:11
 * ============================================
 **/
public class DetailsTitleBehavior  extends CoordinatorLayout.Behavior<View> {
        // 列表顶部和title底部重合时，列表的滑动距离。
        private float deltaY;

        public DetailsTitleBehavior() {
        }

        public DetailsTitleBehavior(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
            return dependency instanceof ViewPager;
        }

//        @Override
//        public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
//            if (deltaY == 0) {
//                deltaY = dependency.getY() - child.getHeight();
//            }
//            float dy = dependency.getY() - child.getHeight();
//            dy = dy < 0 ? 0 : dy;
//            float y = -(dy / deltaY) * child.getHeight();
//            child.setTranslationY(y);
//            return true;
//        }

        //透明效果
        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
            if (deltaY == 0) {
                deltaY = dependency.getY() - child.getHeight();
            }

            float dy = dependency.getY() - child.getHeight();
            dy = dy < 0 ? 0 : dy;
            float alpha = 1 - (dy / deltaY);
            child.setAlpha(alpha);

            return true;
        }
}
