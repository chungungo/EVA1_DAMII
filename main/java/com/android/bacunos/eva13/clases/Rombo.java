package com.android.bacunos.eva13.clases;

public class Rombo {

    public double getArea(double Diagonal, double diagonal){
        return (Diagonal * diagonal) / 2;
    }


    public double getPerimetro(double lado){
        return 4 * lado;
    }


    public double getDiagonal(double lado, double diagonal){
        return Math.sqrt(Math.pow(lado, 2) - Math.pow((diagonal / 2), 2) * 2);
    }
}
