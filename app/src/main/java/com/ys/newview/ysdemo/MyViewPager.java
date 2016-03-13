package com.ys.newview.ysdemo;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.lang.reflect.Field;

/**  �Զ��� viewpager  ��д setPageTransformer ����
 *   ��� API3.0 һ�� ��û�ж���������
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
                //�ҵ�mPageTransformer������ע��Ҫ�ڸ���ViewPager��
                Field field = this.getClass().getSuperclass().getDeclaredField("mPageTransformer");
                //�����޸�Ȩ��
                field.setAccessible(true);
                //�����൱��ִ�������mPageTransformer = transformer;
                field.set(this, transformer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            super.setPageTransformer(reverseDrawingOrder, transformer);
        }
    }
}
