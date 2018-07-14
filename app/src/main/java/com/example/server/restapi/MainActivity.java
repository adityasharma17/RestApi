package com.example.server.restapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.server.restapi.api.model.TokenVerification.Auth;
import com.example.server.restapi.api.model.TokenVerification.Example;
import com.example.server.restapi.api.model.TokenVerification.Identity;
import com.example.server.restapi.api.model.TokenVerification.MyToken;
import com.example.server.restapi.api.model.TokenVerification.Password;
import com.example.server.restapi.api.model.TokenVerification.Project;
import com.example.server.restapi.api.model.TokenVerification.Scope;
import com.example.server.restapi.api.model.TokenVerification.User;


import com.example.server.restapi.api.model.TokenVerification.service.UserClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {
public  String token;
TextView textView;
String text;
public String globalToken;











    Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://192.168.0.106:5000/v3/auth/").
            addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();
    UserClient userClient = retrofit.create(UserClient.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.textView);









        login();




       //getImages(Token.globalToken);





    }

    public  void login()
    {
        List<String> methods = new ArrayList<String>();
        methods.add("password");
        Project project = new Project();
        project.setId("76b6432f3ea649e3acdd9fd91643ef05");
        Scope scope = new Scope();
        scope.setProject(project);
        User user = new User();
        user.setId("bbe57ffd805346f88930466fcf7cbe0d");
        user.setPassword("6790");
        Password password = new Password();
        password.setUser(user);
        Identity identity = new Identity();
        identity.setMethods(methods);
        identity.setPassword(password);
        Auth auth = new Auth();
        auth.setScope(scope);
        auth.setIdentity(identity);
        Example example = new Example();
        example.setAuth(auth);
       //Gson gson = new GsonBuilder().setPrettyPrinting().create();
       // final String abc = gson.toJson(example);

        //Example example = new Gson().fromJson(text, Example.class);


        //RequestBody body = RequestBody.create(MediaType.parse("application/json"), text);

        Call<ResponseBody> call= userClient.login(example);


       call.enqueue(new Callback<ResponseBody>() {




           @Override
           public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {



              Headers headers = response.headers();
              //token=response.raw().toString();

             globalToken = response.headers().get("X-Subject-Token");

             sendtoGlobal( globalToken);

               Intent intent = new Intent(MainActivity.this, Main2Activity.class);
               startActivity(intent);
               //Log.d(TAG, token);
               //response.body().close();




               // gotoSecond(globalToken);
              //textView.setText(globalToken);

               //Token.globalToken = globalToken;
               //Token.value = globalToken;

             // getImages(Token.globalToken);




           }

           @Override
           public void onFailure(Call<ResponseBody> call, Throwable t) {

               Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

           }
       });






    }


    public void sendtoGlobal(String myToken)
    { MyToken.loginToken = myToken; }






}
