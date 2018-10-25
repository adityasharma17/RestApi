package com.example.server.restapi;

import android.content.Intent;
import android.media.MediaScannerConnection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.server.restapi.Project.ProjectPost.GetProject.GetDataProject;
import com.example.server.restapi.Project.ProjectPost.PostDataProject;
import com.example.server.restapi.Project.ProjectPost.Project;
import com.example.server.restapi.Project.ProjectPost.service.CreateProject;
import com.example.server.restapi.UserFormation.AssignRolesToUser;
import com.example.server.restapi.UserFormation.CreateUser;
import com.example.server.restapi.UserFormation.CreateUsers;
import com.example.server.restapi.UserFormation.GetDataUser.UserDataFromRequest;
import com.example.server.restapi.UserFormation.User;
import com.example.server.restapi.UserFormation.UserInfo;
import com.example.server.restapi.api.model.TokenVerification.MyToken;
import com.example.server.restapi.Images.GetImages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class Main2Activity extends AppCompatActivity {

// currently No database is used. The credential of user is stored on a file created in isolated space of the mobile application.
    //Contents from the file is used for login process.
    //This is the register user activity.

    ArrayList<String> userList = new ArrayList<String>();


   // TextView textView2,textView3;
    String loginToken;
    Button loginBtn, createBtn;
EditText editUserName, editPassword, editProjectName;
   // String ProjectId;
    //String userID;
    String Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        userList.add("Aditya121");




        setContentView(R.layout.activity_main2);


       // textView2 = findViewById(R.id.textView2);
        loginBtn = findViewById(R.id.loginBtn);
        createBtn = findViewById(R.id.createBtn);
        editUserName = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        editProjectName = findViewById(R.id.editProjectName);
       // loginToken = getIntent().getStringExtra("tok");
        //textView2.setText(loginToken);
        //getImages(loginToken);
       // textView3 = findViewById(R.id.textView3);
     // textView2.setText(MyToken.loginToken);
      loginToken = MyToken.loginToken;

      createBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //textView2.setText(MainActivity.globalToken);
              if(!userList.contains(editUserName.getText().toString()))
              {userList.add(editUserName.getText().toString());
                  createProject(loginToken);



              }
              else{

                  Toast.makeText(Main2Activity.this, "Username already exists", Toast.LENGTH_SHORT).show();

              }


              //createuser("Aditya121", "6790", loginToken, UserInfo.getInstance().getProjectId());
              // assignRole(MyToken.UserId, MyToken.projectId, loginToken);

          }
      });

      loginBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent intent = new Intent(Main2Activity.this, LoginActivity.class);
              startActivity(intent);


          }
      });







    }


    public void createuser(String username, String password , String token, final String projectId)
    {


      //textView3.setText(projectId);

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://192.168.0.106:5000").
                addConverterFactory(GsonConverterFactory.create());


        Retrofit user = builder.build();

        CreateUsers  createUsers = user.create(CreateUsers.class);

        User myuser = new User();
        myuser.setDefaultProjectId(projectId);
        myuser.setName(username);
        myuser.setPassword(password);
        myuser.setDomainId("default");
        myuser.setDescription("to be added");
        myuser.setEmail("to be added");
        CreateUser createmyuser = new CreateUser();
        createmyuser.setUser(myuser);

        Call<UserDataFromRequest>  getUserDataCall =  createUsers.createUser(token, createmyuser);
        getUserDataCall.enqueue(new Callback<UserDataFromRequest>() {
            @Override
            public void onResponse(Call<UserDataFromRequest> call, Response<UserDataFromRequest> response) {

                String userId =  response.body().getUser().getId();

                assignRole(userId, projectId, loginToken);
                //final String pro = projectId;
               // assignRole(userId, loginToken);
                //storeUserId(userId);
              // textView3.setText(userId);




            }

            @Override
            public void onFailure(Call<UserDataFromRequest> call, Throwable t) {

            }
        });

        }


    public void  createProject(String token)
    {


        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://192.168.0.106:5000").
                addConverterFactory(GsonConverterFactory.create());

        Retrofit project = builder.build();

       CreateProject createProject =  project.create(CreateProject.class);
        String projectname = editProjectName.getText().toString();

        Project postProject =  new Project();
        postProject.setName(projectname);
        postProject.setDomainId("default");
        postProject.setDescription("Aive hi");
        PostDataProject post = new PostDataProject();
        post.setProject(postProject);





        Call<GetDataProject> getDataProjectCall =  createProject.makeProject(token, post);

        getDataProjectCall.enqueue(new Callback<GetDataProject>() {
            @Override
            public void onResponse(Call<GetDataProject> call, Response<GetDataProject> response) {


                //Gson gson = new GsonBuilder().setPrettyPrinting().create();
               // final String abc = gson.toJson(response);
               //String token = response.headers().toString();

               String projectId = response.body().getProject().getId();

                storeProjectId(projectId);
               // textView3.setText(projectId);


            }

            @Override
            public void onFailure(Call<GetDataProject> call, Throwable t) {

            }
        });



        }


        public void assignRole(String myUserId, String projectID,  String token)

        {     //textView3.setText(myUserId);
            storeUserId(myUserId);

            Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://192.168.0.106:5000").
                    addConverterFactory(GsonConverterFactory.create());


            Retrofit roles = builder.build();
            AssignRolesToUser assignRolesToUser = roles.create(AssignRolesToUser.class);
            Call<ResponseBody> getRolesResponse = assignRolesToUser.assignRoles(projectID, myUserId, "020edc58a02048e8b36d76d792ad9c39", token);


            getRolesResponse.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    String raw = response.raw().toString();
                   // textView3.setText(raw);
                    Toast.makeText(Main2Activity.this, "User Created", Toast.LENGTH_SHORT).show();


                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {


                    Toast.makeText(Main2Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            }


    public void storeProjectId(String id)
    {    UserInfo.projectId = id;
         String projectId = id;
         String user,password;




         user = editUserName.getText().toString();
         password = editPassword.getText().toString();



        try {
            // Creates a file in the primary external storage space of the
            // current application.
            // If the file does not exists, it is created.
            File testFile = new File(this.getExternalFilesDir(null), user+"project.txt");
            if (!testFile.exists())
                testFile.createNewFile();

            // Adds a line to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(testFile, true /*append*/));
            writer.write(id);
            writer.close();
            // Refresh the data so it can seen when the device is plugged in a
            // computer. You may have to unplug and replug the device to see the
            // latest changes. This is not necessary if the user should not modify
            // the files.
            MediaScannerConnection.scanFile(this,
                    new String[]{testFile.toString()},
                    null,
                    null);
        } catch (IOException e) {
            Log.e("ReadWriteFile", "Unable to write to the TestFile.txt file.");
        }











        createuser(user, password, loginToken, projectId);



    }
    public void storeUserId(String id)
    {
       UserInfo.userId = id;
       String user = editUserName.getText().toString();
        try {
            // Creates a file in the primary external storage space of the
            // current application.
            // If the file does not exists, it is created.
            File testFile = new File(this.getExternalFilesDir(null), user+"Id.txt");
            if (!testFile.exists())
                testFile.createNewFile();

            // Adds a line to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(testFile, true /*append*/));
            writer.write(id);
            writer.close();
            // Refresh the data so it can seen when the device is plugged in a
            // computer. You may have to unplug and replug the device to see the
            // latest changes. This is not necessary if the user should not modify
            // the files.
            MediaScannerConnection.scanFile(this,
                    new String[]{testFile.toString()},
                    null,
                    null);
        } catch (IOException e) {
            Log.e("ReadWriteFile", "Unable to write to the TestFile.txt file.");
        }

        ///textView3.setText(MyToken.UserId);
    }




}
