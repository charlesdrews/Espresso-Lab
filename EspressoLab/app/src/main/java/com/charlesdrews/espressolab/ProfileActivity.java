package com.charlesdrews.espressolab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView name = (TextView) findViewById(R.id.name);
        TextView email = (TextView) findViewById(R.id.email_address);

        name.setText("Kyle McNee");
        email.setText("kyle@red.beard");
    }
}
