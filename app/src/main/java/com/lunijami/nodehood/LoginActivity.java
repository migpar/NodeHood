package com.lunijami.nodehood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.lunijami.nodehood.modelo.AccesoDatos;
import com.lunijami.nodehood.modelo.Ecriptador;
import com.lunijami.nodehood.modelo.entidades.Usuario;

import java.util.Objects;

/**
 * Ingreso en la APP via google sacado del codigo de comunify
 */
public class LoginActivity extends AppCompatActivity implements
        View.OnClickListener, AccesoDatos.Actualizacion {
    protected Button mLoginButton;
    protected TextView mRegisterButton;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private final String TAG = "SignInActivity";
    private final int RC_SIGN_IN = 9002;
    private TextView mStatusTextView;
    private EditText email;
    private TextInputLayout passwd;
    private final AccesoDatos.Actualizacion a = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginButton = (Button) findViewById(R.id.buttonLogin);
        mRegisterButton = findViewById(R.id.buttonRegister);
        mRegisterButton.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
        email = findViewById(R.id.editTextEmail);
        passwd = findViewById(R.id.text_input_layout_pass);

        // en el oncreate
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // Views
        mStatusTextView = findViewById(R.id.status);

        //Configuracion de login con Google.
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        // Cliente
        // Cree un GoogleSignInClient con las opciones especificadas por gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // Button listeners
        findViewById(R.id.sign_in_button).setOnClickListener(this);
        //findViewById(R.id.disconnect_button).setOnClickListener(this);


        //opciones del boton de Google

        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setColorScheme(SignInButton.COLOR_LIGHT);

        //Fin del oncreate

    }


    @Override
    public void onStart() {
        super.onStart();

        // INICIO on_start_sign_in
        // Compruebe la cuenta de inicio de sesión de Google existente, si el usuario ya ha iniciado sesión
        // GoogleSignInAccount no será nulo.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
        // END on_start_sign_in
    }

    // INICIO en Resultado de actividad
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Resultado devuelto al iniciar Intent desde GoogleSignInClient.getSignInIntent (...);
        if (requestCode == RC_SIGN_IN) {
            // La tarea devuelta de esta llamada siempre se completa, no es necesario adjuntar
            // un oyente

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    //FIN del resultado de la actividad

    //INICIO manejar Inicio sesión del Resultado
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            //AQUI ESTA EL FALLO
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            //AQUI ESTA EL FALLO
            // Se registró correctamente, muestra la interfaz de usuario autenticada.
            updateUI(account);
        } catch (ApiException e) {
            // El código de estado de ApiException indica el motivo detallado del error.
            // Consulte la referencia de la clase GoogleSignInStatusCodes para obtener más información.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }
    // Final

    // Inico signIn
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    // Final signIn


    // Inicio acceso revocado
    public void revokeAccess() {
        mGoogleSignInClient.revokeAccess()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // Inicio Excluido
                        updateUI(null);
                        // Fin Excluido
                    }
                });
    }
    // Fin acceso revocado

    //Comprueba si estas conectado
    public void updateUI(@Nullable GoogleSignInAccount account) {
        if (account != null) {
            mStatusTextView.setText(getString(R.string.signed_in_fmt, account.getDisplayName()));
            ((TextView) findViewById(R.id.status)).setText(R.string.signed_in);
            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
            //findViewById(R.id.disconnect_button).setVisibility(View.VISIBLE);

            Intent intent = new Intent(LoginActivity
                    .this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        } else {
            mStatusTextView.setText(R.string.signed_out);
            Log.d("pruebas", "no logea");
            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
            //findViewById(R.id.disconnect_button).setVisibility(View.GONE);
            ((TextView) findViewById(R.id.status)).setText(R.string.signed_out);
        }

    }

    public void comprobarUsuario(){
        AccesoDatos.getUsuario(email.getText().toString().replace('.', '>'), a);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;
            case R.id.buttonLogin:
                    comprobarUsuario();
                break;
            case R.id.buttonRegister:
                Intent intentRegister = new Intent(LoginActivity
                        .this, RegisterActivity.class);
                intentRegister.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentRegister.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentRegister);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void recuperarDatos(Usuario user) {
        String pwd = Ecriptador.hasearPwd(Objects.requireNonNull(passwd.getEditText()).getText().toString());

        if(user != null && user.getContraseña().equals(pwd) && user.getEmail().equals(email.getText().toString())) {
            Intent intentLogin = new Intent(LoginActivity
                    .this, MainActivity.class);
            intentLogin.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intentLogin);
        } else{
            Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos "sdtrth, Toast.LENGTH_SHORT).show();
        }

    }
}