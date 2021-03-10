package com.lunijami.nodehood.modelo;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lunijami.nodehood.modelo.entidades.Usuario;

public class AccesoDatos {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void registrarUsuario(Usuario user) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Usuarios");
        myRef.child(user.getEmail().replace('.', '>')).setValue(user);
    }

    public static void getUsuario(String email, Actualizacion a) {
        Usuario user = null;
        Log.d("Bajada", email);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Usuarios/"+email);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try{
                    Usuario user = dataSnapshot.getValue(Usuario.class);
                    System.out.println(user);
                    a.recuperarDatos(user);
                } catch (Exception e ){
                    a.recuperarDatos(user);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

    }

    public interface Actualizacion {
        public void recuperarDatos(Usuario user);
    }

}


