package com.example.server.restapi.Servers.ListSrervers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.Toast;

import com.example.server.restapi.R;
import com.example.server.restapi.api.model.TokenVerification.MyToken;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListServerAcitivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<Server> data;
    private DataAdapterServers adapter;
    public String gToken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_list_server_acitivity);

        gToken = MyToken.loginToken;
        initViews();
    }



    private void initViews()
    {   recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
   getdetails();
   }
   private void getdetails()
   {


       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("http://192.168.0.106:8774/v2.1/")
               .addConverterFactory(GsonConverterFactory.create())
           .build();
       RequestInterface request = retrofit.create(RequestInterface.class);
       Call<GetServerDetails> call = request.getServerData("ed5c602595c0441da782f798bc7c3da5", gToken );

       call.enqueue(new Callback<GetServerDetails>() {
           @Override
           public void onResponse(Call<GetServerDetails> call, Response<GetServerDetails> response) {

               GetServerDetails getServerDetails = response.body();
               data = new ArrayList<>((getServerDetails.getServers()));
               adapter = new DataAdapterServers(data);
               recyclerView.setAdapter(adapter);




           }

           @Override
           public void onFailure(Call<GetServerDetails> call, Throwable t) {

               Toast.makeText(ListServerAcitivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

           }
       });








   }

}
