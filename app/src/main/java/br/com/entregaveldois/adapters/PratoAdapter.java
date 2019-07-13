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
import br.com.entregaveldois.interfaces.PratosListener;
import br.com.entregaveldois.model.Prato;

public class PratoAdapter extends RecyclerView.Adapter<PratoAdapter.ViewHolderPrato>{

    private List<Prato> listaPratos;
    private PratosListener pratosListener;

    public PratoAdapter(List<Prato> listaPratos, PratosListener pratosListener) {
        this.listaPratos = listaPratos;
        this.pratosListener = pratosListener;
    }

    @NonNull
    @Override
    public PratoAdapter.ViewHolderPrato onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        View view = layoutInflater.inflate(R.layout.prato_celula, viewGroup, false);

        ViewHolderPrato viewHolderPrato = new ViewHolderPrato(view);
        return viewHolderPrato;
    }

    @Override
    public void onBindViewHolder(@NonNull PratoAdapter.ViewHolderPrato viewHolderPrato, final int i) {
        viewHolderPrato.nomePrato.setText(listaPratos.get(i).getNomePrato());
        viewHolderPrato.fotoPrato.setImageResource(listaPratos.get(i).getFotoPrato());

        viewHolderPrato.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pratosListener.onPratosClicados(listaPratos.get(i));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPratos.size();
    }

    public class ViewHolderPrato extends RecyclerView.ViewHolder {

        public ImageView fotoPrato;
        public TextView nomePrato;

        public ViewHolderPrato(@NonNull View itemView) {
            super(itemView);

            fotoPrato = itemView.findViewById(R.id.imagem_prato_recycler_id);
            nomePrato = itemView.findViewById(R.id.detalhe_prato_text_view);
        }
    }
}
