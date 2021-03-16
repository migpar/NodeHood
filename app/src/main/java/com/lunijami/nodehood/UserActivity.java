package com.lunijami.nodehood;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.bottomappbar.BottomAppBar;

public class UserActivity extends AppCompatActivity {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch tema;
    private TextView terminos;
    private ImageView perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        tema = findViewById(R.id.switch1);
        terminos = findViewById(R.id.textTerminos);

        terminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogButtonClicked(UserActivity.this);
            }
        });

        //Usuario Imagen
        perfil = (ImageView) findViewById(R.id.imageUsuario);

        Glide.with(this)
                .load(R.drawable.luis).centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .circleCrop().into(perfil);

        tema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tema.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        // cast al xml
        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar_menu);

        //click event en el  FAB
        findViewById(R.id.chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentChat = new Intent(UserActivity
                        .this, ChatsActivity.class);
                intentChat.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentChat.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentChat);
            }
        });

        //click event en el Hamburguer menu
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserActivity.this, "Menu clicked!", Toast.LENGTH_SHORT).show();
//                sheetBehavior = BottomSheetBehavior.from(sheet);
            }


        });

        //click event en el Bottom bar menu item
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_app_bar_menu_profile:
                        Toast.makeText(UserActivity.this, "you are Already here", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_app_bar_menu_search:
                        Toast.makeText(UserActivity.this, "Search clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_app_bar_menu_share:
                        Intent intentMain = new Intent(UserActivity
                                .this, MainActivity.class);
                        intentMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intentMain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intentMain);
                        break;
                }
                return false;
            }
        });
    }

    public void showAlertDialogButtonClicked(UserActivity view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
//        builder.setTitle("Achtung!");
//        builder.setMessage("Where do you go?");
//        builder.setIcon(R.drawable.ic_action_name_dark);


        // un XML a medida para el diálogo
        LinearLayoutManager layout_terminos = new LinearLayoutManager(builder.getContext(), LinearLayoutManager.VERTICAL, false);
        builder.setView(getLayoutInflater().inflate(R.layout.terminosdialog_view, null));
        TextView terms = findViewById(R.id.profession);



        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}