package com.lunijami.nodehood;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lunijami.nodehood.modelo.AccesoDatos;
import com.lunijami.nodehood.modelo.Ecriptador;
import com.lunijami.nodehood.modelo.entidades.Pedido;
import com.lunijami.nodehood.modelo.entidades.Usuario;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity implements
        View.OnClickListener {

    private TextView mCancelButton;
    private Button mRegistroButton;
    private EditText nombre;
    private EditText email;
    private EditText passwd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mCancelButton = findViewById(R.id.buttonCancel);
        mRegistroButton = findViewById(R.id.buttonRegisterConfirm);
        nombre = findViewById(R.id.editRegisterPersonName);
        email = findViewById(R.id.editRegisterEmailAddress);
        passwd = findViewById(R.id.editPassword);

        mRegistroButton.setOnClickListener(this);
        mCancelButton.setOnClickListener(this);

    }


    public void volverLogin() {
        Intent intent = new Intent(RegisterActivity
                .this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void registrarUsuario() {
        String nom = nombre.getText().toString();
        String eml = email.getText().toString();
        String passw = Ecriptador.hasearPwd(passwd.getText().toString());
        Usuario user = new Usuario(nom, eml, passw);
        AccesoDatos.registrarUsuario(user);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonCancel:
                volverLogin();
                break;
            case R.id.buttonRegisterConfirm:
                registrarUsuario();
                volverLogin();
                break;

        }

    }
}