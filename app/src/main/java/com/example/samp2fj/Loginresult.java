package com.example.samp2fj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Loginresult extends AppCompatActivity {
    TextView Textview_get1;
    TextView Textview_get2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Textview_get1=findViewById(R.id.Textview_get3);
        Textview_get2=findViewById(R.id.Textview_get4);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String email = bundle.getString("email");
        String password= bundle.getString("password");

        Textview_get1.setText(email);
        Textview_get2.setText(password);

    }
}
