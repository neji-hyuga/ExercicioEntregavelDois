package br.com.entregaveldois;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.entregaveldois.adapters.PratoAdapter;
import br.com.entregaveldois.interfaces.PratosListener;
import br.com.entregaveldois.model.Prato;
import br.com.entregaveldois.model.Restaurante;

public class RestauranteDetalheActivity extends AppCompatActivity implements PratosListener {

    private ImageView fotoRestaurante;
    private TextView nomeRestaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_detalhe);

        fotoRestaurante = findViewById(R.id.image_detalhe_restaurante_id);
        nomeRestaurante = findViewById(R.id.nome_restaurante_detalhes_id);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        Restaurante restaurante = (Restaurante) bundle.getSerializable("RESTAURANTE");

        nomeRestaurante.setText(restaurante.getNomeRestaurante());
        fotoRestaurante.setImageResource(restaurante.getFotoRestaurante());

        List<Prato> listaPratos = new ArrayList<>();
        Prato prato1 = new Prato();
        prato1.setNomePrato("salada com molho gengibre");
        prato1.setDescricaoPrato("Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.");
        prato1.setFotoPrato(R.drawable.img_prato);
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);
        listaPratos.add(prato1);

        PratoAdapter pratoAdapter = new PratoAdapter(listaPratos, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = findViewById(R.id.reciler_pratos_id);
        recyclerView.setAdapter(pratoAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onPratosClicados(Prato prato) {

        Intent intent = new Intent(this, PratoDetalheActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("PRATOS", prato);

        intent.putExtras(bundle);

        startActivity(intent);

    }
}
