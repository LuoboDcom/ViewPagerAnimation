package com.ys.newview.ysdemo.anim;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/** DepthPageTransformer2 ��д ���� API3.0 ����
 * Created by ys on 2016/3/13.
 */
public class DepthPageTransformer2 implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.75f;

    public void transformPage(View view, float position)
    {
        int pageWidth = view.getWidth();

        if (position < -1)
        { // [-Infinity,-1)
            // This page is way off-screen to the left.
            // view.setAlpha(0);
            ViewHelper.setAlpha(view, 0);
        } else if (position <= 0)// aҳ������bҳ �� aҳ�� 0.0 -1 ��bҳ��1 ~ 0.0
        { // [-1,0]
            // Use the default slide transition when moving to the left page
            // view.setAlpha(1);
            ViewHelper.setAlpha(view, 1);
            // view.setTranslationX(0);
            ViewHelper.setTranslationX(view, 0);
            // view.setScaleX(1);
            ViewHelper.setScaleX(view, 1);
            // view.setScaleY(1);
            ViewHelper.setScaleY(view, 1);

        } else if (position <= 1)
        { // (0,1]
            // Fade the page out.
            // view.setAlpha(1 - position);
            ViewHelper.setAlpha(view, 1 - position);

            // Counteract the default slide transition
            // view.setTranslationX(pageWidth * -position);
            ViewHelper.setTranslationX(view, pageWidth * -position);

            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - position);
            // view.setScaleX(scaleFactor);
            ViewHelper.setScaleX(view, scaleFactor);
            // view.setScaleY(1);
            ViewHelper.setScaleY(view, scaleFactor);

        } else
        { // (1,+Infinity]
            // This page is way off-screen to the right.
            // view.setAlpha(0);
            ViewHelper.setAlpha(view, 1);
        }
    }
}
