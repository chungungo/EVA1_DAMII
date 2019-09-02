package com.android.bacunos.eva1;

public class Rectangulo {

    public double getPerimetro(double ladoA, double ladoB){
        return 2 * (ladoB + ladoA);
    }

    public double getArea(double ladoA, double ladoB){
        return ladoB * ladoA;
    }

    public double getDiagonal(double ladoA, double ladoB){
        return Math.sqrt((ladoA * ladoA) + (ladoB * ladoB));
    }
}
