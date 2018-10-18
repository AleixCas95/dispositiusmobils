package com.calc.my_profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {


    private User user_profile;
    private Gson gson;
    private TextView viewname;
    private TextView viewuser;
    private TextView viewfollowingnum;
    private TextView viewfollowersnum;
    private TextView viewabouttext;
    private ImageView profileimageview;
    private ImageView backgroundview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gson = new Gson();

        viewname = findViewById(R.id.name);
        viewuser = findViewById(R.id.alias);
        viewfollowingnum = findViewById(R.id.followingview);
        viewfollowersnum = findViewById(R.id.followersview);
        viewabouttext = findViewById(R.id.about);

        try {
            InputStream stream = getAssets().open("CastilloAleix.json");
            InputStreamReader reader = new InputStreamReader(stream);
            user_profile = gson.fromJson(reader, User.class);

            updateUserInfo();
        }
        catch (IOException e) {
            Toast.makeText(MainActivity.this, "Error parsing json", Toast.LENGTH_SHORT).show();
        }

        profileimageview = findViewById(R.id.profilepick);
        backgroundview = findViewById(R.id.backgroundview);

        Glide.with(this).load("file:///android_asset/foto1.PNG"). apply(RequestOptions.circleCropTransform().circleCrop()).into(profileimageview);
        Glide.with(this).load("file:///android_asset/18.jpg").into(backgroundview);

    }


    private void updateUserInfo() {
        viewname.setText(user_profile.getName() + " " + user_profile.getLastname() );
        viewuser.setText(user_profile.getHandle());
        viewfollowingnum.setText(user_profile.getFollowing());
        viewfollowersnum.setText(user_profile.getFollowers());
        viewabouttext.setText(user_profile.getAbout());
    }


}
