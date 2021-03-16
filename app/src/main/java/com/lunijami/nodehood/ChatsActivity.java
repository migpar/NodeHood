package com.lunijami.nodehood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.lunijami.nodehood.modelo.entidades.Usuario;

import java.util.ArrayList;

public class ChatsActivity extends AppCompatActivity {
    ArrayList<Usuario> listDatos;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        LinearLayoutManager layout_mischats = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler = findViewById(R.id.recicler_mis_chats);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        listDatos = new ArrayList<Usuario>();
        boolean foto = true;
        for (int i = 0; i < 50; i++) {
            Usuario u = new Usuario("Usuario"+i,"usuariomail"+i+"@gmail.com","123456");
            if(foto){
                u.setFoto(getDrawable(R.drawable.luis));
                foto=false;
            }else {
                u.setFoto(getDrawable(R.drawable.cara));
                foto=true;
            }

            listDatos.add(u);
        }
        RecyclerView.LayoutManager gestorChats = new LinearLayoutManager(this);
        MiAdaptadorChats adaptadorChats = new MiAdaptadorChats(listDatos);
        recycler.setLayoutManager(gestorChats);
        recycler.setAdapter(adaptadorChats);
        recycler.setLayoutManager(layout_mischats);


        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar_menu);

        //click event en el  FAB
        findViewById(R.id.chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ChatsActivity.this, "CHAT Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        //click event en el Hamburguer menu
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChatsActivity.this, "You are already here", Toast.LENGTH_SHORT).show();
//                sheetBehavior = BottomSheetBehavior.from(sheet);
            }


        });

        //click event en el Bottom bar menu item
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_app_bar_menu_profile:
                        Intent intentUser = new Intent(ChatsActivity
                                .this, UserActivity.class);
                        intentUser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intentUser.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intentUser);
                        break;
                    case R.id.bottom_app_bar_menu_search:
                        Toast.makeText(ChatsActivity.this, "Search clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_app_bar_menu_share:
                        Intent intentMain = new Intent(ChatsActivity
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
}