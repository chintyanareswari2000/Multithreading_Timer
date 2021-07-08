package com.example.assignmentlab11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton rb_op1, rb_op2, rb_op3, rb_op4;
    int duration;
    EditText et_ouput, et_name;
    String msg, name;
    Button btn_start, btn_clear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = "";
        name = "";
        rb_op1 = findViewById(R.id.rb_op1);
        rb_op2 = findViewById(R.id.rb_op2);
        rb_op3 = findViewById(R.id.rb_op3);
        rb_op4 = findViewById(R.id.rb_op4);
        btn_start = findViewById(R.id.btn_start);
        btn_clear = findViewById(R.id.btn_clear);
        et_name = findViewById(R.id.et_name);
        et_ouput = findViewById(R.id.et_output);
    }

    public void opSelected(View v){
        switch (v.getId()){
            case R.id.rb_op1:
                duration = 5000;
                break;
            case R.id.rb_op2:
                duration = 10000;
                break;
            case R.id.rb_op3:
                duration = 15000;
                break;
            case R.id.rb_op4:
                duration = 20000;
                break;
        }
    }

    public void btnStartClick(View v){
        name = et_name.getText().toString();
        msg = msg + name + " is Starting ... \n";
        et_ouput.setText(msg);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(duration);
                }catch (Exception e){
                    e.printStackTrace();
                }
                updateUi();
            }
        }).start();
    }

    public void updateUi(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                msg = msg + name + " Has Ended. \n";
                et_ouput.setText(msg);
            }
        });

    }

    public void btnClearClick(View v){
        msg = "";
        et_ouput.setText(msg);
    }

}