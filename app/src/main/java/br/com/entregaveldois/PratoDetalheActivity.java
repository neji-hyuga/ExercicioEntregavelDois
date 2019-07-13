package br.com.entregaveldois;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.entregaveldois.model.Prato;

public class PratoDetalheActivity extends AppCompatActivity {

    private TextView nomePrato;
    private TextView descricaoPrato;
    private ImageView fotoPrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prato_detalhe);

        fotoPrato = findViewById(R.id.detalhe_prato_image_view);
        nomePrato = findViewById(R.id.nome_prato_detalhe_text_view);
        descricaoPrato = findViewById(R.id.texto_prato_text_view);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        Prato prato = (Prato) bundle.getSerializable("PRATOS");

        fotoPrato.setImageResource(prato.getFotoPrato());
        nomePrato.setText(prato.getNomePrato());
        descricaoPrato.setText(prato.getDescricaoPrato());
    }
}
