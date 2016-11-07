package com.vania.jogoforca;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by vania on 06/11/16.
 */

public class EstudoView extends View {

    public EstudoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EstudoView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        desenhaLinha(canvas);

        desenhaRetangulo(canvas);
    }

    private void desenhaRetangulo(Canvas canvas) {
        canvas.drawRect(new Rect(200, 200, 300, 300), new Paint());
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        canvas.drawLine(200, 200,300,300, paint);

        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);

        for (int i = 1; i <= 20; i++){
            canvas.drawRect(300 + (i * 20 * -1), 300 + (i * 20 * -1), 400 + (i * 20), 400 + (i * 20), paint);
        }
    }

    private void desenhaLinha(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(0);
        paint.setColor(Color.RED);

        for (int n = 1; n <= 20; n++){
            paint.setStrokeWidth(n);
            canvas.drawLine(50, n*20, 100, n*20, paint);
        }
    }


}
