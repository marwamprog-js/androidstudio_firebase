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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference usuarios = reference.child("usuarios");

//        DatabaseReference usuarioPesquisa = usuarios.child("-NSAlJBxKgPxACoJr0Aa");

//        Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Marwam");
//        Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2);
//        Query usuarioPesquisa = usuarios.orderByKey().limitToLast(2);

        /* Maior ou igual (>=) */
//        Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(30);

        /* Menor ou igual (<=) */
//        Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(30);

        /* Menor ou igual (Between = (>=) (<=)) */
//        Query usuarioPesquisa = usuarios.orderByChild("idade")
//                .startAt(30)
//                .endAt(50);

        /* Filtrar Plavras (LIKE) */
        Query usuarioPesquisa = usuarios.orderByChild("nome")
                .startAt("L")
                .endAt("L" + "\uf8ff");


        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.i("Dados usuário: ", snapshot.getValue().toString());

//                Usuario dadoUsuario = snapshot.getValue(Usuario.class);
//                Log.i("Dados usuário: ", "nome: " + dadoUsuario.getNome() + " idade: " + dadoUsuario.getIdade());
//                Log.i("Dados usuário: ", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




//        Usuario usuario = new Usuario();
//        usuario.setNome("Brenda");
//        usuario.setSobrenome("Lopes");
//        usuario.setIdade(33);
//
//        usuarios.push().setValue( usuario );

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