package com.example.hong.a0418_lab4;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Main2Activity extends AppCompatActivity {

   TextView textView;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView)findViewById(R.id.textView);

        Intent myIntent = getIntent(); //my intent get
        Bundle myBundle = myIntent.getExtras(); // intent 를 bundle(mybundle)에 get
        String name = myBundle.getString("name"); //string type에 name value에 bundle에 name 값을 get
        String sex = myBundle.getString("gender");
        String call = myBundle.getString("receive");
        String call2 = myBundle.getString("receive2");


       textView .setText("성명       : "+name+"\n성별       : "+sex+"\n수신여부:"+call+" "+call2); //bundle에서 꺼내온 value textView 출력

        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
