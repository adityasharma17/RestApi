package com.example.server.restapi.Images;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.server.restapi.Main2Activity;
import com.example.server.restapi.R;
import com.example.server.restapi.api.model.TokenVerification.MyToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetImagesActivity extends AppCompatActivity {

    ArrayList<String> myimages ;
    Spinner spinner;
    TextView imagesTxt, lengthTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_images);
        spinner = findViewById(R.id.spinner);
        imagesTxt = findViewById(R.id.imagesTxt);
        lengthTextView = findViewById(R.id.lengthTextView);
        myimages =new ArrayList<>();
        getImages();
    }




//This activity is used to fetch the images that can be used to deploy a compute machine
    // All the other interfaces are plane simple java objects that is used for storing the data that we recieved from the server.




    public void getImages()
    {


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
                imagesTxt.setText(abc);

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
                        myimages.add(jsonObject.get("id").toString());

                        Toast.makeText(GetImagesActivity.this, jsonObject.get("id").toString(), Toast.LENGTH_SHORT).show();

                    }
                    for(int i=0;i<myimages.size();i++) {
                        lengthTextView.setText(lengthTextView.getText() + "   " + myimages.get(i)+"     ");

                    }

                    ArrayAdapter<String> locationAdapter = new ArrayAdapter<String>(GetImagesActivity.this, android.R.layout.simple_spinner_item, myimages);
                    locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(locationAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }

            @Override
            public void onFailure(Call<GetImageDetails> call, Throwable t) {
                Toast.makeText(GetImagesActivity.this , t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });







    }



}
