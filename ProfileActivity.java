package com.example.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    TextView profileText;
    Button  button4;
    Button button6;
    TextView tvAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        auth = FirebaseAuth.getInstance();
        profileText = (TextView)findViewById(R.id.textView);

        user = auth.getCurrentUser();
        profileText.setText(user.getEmail());
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener( View -> {
            Intent intent=new Intent(this,MapsActivity.class);
            startActivity(intent);
        });
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener( View -> {
            Intent intent = new Intent(this, TownActivity.class);
            startActivity(intent);
        });
        tvAboutUs = findViewById(R.id.tvAboutUs);
        tvAboutUs.setOnClickListener( View -> {
            Intent intent = new Intent(this, AboutUsActivity.class);
            startActivity(intent);
        });

    }

    public void signout(View v){
        auth.signOut();
        finish();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);

    }
}