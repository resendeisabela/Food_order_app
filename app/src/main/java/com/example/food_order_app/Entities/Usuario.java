package com.example.food_order_app.Entities;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Usuario {
    String id;
    String email;
    String senha;

    public Usuario() {
    }

    public Usuario(String id, String email, String senha) {
        this.id = id;
        this.email = email;
        setSenha(senha);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, senha.toCharArray());
        this.senha = bcryptHashString;
    }

    public void salvar(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Usuarios").child(getId()).setValue(this);
    }
}
