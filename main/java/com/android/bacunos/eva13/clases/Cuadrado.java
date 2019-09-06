package com.android.bacunos.eva13.clases;

public class Cuadrado {

    public double getPerimetro(double lado){
        return 4 * lado;
    }

    public double getArea(double lado){
        return lado * lado;
    }

    public double getDiagonal(double lado){
        return Math.sqrt(2*lado);
    }
}
