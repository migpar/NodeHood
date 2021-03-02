package com.lunijami.nodehood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

import java.util.ArrayList;

public class ChatsActivity extends AppCompatActivity {
    ArrayList<String> listDatos;
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        LinearLayoutManager layout_mischats = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler = findViewById(R.id.recicler_mis_chats);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        listDatos = new ArrayList<String>();
        for (int i = 0 ; i<50;i++){
            listDatos.add("Dato: "+i+" ");
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
                Toast.makeText(ChatsActivity.this, "Menu clicked!", Toast.LENGTH_SHORT).show();
//                sheetBehavior = BottomSheetBehavior.from(sheet);
            }


        });

        //click event en el Bottom bar menu item
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_app_bar_menu_profile:
                        Toast.makeText(ChatsActivity.this, "Like clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_app_bar_menu_search:
                        Toast.makeText(ChatsActivity.this, "Search clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_app_bar_menu_share:
                        Toast.makeText(ChatsActivity.this, "Share clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.chat:
                        Toast.makeText(ChatsActivity.this, "YOU ARE ALREADY HERE", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }
}