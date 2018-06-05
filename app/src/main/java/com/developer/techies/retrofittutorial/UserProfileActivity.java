package com.developer.techies.retrofittutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class UserProfileActivity extends AppCompatActivity {

    Toolbar toolbar;

    ImageView mPhoto;
    TextView nameTv;
    TextView reputationTv;

    String userPhoto;
    String userName;
    String userReputation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        getSupportActionBar().setElevation(1);
        setTitle("Users Profile");

        initView();
        initData();
    }

    public void initView() {
        mPhoto = findViewById(R.id.photo);
        nameTv = findViewById(R.id.name_view);
        reputationTv = findViewById(R.id.reputation_view);
    }

    public void initData() {
        userPhoto = getIntent().getStringExtra("user_picture");
        userName = getIntent().getStringExtra("user_name");
        userReputation = getIntent().getStringExtra("user_reputation");


        if (userPhoto != null)
            Picasso.with(this).load(userPhoto).placeholder(R.drawable.ic_launcher_background).into(mPhoto);
        nameTv.setText(userName);
        reputationTv.setText("REPUTATION ==> "+userReputation);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
