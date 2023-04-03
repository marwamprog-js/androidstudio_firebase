package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference usuarios = reference.child( "usuarios" );

        Usuario usuario = new Usuario();
        usuario.setNome("Marwam");
        usuario.setSobrenome("Malta");
        usuario.setIdade(33);

        DatabaseReference produtos = reference.child("produtos");

        Produto produto = new Produto();
        produto.setDescricao("Iphone X");
        produto.setMarca("Iphone");
        produto.setPreco("5000");


        usuarios.child("002").setValue( usuario );
        produtos.child("001").setValue( produto );


    }
}