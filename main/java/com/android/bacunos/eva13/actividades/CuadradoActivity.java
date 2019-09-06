package com.android.bacunos.eva13.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.bacunos.eva13.R;
import com.android.bacunos.eva13.clases.Circulo;
import com.android.bacunos.eva13.clases.Cuadrado;

public class CuadradoActivity extends AppCompatActivity {

    private Button btnCalcular;
    private Button btnLimpiar;
    private TextView numLado;
    private Spinner spiner;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);

        btnCalcular = findViewById(R.id.btn_calCuadrado);
        btnLimpiar = findViewById(R.id.btn_limpiarCuadrado);
        numLado = findViewById(R.id.et_numLado);
        spiner = findViewById(R.id.sp_cuadrado);
        resultado = findViewById(R.id.et_resultadoCuadrado);

        String[] opciones = {"Area", "Perimetro", "Diagonal"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spiner.setAdapter(adapter);

    }

    public void limpiar(View view){
        numLado.setText("");
        resultado.setText("");
    }

    public void calcular(View view){
        Cuadrado cuadrado = new Cuadrado();
        try {
            double valorLado = Double.parseDouble(numLado.getText().toString());
            String seleccion = spiner.getSelectedItem().toString();
            switch(seleccion){
                case "Area":
                    resultado.setText(String.valueOf(cuadrado.getArea(valorLado)));
                    break;

                case "Perimetro":
                    resultado.setText(String.valueOf(cuadrado.getPerimetro(valorLado)));
                    break;

                case "Diagonal":
                    resultado.setText(String.valueOf(cuadrado.getDiagonal(valorLado)));
                    break;

            }

        }catch(Exception ex){
            Toast.makeText(this,"Debe ingresar solo números", Toast.LENGTH_LONG).show();
        }
    }

}
