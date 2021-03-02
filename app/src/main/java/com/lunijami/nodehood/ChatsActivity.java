package com.lunijami.nodehood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        recycler = (RecyclerView) findViewById(R.id.recycler_id);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        listDatos = new ArrayList<String>();
        for (int i = 0 ; i<50;i++){
            listDatos.add("Dato: "+i+" ");
        }

        MiAdaptadorChats adapter = new MiAdaptadorChats(listDatos);


        setContentView(R.layout.activity_chats);
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
                }
                return false;
            }
        });
    }
}