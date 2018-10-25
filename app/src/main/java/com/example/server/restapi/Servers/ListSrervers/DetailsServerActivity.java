package com.example.server.restapi.Servers.ListSrervers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.server.restapi.R;
import com.example.server.restapi.Servers.DetailedInfo.DetailedServerDetails;
import com.example.server.restapi.Servers.serverAction.ServerPause;
import com.example.server.restapi.Servers.serverAction.ServerStart;
import com.example.server.restapi.Servers.serverAction.ServerStop;
import com.example.server.restapi.api.model.TokenVerification.MyToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.zou.sshclient.*;

public class DetailsServerActivity extends AppCompatActivity {


    // This activity is used to capture the data of running compute instances and have action control like start, stop, pause and access
    // Access of instances is not implemented yet while other 3 options are working.
    TextView tokenDebugView;
    ImageView imageViewState;
    View view1;

    ProgressBar progressBar;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16,tv17;
    String adminToken;
    String serverid;
    String serverState;
    String serverStatus;
    String serverUpdata;
    String serverHostid;
    String serverKey;
    String serverName;
    String serverCreated;
    String servertenantid;
    String serverUserid;
    String serverId;
    String serverlastLaunched;
    String serverPrivateIP;
    String serverFloatingIP;
    String serverMAC;
    String serverImageid;
    String serverFlavour;
    String serverSecurityGroups;
    Button btnStart,btnStop,btnPause,btnAccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_server);


        Bundle extras = getIntent().getExtras();

        tokenDebugView = findViewById(R.id.tokenDebugView);
        tokenDebugView.setText(extras.getString("token"));
        progressBar = findViewById(R.id.progressBar2);
        //progressBar.setVisibility(View.GONE);
        imageViewState = findViewById(R.id.imageViewStatus);


        btnStart =findViewById(R.id.btnStart);
        btnPause = findViewById(R.id.btnPause);
        btnAccess = findViewById(R.id.btnAccess);
        btnStop = findViewById(R.id.btnStop);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv8 = findViewById(R.id.tv8);
        tv9 = findViewById(R.id.tv9);
        tv10 = findViewById(R.id.tv10);
        tv11 = findViewById(R.id.tv11);
        tv12 = findViewById(R.id.tv12);
        tv13 = findViewById(R.id.tv13);
        tv14 = findViewById(R.id.tv14);
        tv15 = findViewById(R.id.tv15);
        tv16 = findViewById(R.id.tv16);
        tv17 = findViewById(R.id.tv17);
        btnAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accessServer();
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view1 =v;
                progressBar.setVisibility(ProgressBar.VISIBLE);

                startServers();
                //progressBar.setVisibility(view1.GONE);

            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(ProgressBar.VISIBLE);
                stopServers();
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(ProgressBar.VISIBLE);
                pauseServers();
            }
        });
        adminToken = MyToken.loginToken;
        serverid = extras.getString("serverid");
        getSerDetails();
    }




    public void accessServer()
    {

     Intent intent = new Intent(DetailsServerActivity.this, MainActivity.class);
     intent.putExtra("floatIp", serverFloatingIP);
     intent.putExtra("username", "cirros");
     intent.putExtra("password", "cubswin:)");
     startActivity(intent);





    }

    public void getSerDetails()
    {
       // progressBar.setVisibility(View.GONE);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.106:8774/v2.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestDetails request = retrofit.create(RequestDetails.class);
        Call<DetailedServerDetails> call = request.getDetailsServer("ed5c602595c0441da782f798bc7c3da5", adminToken, serverid );
        call.enqueue(new Callback<DetailedServerDetails>() {
            @Override
            public void onResponse(Call<DetailedServerDetails> call, Response<DetailedServerDetails> response) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
               // final String abc = gson.toJson(response);
                tokenDebugView.setText(gson.toJson(response));
                JSONObject json = null;
                JSONObject json1 = null;
                try{ json = new JSONObject(gson.toJson(response));
                     json = json.getJSONObject("body");
                     json = json.getJSONObject("server");
                     serverStatus =   json.get("status").toString();
                    Toast.makeText(DetailsServerActivity.this, serverStatus, Toast.LENGTH_LONG).show();
                    serverUpdata = json.get("updated").toString();
                    serverHostid = json.get("hostId").toString();
                    serverUserid = json.get("user_id").toString();
                    serverKey = json.get("key_name").toString();
                    serverName = json.get("name").toString();
                    serverCreated = json.get("created").toString();
                    servertenantid = json.get("tenant_id").toString();
                    serverState = json.get("OS-EXT-STS:power_state").toString();
                    serverId = json.get("id").toString();
                    serverlastLaunched = json.get("OS-SRV-USG:launched_at").toString();
                    json1 = json.getJSONObject("addresses");
                    JSONArray jsonArray = json1.getJSONArray("private");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        if(i==0)
                        {
                            serverPrivateIP = jsonObject.get("addr").toString();
                            Toast.makeText(DetailsServerActivity.this, "private_ip"+serverPrivateIP, Toast.LENGTH_SHORT).show();

                        }
                        else if(i==1)
                        {
                            serverFloatingIP = jsonObject.get("addr").toString();
                            Toast.makeText(DetailsServerActivity.this, "floating_ip"+serverFloatingIP, Toast.LENGTH_SHORT).show();
                        }
                        serverMAC = jsonObject.get("OS-EXT-IPS-MAC:mac_addr").toString();



                    }
                    json1 = json.getJSONObject("image");
                    serverImageid = json1.get("id").toString();
                    json1 = json.getJSONObject("flavor");
                    serverFlavour = json1.get("id").toString();
                    jsonArray = json.getJSONArray("security_groups");
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    serverSecurityGroups = jsonObject.get("name").toString();
                    tv1.setText(serverid);
                    tv2.setText(serverPrivateIP);
                    tv3.setText(serverFloatingIP);
                    tv4.setText(serverImageid);
                    tv5.setText(serverlastLaunched);
                    tv6.setText(serverUpdata);
                    tv7.setText(serverUserid);
                    tv8.setText(serverHostid);
                    tv9.setText(serverCreated);
                    tv10.setText(servertenantid);
                    tv11.setText(serverKey);
                    tv12.setText(serverMAC);
                    tv13.setText(serverSecurityGroups);
                    tv14.setText(serverFlavour);
                    tv15.setText(serverStatus);
                    tv16.setText(serverName);
                    tv17.setText(serverState);
                    if(Integer.parseInt(serverState) == 1)
                    {
                        imageViewState.setImageResource(R.drawable.if_circle_green_10280);


                    }
                    else if(Integer.parseInt(serverState) == 4)
                    {

                        imageViewState.setImageResource(R.drawable.if_circle_red_10282);
                    }
                    else if(Integer.parseInt(serverState) == 3)
                    {
                        imageViewState.setImageResource(R.drawable.if_circle_orange_10281);
                    }






                }catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<DetailedServerDetails> call, Throwable t) {
                Toast.makeText(DetailsServerActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }

    public void startServers()
    {

      String request = "{\n" +
              "    \"os-start\" : null\n" +
              "}";
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), request);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.106:8774/v2.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServerStart action = retrofit.create(ServerStart.class);
        Call<ResponseBody> call = action.startServer(body,"ed5c602595c0441da782f798bc7c3da5", adminToken, serverId );
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.code()== 202)
                {
                    Toast.makeText(DetailsServerActivity.this, "Server Started", Toast.LENGTH_SHORT).show();
                    tv15.setText("Activating");
                   // progressBar.setVisibility(View.VISIBLE);


                    //imageViewState.setImageResource(R.drawable.if_circle_green_10280);


                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                             //progressBar.setVisibility(view1.GONE);
                            getSerDetails();
                            progressBar.setVisibility(ProgressBar.INVISIBLE);
                            // this code will be executed after 7 seconds
                        }
                    }, 10000);
                   // getSerDetails();

                }
                else
                {   if(response.code()== 409)
                    Toast.makeText(DetailsServerActivity.this, "Server is already started", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(DetailsServerActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }
    public void stopServers() {

        if (serverStatus.equals("ACTIVE")) {
            String request = "{\n" +
                    "    \"os-stop\" : null\n" +
                    "}";
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), request);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.0.106:8774/v2.1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ServerStop action = retrofit.create(ServerStop.class);
            Call<ResponseBody> call = action.stopServer(body, "ed5c602595c0441da782f798bc7c3da5", adminToken, serverId);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    if (response.code() == 202) {
                        Toast.makeText(DetailsServerActivity.this, "Server Stopped", Toast.LENGTH_SHORT).show();
                        tv15.setText("Shuttind Down");
                       // progressBar.setVisibility(View.VISIBLE);
                       // imageViewState.setImageResource(R.drawable.if_circle_red_10282);
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                getSerDetails();
                                progressBar.setVisibility(ProgressBar.INVISIBLE);
                                // this code will be executed after 7 seconds
                            }
                        }, 10000);


                    }

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });


        }

        else
        {

            Toast.makeText(DetailsServerActivity.this, "Server is already Down", Toast.LENGTH_SHORT).show();
        }
    }






    public void pauseServers() {


            String request = "{\n" +
                    "    \"pause\": null\n" +
                    "}";
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), request);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.0.106:8774/v2.1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ServerPause action = retrofit.create(ServerPause.class);
            Call<ResponseBody> call = action.pauseServer(body, "ed5c602595c0441da782f798bc7c3da5", adminToken, serverId);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    if (response.code() == 202) {
                        Toast.makeText(DetailsServerActivity.this, "Server Paused", Toast.LENGTH_SHORT).show();
                        tv15.setText("Pausing");
                        //progressBar.setVisibility(View.VISIBLE);
                        //imageViewState.setImageResource(R.drawable.if_circle_orange_10281);
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                getSerDetails();
                                progressBar.setVisibility(ProgressBar.INVISIBLE);
                               // this code will be executed after 7 seconds
                            }
                        }, 9000);

                    }
                    else if(response.code() == 409)
                    {

                        Toast.makeText(DetailsServerActivity.this, "Problem in attempting action. Refresh and check Status", Toast.LENGTH_SHORT).show();

                    }

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(DetailsServerActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });


        }

















}


