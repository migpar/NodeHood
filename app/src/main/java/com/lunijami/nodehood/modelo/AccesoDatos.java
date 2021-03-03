package com.lunijami.nodehood.modelo;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lunijami.nodehood.modelo.entidades.Usuario;

public class AccesoDatos {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void registrarUsuario(Usuario user) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Usuarios");
        myRef.child(user.getEmail().replace('.', '>')).setValue(user);
    }

    public static Usuario getUsuario(String email, Actualizacion a ) {
        final Usuario[] user = new Usuario[1];
        Log.d("Bajada", email);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Usuarios");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String prevChildKey) {
                user[0] = dataSnapshot.getValue(Usuario.class);
                a.recuperarDatos(user[0]);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });
        return user[0];
    }

    public interface Actualizacion{
        public void recuperarDatos(Usuario user);
    }

}


