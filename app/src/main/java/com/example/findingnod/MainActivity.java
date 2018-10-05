package com.example.findingnod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "logs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {

        EditText num1 = (EditText)findViewById(R.id.editText);
        EditText num2 = (EditText)findViewById(R.id.editText2);
        TextView result = (TextView)findViewById(R.id.result);

        int n1 = Integer.parseInt(num1.getText().toString());
        int n2 = Integer.parseInt(num2.getText().toString());
        int res;

        Log.d(TAG, "NOD OF NUM " + n1 + " " + n2);
        int a = n1;
        int b = n2;

        while (b != 0){
           int c = a % b;
           a = b;
           b = c;
        }
        res = a;
        Log.d(TAG, "NOD = " + res);
        result.setText(Integer.toString(res));
    }
}
