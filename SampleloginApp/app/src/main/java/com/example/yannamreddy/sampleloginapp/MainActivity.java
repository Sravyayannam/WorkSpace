package com.example.yannamreddy.sampleloginapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


        Button b1,b2;
        EditText ed1,ed2;

        TextView tx1;
        int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = (Button)findViewById(R.id.button);
            ed1 = (EditText)findViewById(R.id.editText);
            ed2 = (EditText)findViewById(R.id.editText2);

            b2 = (Button)findViewById(R.id.button2);
            tx1 = (TextView)findViewById(R.id.textView3);
            tx1.setVisibility(View.GONE);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(ed1.getText().toString().equals("admin") &&
                            ed2.getText().toString().equals("admin")) {
                        Toast.makeText(getApplicationContext(),
                                "Redirecting...", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(this, home.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                                tx1.setVisibility(View.VISIBLE);
                        tx1.setBackgroundColor(Color.RED);
                        counter--;
                        tx1.setText(Integer.toString(counter));

                        if (counter == 0) {
                            b1.setEnabled(false);
                        }
                    }
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
    }
}