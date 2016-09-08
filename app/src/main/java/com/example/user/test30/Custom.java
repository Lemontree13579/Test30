package com.example.user.test30;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Cathleen on 2016/9/7.
 */
public class Custom extends View {
    public Custom(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画布颜色
        canvas.drawColor(Color.WHITE);
        //新建画笔
        Paint paint = new Paint();
        //画笔颜色
        paint.setColor(Color.RED);
        //抗锯齿
        paint.setAntiAlias(true);
        //填充类型 STROKE空心 FILL实心 FILL_AND_STROKE
        paint.setStyle(Paint.Style.FILL);
        //画笔宽度
        paint.setStrokeWidth(5);
        //绘制普通矩形,左右边距画布左，上下边距画布上
        canvas.drawRect(10,10,140,100,paint);
        //绘制三角形，内部填充
        Path path=new Path();
        path.moveTo(10, 120);//多边形起点
        path.lineTo(200, 120);//画向下一个点
        path.lineTo(100, 200);
        path.close();//闭合
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
        //绘制文本
        paint.setTextSize(12);
        paint.setColor(Color.BLUE);
        paint.setStrikeThruText(true);
        canvas.drawText("hello world", 10, 200, paint);
        Path pathText=new Path();
        pathText.addCircle(200,300,80, Path.Direction.CCW);
        canvas.drawTextOnPath("Draw the text, with origin at (x,y), using the specified paint, along the specified path.",
                pathText,0,10,paint);
    }
}
