package br.com.entregaveldois;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText nomeRegistroEditText;
    private TextInputEditText emailRegistroEditText;
    private TextInputEditText senhaRegistroEditText;
    private TextInputEditText confirmaSenhaRegistroEditText;
    private Button confirmaRegistroButton;
    private String emBranco = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        nomeRegistroEditText = findViewById(R.id.nome_registro_edit_text);
        emailRegistroEditText = findViewById(R.id.email_registro_edit_text);
        senhaRegistroEditText = findViewById(R.id.senha_registro_edit_text);
        confirmaSenhaRegistroEditText = findViewById(R.id.confirma_senha_registro_edit_text);

        confirmaRegistroButton = findViewById(R.id.botao_register_id);
        confirmaRegistroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerClicado(view);
            }
        });
    }

    private void registerClicado(View view) {
        senhaRegistroEditText.setError(null);
        confirmaSenhaRegistroEditText.setError(null);
        emailRegistroEditText.setError(null);

        if(!senhaRegistroEditText.getEditableText().toString().equals(confirmaSenhaRegistroEditText.getEditableText().toString())){
            confirmaSenhaRegistroEditText.setError("as senhas não são as mesmas");
        } else if (senhaRegistroEditText.getEditableText().toString().equals(emBranco)){
            senhaRegistroEditText.setError("este campo não pode ficar em branco");
        } else if (emailRegistroEditText.getEditableText().toString().equals(emBranco)){
            emailRegistroEditText.setError("este campo não pode ficar em branco");
        } else if (nomeRegistroEditText.getEditableText().toString().equals(emBranco)){
            nomeRegistroEditText.setError("este campo não pode ficar em branco");
        } else {
            Snackbar.make(view, "registration successful", Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    registroCompleto();
                }
            }).setActionTextColor(getResources().getColor(R.color.colorAccent)).show();
        }

    }

    private void registroCompleto() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
