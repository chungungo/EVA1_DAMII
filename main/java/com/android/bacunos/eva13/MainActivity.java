package com.android.bacunos.eva13;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.android.bacunos.eva13.actividades.AcercaActivity;
import com.android.bacunos.eva13.actividades.CirculoActivity;
import com.android.bacunos.eva13.actividades.CuadradoActivity;
import com.android.bacunos.eva13.actividades.RectanguloActivity;
import com.android.bacunos.eva13.actividades.RomboActivity;
import com.android.bacunos.eva13.actividades.TrianguloActivity;

public class MainActivity extends AppCompatActivity {

    private ImageButton btn_circulo;
    private ImageButton btn_cuadrado;
    private ImageButton btn_rectangulo;
    private ImageButton btn_triangulo;
    private ImageButton btn_rombo;
    private ImageButton btn_nosotros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        esconderBotones();

        btn_circulo = findViewById(R.id.btn_circulo);
        btn_cuadrado = findViewById(R.id.btn_cuadrado);
        btn_rectangulo = findViewById(R.id.btn_rectangulo);
        btn_triangulo = findViewById(R.id.btn_triangulo);
        btn_rombo = findViewById(R.id.btn_rombo);
        btn_nosotros = findViewById(R.id.btn_nosotros);


        btn_cuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irA(CuadradoActivity.class);
            }
        });

        btn_rectangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irA(RectanguloActivity.class);
            }
        });

        btn_circulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irA(CirculoActivity.class);
            }
        });

        btn_triangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irA(TrianguloActivity.class);
            }
        });

        btn_rombo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irA(RomboActivity.class);
            }
        });

        btn_nosotros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irA(AcercaActivity.class);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.et_bienvenida).setVisibility(View.INVISIBLE);
                mostrarBotones();
            }
        }, 2000);

    }

    private void esconderBotones(){
        findViewById(R.id.btn_circulo).setVisibility(View.INVISIBLE);
        findViewById(R.id.btn_cuadrado).setVisibility(View.INVISIBLE);
        findViewById(R.id.btn_rectangulo).setVisibility(View.INVISIBLE);
        findViewById(R.id.btn_rombo).setVisibility(View.INVISIBLE);
        findViewById(R.id.btn_triangulo).setVisibility(View.INVISIBLE);
        findViewById(R.id.et_titulo).setVisibility(View.INVISIBLE);
        findViewById(R.id.et_cuadrado).setVisibility(View.INVISIBLE);
        findViewById(R.id.et_rectangulo).setVisibility(View.INVISIBLE);
        findViewById(R.id.et_triangulo).setVisibility(View.INVISIBLE);
        findViewById(R.id.et_circulo).setVisibility(View.INVISIBLE);
        findViewById(R.id.et_rombo).setVisibility(View.INVISIBLE);
        findViewById(R.id.et_nosotros).setVisibility(View.INVISIBLE);
        findViewById(R.id.btn_nosotros).setVisibility(View.INVISIBLE);
    }

    private void mostrarBotones(){
        findViewById(R.id.btn_circulo).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_cuadrado).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_rectangulo).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_rombo).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_triangulo).setVisibility(View.VISIBLE);
        findViewById(R.id.et_titulo).setVisibility(View.VISIBLE);
        findViewById(R.id.et_cuadrado).setVisibility(View.VISIBLE);
        findViewById(R.id.et_rectangulo).setVisibility(View.VISIBLE);
        findViewById(R.id.et_triangulo).setVisibility(View.VISIBLE);
        findViewById(R.id.et_circulo).setVisibility(View.VISIBLE);
        findViewById(R.id.et_rombo).setVisibility(View.VISIBLE);
        findViewById(R.id.et_nosotros).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_nosotros).setVisibility(View.VISIBLE);
    }

    private void irA(Class clase){
        Intent intent = new Intent(this, clase);
        startActivity(intent);
    }

}
