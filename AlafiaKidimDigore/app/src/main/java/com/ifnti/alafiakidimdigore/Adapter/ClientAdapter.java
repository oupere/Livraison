package com.ifnti.alafiakidimdigore.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ifnti.alafiakidimdigore.Modele.Client;
import com.ifnti.alafiakidimdigore.R;

import java.util.ArrayList;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ViewHolder> {
    private ArrayList<Client> listClient;
    private Context context;

    public ClientAdapter(ArrayList<Client> listClient, Context context) {
        this.listClient = listClient;
        this.context = context;
    }

    @NonNull
    @Override
    public ClientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.affichageclient, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClientAdapter.ViewHolder holder, int position) {
        Client clients = listClient.get(position);
        assert clients != null;
        holder.nomCli.setText(clients.getNom());
        holder.prenomCli.setText(clients.getPrenom());
        holder.contactCli.setText(clients.getContact());
        holder.adresseCli.setText(clients.getAdresse());
    }

    @Override
    public int getItemCount() {
        return listClient.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nomCli;
        private final TextView prenomCli;
        private final TextView contactCli;
        private final TextView adresseCli;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomCli = itemView.findViewById(R.id.nomClt);
            prenomCli = itemView.findViewById(R.id.prenomClt);
            contactCli = itemView.findViewById(R.id.contactClt);
            adresseCli = itemView.findViewById(R.id.addresseClt);

        }
    }
}
