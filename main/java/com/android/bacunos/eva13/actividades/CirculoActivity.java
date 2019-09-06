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

import org.w3c.dom.Text;

public class CirculoActivity extends AppCompatActivity {

    private Button btnCalcular;
    private Button btnLimpiar;
    private TextView numRadio;
    private Spinner spiner;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);

        btnCalcular = findViewById(R.id.btn_calCirculo);
        btnLimpiar = findViewById(R.id.btn_limpiarCirculo);
        numRadio = findViewById(R.id.et_numCirRadio);
        spiner = findViewById(R.id.sp_circulo);
        resultado = findViewById(R.id.et_resultadoCirculo);

        String[] opciones = {"Area", "Perimetro", "Diametro"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spiner.setAdapter(adapter);

    }

    public void limpiar(View view){
        numRadio.setText("");
        resultado.setText("");
    }

    public void calcular(View view){
        Circulo circulo = new Circulo();
        try {
            double valorRadio = Double.parseDouble(numRadio.getText().toString());
            String seleccion = spiner.getSelectedItem().toString();
            switch(seleccion){
                case "Area":
                    resultado.setText(String.valueOf(circulo.getArea(valorRadio)));
                    break;

                case "Perimetro":
                    resultado.setText(String.valueOf(circulo.getPerimetro(valorRadio)));
                    break;

                case "Diametro":
                    resultado.setText(String.valueOf(circulo.getDiametro(valorRadio)));
                    break;

            }

        }catch(Exception ex){
            Toast.makeText(this,"Debe ingresar solo números", Toast.LENGTH_LONG).show();
        }
    }
}
