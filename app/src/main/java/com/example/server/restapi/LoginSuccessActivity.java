package com.example.server.restapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.server.restapi.Images.GetImagesActivity;
import com.example.server.restapi.Servers.CreateServers.CreateServerActivity;
import com.example.server.restapi.Servers.ListSrervers.ListServerAcitivity;
import com.example.server.restapi.api.model.TokenVerification.MyToken;

public class LoginSuccessActivity extends AppCompatActivity {

    TextView textView2;
    Button getServersbtn,getImagesBtn,createServerBtn;
    ImageView imageview4;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_login_success);
textView2 = findViewById(R.id.textView2);
        Bundle extras = getIntent().getExtras();
        String userToken = extras.getString("token");
        MyToken.userToken= userToken;
     //textView10.setText(userToken);
     getServersbtn = findViewById(R.id.getServersBtn);
     getImagesBtn = findViewById(R.id.getImagesBtn);
     createServerBtn = findViewById(R.id.btnCreateServer);
     imageview4 = findViewById(R.id.imageView4);


     createServerBtn.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(LoginSuccessActivity.this , CreateServerActivity.class);
             startActivity(intent);

         }
     });

     getServersbtn.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {

             Intent intent = new Intent(LoginSuccessActivity.this , ListServerAcitivity.class);
             startActivity(intent);

         }
     });


     getImagesBtn.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {

             Intent intent = new Intent(LoginSuccessActivity.this, GetImagesActivity.class);
             startActivity(intent);



         }
     });


    }




}
