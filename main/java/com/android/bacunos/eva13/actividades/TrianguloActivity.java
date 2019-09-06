package com.android.bacunos.eva13.actividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.bacunos.eva13.R;
import com.android.bacunos.eva13.clases.Triangulo;

public class TrianguloActivity extends AppCompatActivity {

    private Button btnCalcular;
    private Button btnLimpiar;
    private RadioButton btnEquilatero;
    private RadioButton btnIsosceles;
    private RadioButton btnEscaleno;
    private RadioButton btnTengoLaH;
    private RadioButton btnPerimetro;
    private TextView dato1;
    private TextView dato2;
    private TextView dato3;
    private TextView ladoA;
    private TextView ladoB;
    private TextView ladoC;
    private TextView etDato1;
    private TextView etDato2;
    private TextView etDato3;

    private TextView resultadoP;
    private TextView resultadoSP;
    private TextView resultadoA;
    private TextView text8;
    private TextView text9;
    private TextView text10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        btnCalcular = findViewById(R.id.btn_calTriangulo);
        btnLimpiar = findViewById(R.id.btn_limpiarTrian);
        dato1 = findViewById(R.id.et_numTrian1);
        dato2 = findViewById(R.id.et_numTrian2);
        dato3 = findViewById(R.id.et_numTrian3);
        ladoA = findViewById(R.id.et_numTrianA);
        ladoB = findViewById(R.id.et_numTrianB);
        ladoC = findViewById(R.id.et_numTrianC);
        etDato1 = findViewById(R.id.et_dato1);
        etDato2 = findViewById(R.id.et_dato2);
        resultadoP = findViewById(R.id.et_resultadoPTrian);
        resultadoSP = findViewById(R.id.et_resultadoSPTrian);
        resultadoA = findViewById(R.id.et_resultadoATrian);
        btnEquilatero = findViewById(R.id.rb_equilatero);
        btnIsosceles = findViewById(R.id.rb_isosceles);
        btnEscaleno = findViewById(R.id.rb_escaleno);
        btnTengoLaH = findViewById(R.id.rb_tengoLaAltura);
        btnPerimetro = findViewById(R.id.rb_perimetroTrian);
        etDato3 = findViewById(R.id.et_dato3);

        findViewById(R.id.rb_equilatero).setSelected(true);

        btnEquilatero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDato1.setText("Lado:");
                etDato2.setVisibility(View.INVISIBLE);
                dato2.setVisibility(View.INVISIBLE);
                etDato3.setVisibility(View.INVISIBLE);
                dato3.setVisibility(View.INVISIBLE);
            }
        });

        btnIsosceles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDato1.setText("Lados =:");
                etDato2.setText("Base:");
                etDato2.setVisibility(View.VISIBLE);
                etDato3.setVisibility(View.INVISIBLE);
                dato3.setVisibility(View.INVISIBLE);
            }
        });

        btnEscaleno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDato2.setVisibility(View.VISIBLE);
                etDato3.setVisibility(View.VISIBLE);
                dato3.setVisibility(View.VISIBLE);
                etDato1.setText("Lado A:");
                etDato2.setText("Lado B:");
                etDato2.setText("Lado C:");
            }
        });

        btnTengoLaH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etDato2.setVisibility(View.VISIBLE);
                etDato3.setVisibility(View.INVISIBLE);
                dato3.setVisibility(View.INVISIBLE);
                etDato1.setText("Base:");
                etDato2.setText("Altura:");
            }
        });

    }

    public void calcular(View view){
        double resultado = 0.0;
        double resultadoPer = 0.0;
        double resultadoSemiPer = 0.0;
        Triangulo triangulo = new Triangulo();

        if(btnEquilatero.isChecked()){
            try{
                resultado = triangulo.getAreaEquilatero(Double.parseDouble(dato1.getText().toString()));
                resultadoA.setText(String.valueOf(resultado));
            }catch(Exception ex){
                Toast.makeText(this,"Debe ingresar solo números", Toast.LENGTH_LONG).show();
            }
        }
        if(btnIsosceles.isChecked()){
            try{

                resultado = triangulo.getAreaIsosceles(Double.parseDouble(dato1.getText().toString()), Double.parseDouble(dato2.getText().toString()));
                resultadoA.setText(String.valueOf(resultado));

            }catch(Exception ex){
                Toast.makeText(this,"Debe ingresar solo números", Toast.LENGTH_LONG).show();
            }
        }

        if(btnEscaleno.isChecked()){
            try{
                resultado = triangulo.getAreaEscaleno(Double.parseDouble(dato1.getText().toString()), Double.parseDouble(dato2.getText().toString()), Double.parseDouble(dato3.getText().toString()));
                resultadoA.setText(String.valueOf(resultado));

            }catch(Exception ex){
                Toast.makeText(this,"Debe ingresar solo números", Toast.LENGTH_LONG).show();
            }
        }

        if(btnTengoLaH.isChecked()){
            try{
                resultado = triangulo.getArea(Double.parseDouble(dato1.getText().toString()), Double.parseDouble(dato2.getText().toString()));
                resultadoA.setText(String.valueOf(resultado));

            }catch(Exception ex){
                Toast.makeText(this,"Debe ingresar solo números", Toast.LENGTH_LONG).show();
            }
        }

        if(btnPerimetro.isChecked()){
            try{
                resultadoPer = triangulo.getPerimetro(Double.parseDouble(ladoA.getText().toString()), Double.parseDouble(ladoB.getText().toString()), Double.parseDouble(ladoC.getText().toString()));
                resultadoP.setText(String.valueOf(resultadoPer));

                resultadoSemiPer = resultadoPer / 2;
                resultadoSP.setText(String.valueOf(resultadoSemiPer));

            }catch(Exception ex){
                Toast.makeText(this,"Debe ingresar solo números", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void limpiar(View view){
        dato1.setText("");
        dato2.setText("");
        ladoA.setText("");
        ladoB.setText("");
        ladoC.setText("");
        resultadoSP.setText("");
        resultadoP.setText("");
        resultadoA.setText("");
    }
}
