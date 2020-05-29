package com.example.samp2fj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {
    EditText passwordtext,emailtext;
    RelativeLayout loginbutton;
    String idok="RR";
    String passwdok="1196";

    String inputid="";
    String inputpasswd="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailtext=findViewById(R.id.emailtext);
        passwordtext=findViewById(R.id.passwordtext);
        loginbutton=findViewById(R.id.loginbutton);

        //1.값을 가져온다.-검사를 한다 (1234@gmail.co /7896)-아예 틀린 값에서는 화면이 비활성화 된다.
        //2.클릭을 감지한다
        //3.1번의 값을 다음 액티비티로 넘긴다.
        loginbutton.setClickable(false);
        emailtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s != null) {
                    inputid = s.toString();
                    loginbutton.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passwordtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s != null) {
                    inputpasswd = s.toString();
                    loginbutton.setEnabled(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //loginbutton.setClickable(true);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailtext.getText().toString();
                String password=passwordtext.getText().toString();

                Intent intent = new Intent(MainActivity.this , Loginresult.class);
                intent.putExtra( "email",email);
                intent.putExtra( "password",password);
                startActivity(intent);
            }
        });

    }
    public boolean validation(){
        return inputid.equals(idok)&& inputpasswd.equals(passwdok);
    }
}
