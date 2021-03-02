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
import com.lunijami.nodehood.modelo.entidades.MisPedidos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mis_pedidos;
    RecyclerView mis_realizados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayoutManager layout_mispedidos = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mis_pedidos = findViewById(R.id.recicler_mis_pedidos);
        ArrayList<MisPedidos> listaPedidos = new ArrayList<MisPedidos>();
        for(int i=0; i <= 10; i++){
            MisPedidos p = new MisPedidos("titulo "+i, "descripcion " + i, getDrawable(R.drawable.apple));
            listaPedidos.add(p);
        }
        RecyclerView.LayoutManager gestorPedidos = new LinearLayoutManager(this);
        MiAdaptador adaptadorPedidos = new MiAdaptador(listaPedidos);
        mis_pedidos.setLayoutManager(gestorPedidos);
        mis_pedidos.setAdapter(adaptadorPedidos);
        mis_pedidos.setLayoutManager(layout_mispedidos);
//-------------------------- cambiamos de recycler ---------------------------------------
        LinearLayoutManager layout_misRealizados = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mis_realizados = findViewById(R.id.recicler_mis_realizados);
        ArrayList<MisPedidos> listaRealizados = new ArrayList<MisPedidos>();
        for(int i=0; i <= 10; i++){
            MisPedidos p = new MisPedidos("titulo "+i, "descripcion " + i, getDrawable(R.drawable.apple));
            listaRealizados.add(p);
        }
        RecyclerView.LayoutManager gestorRealizados = new LinearLayoutManager(this);
        MiAdaptador adaptadorrealizados = new MiAdaptador(listaRealizados);
        mis_realizados.setLayoutManager(gestorRealizados);
        mis_realizados.setAdapter(adaptadorrealizados);
        mis_realizados.setLayoutManager(layout_misRealizados);

//        this.getSupportActionBar().setDisplayShowCustomEnabled(true);
//
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View v = inflater.inflate(R.layout.custom_action_bar, null);
//
//        TextView titleTextView = (TextView) v.findViewById(R.id.custom_action_bar_title);
//        titleTextView.setText(this.getTitle());
//        titleTextView.setTypeface(App.getInstance().getActionBarTypeFace());
//
//        this.getSupportActionBar().setCustomView(v);

        // cast al xml
        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar_menu);

        //click event en el  FAB
        findViewById(R.id.chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);


            }
        });

        //click event en el Hamburguer menu
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Menu clicked!", Toast.LENGTH_SHORT).show();
//                sheetBehavior = BottomSheetBehavior.from(sheet);
            }


        });

        //click event en el Bottom bar menu item
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_app_bar_menu_profile:
                        Toast.makeText(MainActivity.this, "Like clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_app_bar_menu_search:
                        Toast.makeText(MainActivity.this, "Search clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottom_app_bar_menu_share:
                        Toast.makeText(MainActivity.this, "Share clicked.", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });


    }
}