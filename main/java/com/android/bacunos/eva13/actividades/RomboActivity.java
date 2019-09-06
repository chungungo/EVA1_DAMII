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
import com.android.bacunos.eva13.clases.Rombo;

public class RomboActivity extends AppCompatActivity {

    private Button btnCalcular;
    private Button btnLimpiar;
    private Button btnSelRombo;
    private TextView numLado1;
    private TextView numLado2;
    private TextView numLado;
    private Spinner spiner;
    private TextView resultado;
    private String seleccion;
    private TextView mensaje;

    double lado = 0;
    double valorLado1 = 0;
    double valorLado2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rombo);
        btnCalcular = findViewById(R.id.btn_calRombo);
        btnLimpiar = findViewById(R.id.btn_limpiarRombo);
        numLado1 = findViewById(R.id.et_numDiagonal);
        numLado2 = findViewById(R.id.et_numdiagonal);
        numLado = findViewById(R.id.et_numLadoDiag);
        spiner = findViewById(R.id.sp_rombo);
        resultado = findViewById(R.id.et_resultadoRombo);
        btnSelRombo = findViewById(R.id.btn_selRombo);
        mensaje = findViewById(R.id.et_mensaje);

        findViewById(R.id.et_numDiagonal).setVisibility(View.VISIBLE);
        findViewById(R.id.et_numLadoDiag).setVisibility(View.INVISIBLE);
        findViewById(R.id.et_numdiagonal).setVisibility(View.VISIBLE);

        String[] opciones = {"Area", "Perimetro", "Diagonal"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spiner.setAdapter(adapter);
        mensaje.setText("Cálculo de Área");
    }

    public void esconder(View view){
        seleccion = spiner.getSelectedItem().toString();
        resultado.setText("");
        if (seleccion.equals("Area")) {
            findViewById(R.id.et_numDiagonal).setVisibility(View.VISIBLE);
            findViewById(R.id.et_numLadoDiag).setVisibility(View.INVISIBLE);
            findViewById(R.id.et_numdiagonal).setVisibility(View.VISIBLE);
            mensaje.setText("Cálculo de Área");
        }
        if (seleccion.equals("Perimetro")) {
            findViewById(R.id.et_numDiagonal).setVisibility(View.INVISIBLE);
            findViewById(R.id.et_numLadoDiag).setVisibility(View.VISIBLE);
            findViewById(R.id.et_numdiagonal).setVisibility(View.INVISIBLE);
            mensaje.setText("Cálculo de Perímetro");
        }
        if (seleccion.equals("Diagonal")) {
            findViewById(R.id.et_numDiagonal).setVisibility(View.INVISIBLE);
            findViewById(R.id.et_numLadoDiag).setVisibility(View.VISIBLE);
            findViewById(R.id.et_numdiagonal).setVisibility(View.VISIBLE);
            mensaje.setText("Cálculo de Diagonal");
        }
    }

    public void limpiar(View view){
        numLado1.setText("");
        numLado2.setText("");
        numLado.setText("");
        resultado.setText("");
    }

    public void calcular(View view){
        Rombo rombo = new Rombo();

        try {
            seleccion = spiner.getSelectedItem().toString();

            switch(seleccion){
                case "Area":
                    valorLado1 = Double.parseDouble(numLado1.getText().toString());
                    valorLado2 = Double.parseDouble(numLado2.getText().toString());
                    resultado.setText(String.valueOf(rombo.getArea(valorLado1, valorLado2)));
                    break;

                case "Perimetro":
                    lado = Double.parseDouble(numLado.getText().toString());
                    resultado.setText(String.valueOf(rombo.getPerimetro(lado)));
                    break;

                case "Diagonal":
                    valorLado2 = Double.parseDouble(numLado2.getText().toString());
                    lado = Double.parseDouble(numLado.getText().toString());
                    resultado.setText(String.valueOf(rombo.getDiagonal(lado, valorLado2)));
                    break;
            }
        }catch(Exception ex){
            Toast.makeText(this,"Debe ingresar solo números", Toast.LENGTH_LONG).show();
        }
    }

}
