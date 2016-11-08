package com.vania.jogoforca;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

/**
 * Created by vania on 07/11/16.
 */

public class ForcaView extends PlanoCartesiano {

    //responsável por amarzenar todas as figuras geometricas a serem desenhadas
    private Path pathForca;
    private Paint paintForca;
    private enum Membro{braco, perna}
    private enum Lado{esquerdo ,direito}
    private ForcaController forcaController;

    public ForcaView(Context context) {
        super(context);
    }

    public ForcaView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setPathForca(new Path());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        getPathForca().moveTo(toPixal(1), toPixal(2));
//        getPathForca().lineTo(toPixal(10), toPixal(2));

        plotaArmacaoDaForca();
        plotaCabeca();
        plotaCorpo();
        plotaMembro(Membro.braco, Lado.direito);
        plotaMembro(Membro.braco, Lado.esquerdo);
        plotaMembro(Membro.perna, Lado.direito);
        plotaMembro(Membro.perna, Lado.esquerdo);

        plotaTracos();
        drawLetrasCorretas(canvas);

        canvas.drawPath(getPathForca(), getPaintForca());



    }

    private void plotaArmacaoDaForca(){

        //desenhando a base
        getPathForca().moveTo(toPixel(1), toPixel(10));
        getPathForca().lineTo(toPixel(3), toPixel(10));
        //desenhando a haste
        getPathForca().moveTo(toPixel(2), toPixel(10));
        getPathForca().lineTo(toPixel(2), toPixel(1));
        // agora posso so seguir vom a linha, atraves de outro mtodo - diz quntas 'casas' eu vou andar
        getPathForca().rLineTo(toPixel(5), 0);
        getPathForca().rLineTo(0, toPixel(1));


    }

    private void plotaCabeca(){
        getPathForca().addCircle(toPixel(7), toPixel(3), toPixel(1), Path.Direction.CW);
    }


    private void plotaCorpo(){
        getPathForca().moveTo(toPixel(7), toPixel(4));
        getPathForca().lineTo(toPixel(7), toPixel(7));
    }

    private void plotaMembro(Membro membro, Lado lado){
        final int posDoCorpo = 7;
        final int alturaDoBraco = 5;
        final int alturaDaPerna = 7;
        int alturaFinal;

        if (membro == Membro.braco){
            getPathForca().moveTo(toPixel(posDoCorpo), toPixel(alturaDoBraco));
            alturaFinal = alturaDoBraco + 1;
        }else {
            getPathForca().moveTo(toPixel(posDoCorpo), toPixel(alturaDaPerna));
            alturaFinal = alturaDaPerna + 1;

        }

        if (lado == Lado.direito){
            getPathForca().lineTo(toPixel(posDoCorpo + 1), toPixel(alturaFinal));
        }else {
            getPathForca().lineTo(toPixel(posDoCorpo - 1), toPixel(alturaFinal));
        }

    }


    public Paint getPaintForca() {

        paintForca = new Paint();
        paintForca.setColor(Color.BLACK);
        paintForca.setStrokeWidth(8);
        paintForca.setStyle(Paint.Style.STROKE);

        return paintForca;
    }

    private void plotaTracos(){
        int eixoX = toPixel(3);
        getPathForca().moveTo(eixoX+15, toPixel(10));

        if(getForcaController() == null){
            return;
        }

        for(int i = 0; i < getForcaController().getPalavraAteAgora().length() - 1; i++){

            getPathForca().rMoveTo(10, 0);
            getPathForca().rLineTo(toPixel(1), 0);
        }
    }

    private Paint getPaintTraco(){
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        paint.setTextSize(60);
        return paint;
    }


    private void drawLetrasCorretas(Canvas canvas) {
        int eixoX = toPixel(3);
        getPathForca().moveTo( eixoX + 10, toPixel(10) );
        eixoX+=35;

        if (getForcaController() != null){
            for (int i = 0; i <= getForcaController().getPalavraAteAgora().length()-1; i++) {
                char c = getForcaController().getPalavraAteAgora().charAt(i);
                canvas.drawText(c + "", eixoX + ((toPixel(1) + 10) * i),(toPixel(10)) - 15,
                        getPaintTraco());
            }
        }
    }


    public Path getPathForca() {
        return pathForca;
    }

    public void setPathForca(Path pathForca) {
        this.pathForca = pathForca;
    }

    public ForcaController getForcaController() {
        return forcaController;
    }

    public void setForcaController(ForcaController forcaController) {
        this.forcaController = forcaController;
    }
}
