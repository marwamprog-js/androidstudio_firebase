package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /* Deslogar usuário */
//        usuario.signOut();

        /*Logar usuário*/
//        usuario.signInWithEmailAndPassword("marwam@gmail.com", "ma12345")
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if( task.isSuccessful() ) {
//                            Log.i("signIn", "Usuário logado!");
//                        } else {
//                            Log.i("signIn", "Usuário não logado!");
//                        }
//                    }
//                });


        /* Verifica usuário logado */

//        if( usuario.getCurrentUser() != null ) {
//            Log.i("CreateUser", "Usuário logado!");
//        } else {
//            Log.i("CreateUser", "Usuário não logado!");
//        }


        /* Cadastro de usuário */
//        usuario.createUserWithEmailAndPassword("marwam@gmail.com", "ma12345")
//                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if( task.isSuccessful() ) {
//                            Log.i("CreateUser", "Sucesso ao cadastrar usuário!");
//                        } else {
//                            Log.i("CreateUser", "Erro ao cadastrar usuário!");
//                        }
//                    }
//                });




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