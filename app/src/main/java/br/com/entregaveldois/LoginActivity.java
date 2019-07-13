package br.com.entregaveldois;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private Button registerButton;
    private Button facebookButton;
    private Button loginButton;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    public String emBranco = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.email_login_edit_text);
        passwordEditText = findViewById(R.id.senha_login_edit_text);

        loginButton = findViewById(R.id.botao_login_id);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginClicado();
            }
        });

        facebookButton = findViewById(R.id.botao_login_facebook_id);
        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaHome();
            }
        });

        registerButton = findViewById(R.id.botao_registro_id);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaRegistrar();
            }
        });


    }

    private void irParaHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }

    private void irParaRegistrar() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void loginClicado() {
        emailEditText.setError(null);
        passwordEditText.setError(null);

        if (emailEditText.getEditableText().toString().equals(emBranco)){
            emailEditText.setError("o campo email não pode ficar em branco");
        } else if (passwordEditText.getEditableText().toString().equals(emBranco)){
            passwordEditText.setError("o campo senha não pode ficar em branco");
        } else {
            irParaHome();
        }
    }
}
