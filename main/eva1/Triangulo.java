package com.android.bacunos.eva1;

public class Triangulo {

    public double getArea(double base, double altura){
        return (base * altura) / 2;
    }


    public double getAreaIsosceles(double ladoA, double ladoB){
        return (ladoB * Math.sqrt(Math.pow(ladoA, 2) - (Math.pow(ladoB, 2) / 4))) / 2;
    }


    public double getAreaEquilatero(double ladoA){
        return (Math.cbrt(3) / 4) * Math.pow(ladoA, 2);
    }


    public double getAreaEscaleno(double ladoA, double ladoB, double ladoC){
        double s = getSemiperimetro(ladoA,ladoB, ladoC);
        return Math.sqrt(s * (s-ladoA) * (s-ladoB) * (s-ladoC));
    }


    public double getPerimetro(double ladoA, double ladoB, double ladoC){
        return ladoA + ladoB + ladoC;
    }


    public double getSemiperimetro(double ladoA, double ladoB, double ladoC){
        return (ladoA + ladoB + ladoC) / 2;
    }
}
