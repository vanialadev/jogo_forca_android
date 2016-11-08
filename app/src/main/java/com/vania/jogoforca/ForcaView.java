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

        canvas.drawPath(getPathForca(), getPaintForca());

    }

    private void plotaArmacaoDaForca(){

        //desenhando a base
        getPathForca().moveTo(toPixal(1), toPixal(10));
        getPathForca().lineTo(toPixal(3), toPixal(10));
        //desenhando a haste
        getPathForca().moveTo(toPixal(2), toPixal(10));
        getPathForca().lineTo(toPixal(2), toPixal(1));
        // agora posso so seguir vom a linha, atraves de outro mtodo - diz quntas 'casas' eu vou andar
        getPathForca().rLineTo(toPixal(5), 0);
        getPathForca().rLineTo(0, toPixal(1));


    }

    private void plotaCabeca(){
        getPathForca().addCircle(toPixal(7), toPixal(3), toPixal(1), Path.Direction.CW);
    }


    private void plotaCorpo(){
        getPathForca().moveTo(toPixal(7), toPixal(4));
        getPathForca().lineTo(toPixal(7), toPixal(7));
    }

    private void plotaMembro(Membro membro, Lado lado){
        final int posDoCorpo = 7;
        final int alturaDoBraco = 5;
        final int alturaDaPerna = 7;
        int alturaFinal;

        if (membro == Membro.braco){
            getPathForca().moveTo(toPixal(posDoCorpo), toPixal(alturaDoBraco));
            alturaFinal = alturaDoBraco + 1;
        }else {
            getPathForca().moveTo(toPixal(posDoCorpo), toPixal(alturaDaPerna));
            alturaFinal = alturaDaPerna + 1;

        }

        if (lado == Lado.direito){
            getPathForca().lineTo(toPixal(posDoCorpo + 1), toPixal(alturaFinal));
        }else {
            getPathForca().lineTo(toPixal(posDoCorpo - 1), toPixal(alturaFinal));
        }

    }


    public Paint getPaintForca() {

        paintForca = new Paint();
        paintForca.setColor(Color.BLACK);
        paintForca.setStrokeWidth(8);
        paintForca.setStyle(Paint.Style.STROKE);

        return paintForca;
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
