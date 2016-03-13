package com.ys.newview.ysdemo;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.lang.reflect.Field;

/**  自定义 viewpager  从写 setPageTransformer 方法
 *   解决 API3.0 一下 ，没有动画的问题
 * Created by Administrator on 2016/3/13.
 */
public class MyViewPager extends ViewPager {

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setPageTransformer(boolean reverseDrawingOrder, PageTransformer transformer) {
        if (Build.VERSION.SDK_INT < 11) {
            try {
                //找到mPageTransformer变量，注意要在父类ViewPager找
                Field field = this.getClass().getSuperclass().getDeclaredField("mPageTransformer");
                //设置修改权限
                field.setAccessible(true);
                //这里相当于执行了语句mPageTransformer = transformer;
                field.set(this, transformer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            super.setPageTransformer(reverseDrawingOrder, transformer);
        }
    }
}
