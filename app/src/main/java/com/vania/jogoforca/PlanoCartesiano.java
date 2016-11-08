package com.vania.jogoforca;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by vania on 07/11/16.
 */

public class PlanoCartesiano extends View {

    //armazena o menor lado do display. Caso o display seja maior na vertical
    //a varivel guarda o valor da horizontal, do contrario guarda o valor da
    // domensao da tela na vertical
    private int menorLadoDiplay;
    //menor lado do display dividido por 10 - 1/10 do tamanho da tela
    private int unidade;

    public PlanoCartesiano(Context context) {
        super(context);
    }

    public PlanoCartesiano(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void drawPlanoCartesiano(Canvas canvas){

        Path path = new Path();//caminhos que quero desenhar

        int max = toPixal(10);
        for (int n = 0; n <= 10; n++){
            //desenha as linhas n vertcal
            path.moveTo(toPixal(n), 1);
            path.lineTo(toPixal(n), max);
            //desenha as lnhas na horizontal
            path.moveTo(1, toPixal(n));
            path.lineTo(max, toPixal(n));
        }

        Paint paint = new Paint();
        paint.setAntiAlias(true);//propriedade que define a suavidade da linha
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(1);

        canvas.drawPath(path, paint);

    }

    public int toPixal(int vezes) {
        return vezes * getUnidade();
    }

    @Override
    protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

        if(getHeight() > getWidth()){
            setMenorLadoDiplay(getWidth());
        } else {
            setMenorLadoDiplay(getHeight());
        }
        setUnidade(getMenorLadoDiplay()/10);

        drawPlanoCartesiano(canvas);
    }

    public int getMenorLadoDiplay() {
        return menorLadoDiplay;
    }

    public void setMenorLadoDiplay(int menorLadoDiplay) {
        this.menorLadoDiplay = menorLadoDiplay;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }
}
