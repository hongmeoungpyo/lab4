package com.example.hong.a0418_lab4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    RadioGroup radioGroup;
    RadioButton radMan;
    RadioButton radWoman;
    CheckBox chkSms;
    CheckBox chkE_mail;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.nameText);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupSex);
        radMan = (RadioButton) findViewById(R.id.man);
        radWoman = (RadioButton) findViewById(R.id.woman);
        chkSms = (CheckBox) findViewById(R.id.sms);
        chkE_mail = (CheckBox) findViewById(R.id.email);
        button = (Button) findViewById(R.id.button);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                Bundle mybundle=new Bundle();
                //bundle(mybundle) 에 string 객체인 name 에 edittext의 입력 값을 put
                mybundle.putString("name",editText.getText().toString());

                //bundle에 radio select 한 값을 gender 에 string type으로 put
                int radioId = radioGroup.getCheckedRadioButtonId();
                if(radMan.getId()==radioId){
                    mybundle.putString("gender", radMan.getText().toString());
                }
                else if(radWoman.getId()==radioId){
                    mybundle.putString("gender",radWoman.getText().toString());
                }

                Toast.makeText(getApplicationContext(),radioId+"",Toast.LENGTH_SHORT).show();

                //bundle에 checked한 값을 receive에 put
                if(chkSms.isChecked()){
                    mybundle.putString("receive",chkSms.getText().toString());
                }
                if(chkE_mail.isChecked()){
                    mybundle.putString("receive2",chkE_mail.getText().toString());
                }

                //intent에 앞에서 만든 bundle객에를 넣어주고 activity를 실행시킨다.
                intent.putExtras(mybundle);
                startActivity(intent);
            }
        });

    }
}


