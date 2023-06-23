package com.example.food_order_app.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.food_order_app.R;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnLogin;
    private Button btnCadastro;
    private FirebaseAuth fAuth;
    private ProgressBar loginPB;
    private CheckBox mostrarSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        edtEmail = findViewById(R.id.edtEmail);
//        edtSenha = findViewById(R.id.edtSenha);
//        btnLogin = findViewById(R.id.btnLogin);
//        btnCadastro = findViewById(R.id.btnCadastro);
    }
}