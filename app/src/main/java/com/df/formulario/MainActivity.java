package com.df.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ib.custom.toast.CustomToastView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button btnEnviar;
private EditText txtNombre;
private EditText txtApellido;
private EditText txtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar = findViewById(R.id.btnEnviar);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEmail = findViewById(R.id.txtEmail);
        btnEnviar.setOnClickListener(this);

        }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnEnviar){
            String Nombre = txtNombre.getText().toString();
            String  Apellido = txtApellido.getText().toString();
            String Email = txtEmail.getText().toString();
            if  (Nombre.isEmpty()){
                CustomToastView.makeErrorToast(this,"ERROR AL VALIDAR NOMBRE",R.layout.custom_toast).show();
                return;
            }
            if  (Apellido.isEmpty()) {
                CustomToastView.makeInfoToast(this,"ERROR AL VALIDAR APELLIDO",R.layout.custom_toast).show();
                return;
            }
            if  (!isValidEmail(Email)) {
                CustomToastView.makeWarningToast(this,"ERROR AL VALIDAR CORREO",R.layout.custom_toast).show();
                return;
            }
            Intent myIntent = new Intent(this, CalcularImc.class);
            myIntent.putExtra("NombreCalculadora",Nombre);
            myIntent.putExtra("ApellidoCalculadora",Apellido);
            myIntent.putExtra("EmailCalculadora",Email);


            startActivity(myIntent);

        }
    }
    private Boolean isValidEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();

    }
}