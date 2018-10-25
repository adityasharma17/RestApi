package com.example.server.restapi.Servers.ListSrervers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.server.restapi.R;
import com.example.server.restapi.api.model.TokenVerification.MyToken;

import java.util.ArrayList;


public class DataAdapterServers extends RecyclerView.Adapter<DataAdapterServers.ViewHolder> {


    private ArrayList<Server> server;
    public Context context;


    public DataAdapterServers(ArrayList<Server> server) {
        this.server = server;
    }

    @Override
    public DataAdapterServers.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row_server_list, viewGroup, false);
        context = viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapterServers.ViewHolder viewHolder, final int i) {

        viewHolder.server_name.setText(server.get(i).getName());
        viewHolder.server_id.setText(server.get(i).getId());
        viewHolder.server_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(context,server.get(i).getId(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, DetailsServerActivity.class);
                intent.putExtra("token", MyToken.userToken);
                intent.putExtra("serverid", server.get(i).getId());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return server.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView server_name,server_id;
        public ViewHolder(View view) {
            super(view);

            server_name = (TextView)view.findViewById(R.id.server_name);
            server_id = (TextView)view.findViewById(R.id.server_id);


        }
    }

















}
