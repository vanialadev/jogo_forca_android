package com.vania.jogoforca;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
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

        canvas.drawLine(0, 0, 100, 100, new Paint());
    }
}
