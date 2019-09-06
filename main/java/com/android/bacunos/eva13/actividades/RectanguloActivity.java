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
import com.android.bacunos.eva13.clases.Rectangulo;

public class RectanguloActivity extends AppCompatActivity {

    private Button btnCalcular;
    private Button btnLimpiar;
    private TextView numLado1;
    private TextView numLado2;
    private Spinner spiner;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        btnCalcular = findViewById(R.id.btn_calRectangulo);
        btnLimpiar = findViewById(R.id.btn_limpiarRectangulo);
        numLado1 = findViewById(R.id.et_numLadoRec1);
        numLado2 = findViewById(R.id.et_numLadoRec2);
        spiner = findViewById(R.id.sp_rectangulo);
        resultado = findViewById(R.id.et_resultadoRectangulo);

        String[] opciones = {"Area", "Perimetro", "Diagonal"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spiner.setAdapter(adapter);
    }

    public void limpiar(View view){
        numLado1.setText("");
        numLado2.setText("");
        resultado.setText("");
    }

    public void calcular(View view){
        Rectangulo cuadrado = new Rectangulo();
        try {
            double valorLado1 = Double.parseDouble(numLado1.getText().toString());
            double valorLado2 = Double.parseDouble(numLado2.getText().toString());
            String seleccion = spiner.getSelectedItem().toString();
            switch(seleccion){
                case "Area":
                    resultado.setText(String.valueOf(cuadrado.getArea(valorLado1, valorLado2)));
                    break;

                case "Perimetro":
                    resultado.setText(String.valueOf(cuadrado.getPerimetro(valorLado1, valorLado2)));
                    break;

                case "Diagonal":
                    resultado.setText(String.valueOf(cuadrado.getDiagonal(valorLado1, valorLado2)));
                    break;
            }

        }catch(Exception ex){
            Toast.makeText(this,"Debe ingresar solo números", Toast.LENGTH_LONG).show();
        }
    }

}
