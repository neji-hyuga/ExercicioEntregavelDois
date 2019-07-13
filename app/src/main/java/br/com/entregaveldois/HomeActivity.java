package br.com.entregaveldois;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.entregaveldois.adapters.RestauranteAdapter;
import br.com.entregaveldois.interfaces.RestauranteListener;
import br.com.entregaveldois.model.Restaurante;

public class HomeActivity extends AppCompatActivity implements RestauranteListener {

    private RestauranteAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        List<Restaurante> listaRestaurante = new ArrayList<>();

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNomeRestaurante("Tony Roma's");
        restaurante1.setEnderecoRestaurante("Av. Lavandisca, 717 - Indianópolis, São Paulo");
        restaurante1.setHorarioRestaurante("Fecha as 22h");
        restaurante1.setFotoRestaurante(R.drawable.tonys);
        listaRestaurante.add(restaurante1);

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNomeRestaurante("Aoyama - Moema");
        restaurante2.setEnderecoRestaurante("Alameda dos Arapanés, 532 - Moema");
        restaurante2.setHorarioRestaurante("Fecha as 00h");
        restaurante2.setFotoRestaurante(R.drawable.aoyama);
        listaRestaurante.add(restaurante2);

        Restaurante restaurante3 = new Restaurante();
        restaurante3.setNomeRestaurante("Outback - Moema");
        restaurante3.setEnderecoRestaurante("Av. Moaci, 187 - Moema, São Paulo");
        restaurante3.setHorarioRestaurante("Fecha as 22h");
        restaurante3.setFotoRestaurante(R.drawable.outback);
        listaRestaurante.add(restaurante3);

        Restaurante restaurante4 = new Restaurante();
        restaurante4.setNomeRestaurante("Si Señor!");
        restaurante4.setEnderecoRestaurante("Alameda Jauperi, 626 - Indianópolis, São Paulo");
        restaurante4.setHorarioRestaurante("Fecha as 01h");
        restaurante4.setFotoRestaurante(R.drawable.sisenor);
        listaRestaurante.add(restaurante4);

        RestauranteAdapter restauranteAdapter = new RestauranteAdapter(listaRestaurante, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.restaurante_recycler_view);
        recyclerView.setAdapter(restauranteAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }


    @Override
    public void onRestauranteClicado(Restaurante restaurante) {
        Intent intent = new Intent(this, RestauranteDetalheActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("RESTAURANTE", restaurante);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuItem menuItem = menu.add(0, 0, 0, "Profile");
        menuItem.setShowAsAction(menuItem.SHOW_AS_ACTION_NEVER);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 0: Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;
        } return true;
    }


}
