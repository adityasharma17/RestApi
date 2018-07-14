package com.example.server.restapi.Servers.CreateServers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.server.restapi.Images.GetImageDetails;
import com.example.server.restapi.Images.GetImages;
import com.example.server.restapi.Images.GetImagesActivity;
import com.example.server.restapi.ListKeys.KeysApi;
import com.example.server.restapi.ListKeys.ListKeys;
import com.example.server.restapi.R;
import com.example.server.restapi.api.model.TokenVerification.MyToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateServerActivity extends AppCompatActivity {
      TextView textView11,textView12,textView13,textView14,textView15;
     Spinner imagesSpinner, networkSpinner, keysSpinner, flavorSpinner, securityGroupsSpinner;
     HashMap<String, String> images;
     ArrayList<String> imagesName;
     ArrayList<String> keys;
     String imageName;
     String keyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_server);
         imagesSpinner = findViewById(R.id.imagesSpinner);
         networkSpinner = findViewById(R.id.networkSpinner);
         keysSpinner = findViewById(R.id.keysSpinner);
         flavorSpinner = findViewById(R.id.flavorSpinner);
         securityGroupsSpinner = findViewById(R.id.securityGroupsSpinner);
         textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        textView13 = findViewById(R.id.textView13);
        textView14 = findViewById(R.id.textView14);
        textView15 = findViewById(R.id.textView15);
        images = new HashMap<String, String>();
        imagesName = new ArrayList<String>();
        keys = new ArrayList<String>();
        getimages();
        getKeys();



    }

    private void getKeys() {

        Retrofit.Builder builder1 = new Retrofit.Builder().baseUrl("http://192.168.0.106:8774/").
                addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit1 = builder1.build();
        KeysApi keysApi = retrofit1.create(KeysApi.class);
        Call<ListKeys> call1 = keysApi.listKeys(MyToken.loginToken);
        call1.enqueue(new Callback<ListKeys>() {
            @Override
            public void onResponse(Call<ListKeys> call, Response<ListKeys> response) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                //final String abc = gson.toJson(response);
                JSONObject json = null;
                try{
                    json = new JSONObject(gson.toJson(response));
                    json = json.getJSONObject("body");
                    JSONArray jsonArray = json.getJSONArray("keypairs");

                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                          jsonObject = jsonObject.getJSONObject("keypair");
                           keys.add(jsonObject.get("name").toString());

                    }



                }catch (JSONException e) {
                    e.printStackTrace();
                }
                ArrayAdapter<String> locationAdapter1 = new ArrayAdapter<String>(CreateServerActivity.this, android.R.layout.simple_spinner_item, keys);
                locationAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                keysSpinner.setAdapter(locationAdapter1);
                keysSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        keyName = parent.getItemAtPosition(position).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });





            }

            @Override
            public void onFailure(Call<ListKeys> call, Throwable t) {

            }
        });


    }

    private void getimages() {

        Retrofit.Builder builder1 = new Retrofit.Builder().baseUrl("http://192.168.0.106:9292/").
                addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit1 = builder1.build();

        GetImages getImages = retrofit1.create(GetImages.class);
        Call<GetImageDetails> call1 = getImages.getImagesb(MyToken.loginToken);
        call1.enqueue(new Callback<GetImageDetails>() {
            @Override
            public void onResponse(Call<GetImageDetails> call, Response<GetImageDetails> response) {

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                final String abc = gson.toJson(response);


                JSONObject json = null;
                try {
                    json = new JSONObject(gson.toJson(response));
                    json = json.getJSONObject("body");

                    JSONArray jsonArray = json.getJSONArray("images");
                    // int length = json.length();
                    //lengthTextView.setText(String.valueOf(jsonArray.length()));

                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        images.put(jsonObject.get("name").toString(), jsonObject.get("id").toString());
                        imagesName.add(jsonObject.get("name").toString());




                    }

                    ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(CreateServerActivity.this, android.R.layout.simple_spinner_item, imagesName);
                    locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    imagesSpinner.setAdapter(locationAdapter);
                    imagesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            imageName = parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }

            @Override
            public void onFailure(Call<GetImageDetails> call, Throwable t) {
                Toast.makeText(CreateServerActivity.this , t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
