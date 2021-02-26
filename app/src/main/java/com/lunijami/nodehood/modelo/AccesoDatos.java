package com.lunijami.nodehood.modelo;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lunijami.nodehood.modelo.entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AccesoDatos {

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void registrarUsuario(Usuario user) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Usuarios");
        myRef.child(user.getEmail().replace('.', '>')).setValue(user);
    }

    public static Usuario getUsuario(String email) {
        final Usuario[] user = new Usuario[1];
        Log.d("Bajada", email);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Usuarios");
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                user[0] = dataSnapshot.getValue(Usuario.class);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
        return user[0];
    }


}


