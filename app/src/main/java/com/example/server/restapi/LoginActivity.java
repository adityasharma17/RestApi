package com.example.server.restapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.server.restapi.api.model.TokenVerification.Auth;
import com.example.server.restapi.api.model.TokenVerification.Example;
import com.example.server.restapi.api.model.TokenVerification.Identity;
import com.example.server.restapi.api.model.TokenVerification.Password;
import com.example.server.restapi.api.model.TokenVerification.Project;
import com.example.server.restapi.api.model.TokenVerification.Scope;
import com.example.server.restapi.api.model.TokenVerification.User;
import com.example.server.restapi.api.model.TokenVerification.service.UserClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {


    EditText edittextUserName, editTextPassword;
   // TextView textView6, textView7, textView8, textView9;
    Button btnLogin;
    String usertoken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_login);

   edittextUserName = findViewById(R.id.editTextUserName);
   editTextPassword = findViewById(R.id.editTextPassword);
  // textView6 = findViewById(R.id.textView6);
  // textView7 = findViewById(R.id.textView7);
  // textView8 = findViewById(R.id.textView8);
  // textView9 = findViewById(R.id.textView9);
   btnLogin = findViewById(R.id.btnLogin);


   btnLogin.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {

           String userId,username, password,projectId;
           username = edittextUserName.getText().toString();
           password = editTextPassword.getText().toString();
           projectId = getProjectId(username);
           userId = getUserIdbyname(username);
           //textView6.setText(userId);
         //  textView7.setText(projectId);
//

           loginUser(userId ,password,projectId);


       }
   });





    }


 public String getUserIdbyname(String username )
 {

     String textFromFile = "";
// Gets the file from the primary external storage space of the
// current application.
     File testFile = new File(this.getExternalFilesDir(null), username+"Id.txt");
     if (testFile != null) {
         StringBuilder stringBuilder = new StringBuilder();
         // Reads the data from the file
         BufferedReader reader = null;
         try {
             reader = new BufferedReader(new FileReader(testFile));
             String line;

             while ((line = reader.readLine()) != null) {
                 textFromFile += line.toString();
                 //textFromFile += "\n";
             }
             reader.close();
         } catch (Exception e) {
             Log.e("ReadWriteFile", "Unable to read the TestFile.txt file.");
         }
     }






     return textFromFile;






 }





    private String getProjectId(String userFileName) {

        String textFromFile = "";
// Gets the file from the primary external storage space of the
// current application.
        File testFile = new File(this.getExternalFilesDir(null), userFileName+"project.txt");
        if (testFile != null) {
            StringBuilder stringBuilder = new StringBuilder();
            // Reads the data from the file
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(testFile));
                String line;

                while ((line = reader.readLine()) != null) {
                    textFromFile += line.toString();
                    //textFromFile += "\n";
                }
                reader.close();
            } catch (Exception e) {
                Log.e("ReadWriteFile", "Unable to read the TestFile.txt file.");
            }
        }




        return textFromFile;





    }


   public void loginUser(String userId, String Password, String projectId)
    {



        List<String> methods = new ArrayList<String>();
        methods.add("password");
        Project project = new Project();
        project.setId(projectId);
        Scope scope = new Scope();
        scope.setProject(project);
        User user = new User();
        user.setId(userId);
        user.setPassword(Password);
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
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
         final String abc = gson.toJson(example);
           //textView8.setText(abc);
        //Example example = new Gson().fromJson(text, Example.class);


        //RequestBody body = RequestBody.create(MediaType.parse("application/json"), text);

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://192.168.0.106:5000/v3/auth/").
                addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        UserClient userClient = retrofit.create(UserClient.class);

        Call<ResponseBody> call= userClient.login(example);


        call.enqueue(new Callback<ResponseBody>() {




            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {



                Headers headers = response.headers();
               String responsebody =response.raw().toString();

                String usertoken = response.headers().get("X-Subject-Token");
                 if(usertoken!= null) {

                     Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                     loginSuccess(usertoken);
                 }
                 //textView8.setText(usertoken);
                 //textView9.setText(responsebody);




                //sendtoGlobal( globalToken);

                //Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //startActivity(intent);
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

                Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });






    }



   public void  loginSuccess(String tokenForward)
    {


        String userTokenForward = tokenForward;

        Intent intent = new Intent(LoginActivity.this, LoginSuccessActivity.class);
        intent.putExtra("token", userTokenForward);

        startActivity(intent);






    }









    }






