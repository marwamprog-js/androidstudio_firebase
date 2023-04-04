package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference usuarios = reference.child( "usuarios" ).child("001");
        DatabaseReference produtos = reference.child("produtos");

        usuarios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("FIREBASE", snapshot.getValue().toString() );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        /*
        Usuario usuario = new Usuario();
        usuario.setNome("Marwam");
        usuario.setSobrenome("Malta");
        usuario.setIdade(33);



        Produto produto = new Produto();
        produto.setDescricao("Iphone X");
        produto.setMarca("Iphone");
        produto.setPreco("5000");


        usuarios.child("002").setValue( usuario );
        produtos.child("001").setValue( produto );


         */

    }
}