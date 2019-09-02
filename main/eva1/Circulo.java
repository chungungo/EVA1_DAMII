package com.android.bacunos.eva1;

public class Circulo {

    public double getArea(double radio){
        return Math.PI * (radio * radio);
    }


    public double getPerimetro(double radio){
        return 2 * Math.PI * radio;
    }


    public double getDiametro(double radio){
        return radio * 2;
    }
}
