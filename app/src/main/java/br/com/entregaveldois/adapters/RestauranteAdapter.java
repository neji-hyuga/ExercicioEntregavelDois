package br.com.entregaveldois.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.entregaveldois.R;
import br.com.entregaveldois.interfaces.RestauranteListener;
import br.com.entregaveldois.model.Restaurante;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder>{

    private List<Restaurante> listRestaurantes;
    private RestauranteListener restauranteListener;

    public RestauranteAdapter(List<Restaurante> listRestaurantes, RestauranteListener restauranteListener) {
        this.listRestaurantes = listRestaurantes;
        this.restauranteListener = restauranteListener;
    }

    @NonNull
    @Override
    public RestauranteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurante_celula, viewGroup, false);
                return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestauranteAdapter.ViewHolder viewHolder, int i) {
        final Restaurante restaurante = listRestaurantes.get(i);
        viewHolder.bindRestaurante(restaurante);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restauranteListener.onRestauranteClicado(restaurante);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listRestaurantes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoRestaurante;
        private TextView nomeRestaurante;
        private TextView enderecoRestaurante;
        private TextView horarioRestaurante;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoRestaurante = itemView.findViewById(R.id.image_view_recycler_id);
            nomeRestaurante = itemView.findViewById(R.id.nome_restaurante_recycler_id);
            enderecoRestaurante = itemView.findViewById(R.id.endereco_recycler_id);
            horarioRestaurante = itemView.findViewById(R.id.horario_recycler_id);
        }

        public void bindRestaurante(Restaurante restaurante){
            fotoRestaurante.setImageResource(restaurante.getFotoRestaurante());
            nomeRestaurante.setText(restaurante.getNomeRestaurante());
            enderecoRestaurante.setText(restaurante.getEnderecoRestaurante());
            horarioRestaurante.setText(restaurante.getHorarioRestaurante());

        }
    }
}
