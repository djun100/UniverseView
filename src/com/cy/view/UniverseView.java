package com.cy.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**绘制流程：<br/>
 * 先画底层随机小图标，在frame上层绘制球
 * Created by 承影 on 2015/8/1.
 */
public class UniverseView extends FrameLayout {
    protected Activity mActivity;
    public UniverseView(Context context) {
        super(context);
        initView(context);

    }

    public UniverseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public UniverseView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);

    }
    /**球心位置*/
    private Point mBallCore;
    /**球半径*/
    private int mBallRadius;
    /**球图片drawable*/
    private int mBallIcon;
    /**球图片边长*/
    private int mBallHeight;
    /**随机icon或字体元素个数*/
    private int mElementSum;
    /**容器高度*/
    private int mHeight;
    /**容器宽度*/
    private int mWidth;
    /**图标源*/
    private List<Integer> mIcons;
    /**词组源*/
    private List<String> mWords;
    private void addIcons(){
        if (mIcons==null) return;
            for (Integer icon : mIcons) {
                ImageView iconView=new ImageView(mActivity);
                iconView.setImageResource(icon);
                Point point=getPosition();
                iconView.setX(point.x);
                iconView.setY(point.y);
                addView(iconView);
            }
    }
    private void addWords(){
        if (mWords==null) return;
            for (String content : mWords) {
                TextView tv=new TextView(mActivity);
                tv.setText(content);
                tv.setTextColor(Color.BLACK);
                Point point=getPosition();
                tv.setX(point.x);
                tv.setY(point.y);
                addView(tv);
            }
    }
    public void setIcons(List<Integer> icons){
        mIcons=icons;
    }
    public void setWords(List<String> words){
        mWords=words;
    }
    private void initView(Context context){
        mActivity= (Activity) context;
        measureUI();
    }

    private Point getSelfSize(){
        return new Point(getWidth(),getHeight());
    }
    /**随机位置生成器*/
    private Point getPosition(){
        int x=(int)(Math.random() * mWidth);
        int y=(int)(Math.random() *mHeight);
        Log.i("","getPosition x:"+x+" y:"+y);
        return new Point(x,y);
    }

    private void measureUI(){
        //增加组件绘制之前的监听
        getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {

                        mHeight = getHeight();
                        mWidth=getWidth();
                        Log.i("", "UniverseView mHeight:" + mHeight + " mWidth:" + mWidth);
                        getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        addIcons();
                        addWords();
                    }
                });
    }
}
