package com.df.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalcularImc extends AppCompatActivity implements View.OnClickListener {
private TextView tvInformacion;
private EditText txtPeso;
private EditText txtAltura;
private Button btnCalcular;
private ImageView imgEstado;
private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_imc);
        Intent intent = getIntent();
        String Nombre = intent.getStringExtra("NombreCalculadora");
        String  Apellido = intent.getStringExtra("ApellidoCalculadora");
        String  Email = intent.getStringExtra("EmailCalculadora");
        String message = "Hola "+ Nombre + " " + Apellido + " Es un gusto tener su correo  para el informe es: " + Email;
        tvInformacion = findViewById(R.id.tvInformacion);
        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        imgEstado = findViewById(R.id.imgEstado);
        tvResultado = findViewById(R.id.tvResultado);
        tvInformacion.setText(message);
        btnCalcular.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcular){
           double altura = Double.parseDouble(txtAltura.getText().toString());
           double peso = Double.parseDouble(txtPeso.getText().toString());
           double imc = peso/Math.pow(altura,2);
            DecimalFormat decimal = new DecimalFormat("#.00");

           if (imc<18.5){
               tvResultado.setText("SU IMC ES: "+ decimal.format(imc) + "\n BAJO PESO");
               imgEstado.setImageResource(R.drawable.bajo_peso);
           }
           else if (imc<25){
               tvResultado.setText("SU IMC ES: "+ decimal.format(imc) + "\nPESO NORMAL");
               imgEstado.setImageResource(R.drawable.peso_normal);
            }
           else if (imc<30){
               tvResultado.setText("SU IMC ES: "+ decimal.format(imc) + "\nSOBREPESO");
               imgEstado.setImageResource(R.drawable.sobrepeso);
           }
           else if (imc<35){
               tvResultado.setText("SU IMC ES: "+ decimal.format(imc) + "\nOBECIDAD");
               imgEstado.setImageResource(R.drawable.obesidad);
           }
           else if (imc>=35) {
               tvResultado.setText("SU IMC ES: " + decimal.format(imc) + "\nOBECIDAD EXTREMA");
               imgEstado.setImageResource(R.drawable.obesidad_extrema);
           }



        }
    }
}