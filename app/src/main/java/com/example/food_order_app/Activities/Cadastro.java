package com.example.food_order_app.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.food_order_app.MainActivity;
import com.example.food_order_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {

    private FirebaseAuth fAuth;
    private EditText edtEmailCadastro;
    private EditText edtSenhaCadastro;
    private EditText edtConfrimarSenha;
    private CheckBox mostrarSenhaCadastro;
    private Button btnCadastrar;
    private ProgressBar cadastroPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        fAuth = FirebaseAuth.getInstance();

//        edtEmailCadastro = findViewById(R.id.edtEmailcadastro);
//        edtSenhaCadastro = findViewById(R.id.edtSenhaCadastro);
//        edtConfrimarSenha = findViewById(R.id.edtConfirmarSenha);
//        mostrarSenhaCadastro = findViewById(R.id.mostrarSenhaCadastro);
//        btnCadastrar = findViewById(R.id.btnCadastrar);
//        cadastroPB = findViewById(R.id.cadastroPB);


        mostrarSenhaCadastro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edtSenhaCadastro.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    edtConfrimarSenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    edtSenhaCadastro.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    edtConfrimarSenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailCadastro = edtEmailCadastro.getText().toString();
                String senhaCadastro = edtSenhaCadastro.getText().toString();
                String confirmarSenha = edtConfrimarSenha.getText().toString();

                if(!TextUtils.isEmpty(emailCadastro) || !TextUtils.isEmpty(senhaCadastro) || !TextUtils.isEmpty(confirmarSenha)){
                    if(senhaCadastro.equals(confirmarSenha)){
                        cadastroPB.setVisibility(View.VISIBLE);

                        fAuth.createUserWithEmailAndPassword(emailCadastro,senhaCadastro).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    telaPrincipal();
                                }
                                else{
                                    String error = task.getException().getMessage();
                                    Toast.makeText(Cadastro.this, ""+error, Toast.LENGTH_SHORT).show();
                                }
                                cadastroPB.setVisibility(View.INVISIBLE);
                            }
                        });
                    }
                    else{
                        Toast.makeText(Cadastro.this, "A senha deve ser a mesma em ambos os campos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void telaPrincipal() {
        Intent intent = new Intent(Cadastro.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}