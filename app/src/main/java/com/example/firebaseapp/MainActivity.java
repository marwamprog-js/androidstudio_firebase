package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.module.AppGlideModule;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    /*
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
*/
    private ImageView imageFoto;
    private Button buttonUpload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageFoto = findViewById(R.id.imageFoto);
        buttonUpload = findViewById(R.id.buttonUpload);

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Configura para imagem ser salva em memória
                imageFoto.setDrawingCacheEnabled(true);
                imageFoto.buildDrawingCache();

                //Recuperar bitmap da imagem (image a ser carregada)
                Bitmap bitmap = imageFoto.getDrawingCache();

                //Comprimindo bitmap para um formato png/jpeg
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, baos);
//                bitmap.compress(Bitmap.CompressFormat.PNG, 75, baos);

                //converter o baos para pixel brutos em uma matriz de bytes
                //(dados da imagem)

                byte[] dadosImagem = baos.toByteArray();

                //Define nós para o storage
                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                StorageReference imagens = storageReference.child("imagens");
                StorageReference imagemRef = imagens.child("Celular.jpeg");

                //Fazer Download do arquivo
                imagemRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Glide.with(MainActivity.this)
                                .load( uri )
                                .into( imageFoto );

                        Toast.makeText(MainActivity.this, "Sucesso ao alterar ",
                                Toast.LENGTH_LONG ).show();
                    }
                });







                /*
                imagemRef.delete().addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Erro ao deletar ",
                                Toast.LENGTH_LONG ).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "Sucesso ao deletar ",
                                Toast.LENGTH_LONG ).show();
                    }
                });
                */



                /*

                //Nome da imagem
                //String nomeArquivo = UUID.randomUUID().toString();
                StorageReference imagemRef = imagens.child("Celular.jpeg");

                //Retorna objeto que irá controlar o upload
                UploadTask uploadTask = imagemRef.putBytes( dadosImagem );
                uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Upload da imagem falhou: " + e.getMessage(),
                                Toast.LENGTH_LONG ).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        //Maneira antiga para download da URL imagem
//                        Uri url = taskSnapshot.getDownloadUrl();

                        //Nova maneira para download da URL imagem
                        imagemRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                               Uri url = task.getResult();

                               Toast.makeText(MainActivity.this, "Sucesso ao fazer upload: " + url.toString(),
                                        Toast.LENGTH_LONG ).show();
                            }
                        });


                    }
                });

                */
            }
        });








//        DatabaseReference usuarios = reference.child("usuarios");

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
//        Query usuarioPesquisa = usuarios.orderByChild("nome")
//                .startAt("L")
//                .endAt("L" + "\uf8ff");
/*

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