package com.example.findingnod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "logs";
  public static final String EXTRA_MESSAGE = "com.example.findingnod.MESSAGE";
  private static final String KEY_NUM1 = "N1";
  private static final String KEY_NUM2 = "N2";
  int n1,n2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.d(TAG, "Screen has been rotated");
    Log.d(TAG, "a = "+ n1);
    Log.d(TAG, "b = " + n2);
    outState.putInt(KEY_NUM1, n1);
    outState.putInt(KEY_NUM2, n2);
  }

  public void onButtonClick(View view) {

    Intent intent = new Intent(this, DisplayMessageActivity.class);
    EditText num1 = (EditText)findViewById(R.id.editText);
    EditText num2 = (EditText)findViewById(R.id.editText2);

    int res;

    if( num1.getText().toString().equals("") || num2.getText().toString().equals("") ) {
      Log.d(TAG, "there is no data entered");
      res = 0;
    }
      else {
      n1 = Integer.parseInt(num1.getText().toString());
      n2 = Integer.parseInt(num2.getText().toString());
      Log.d(TAG, "NOD of " + n1 + " " + n2);
      int a = n1, b = n2;
      while (b != 0) {
        int c = a % b;
        a = b;
        b = c;
      }
      res = a;
      Log.d(TAG, "NOD is "+ res);
    }




    String message = Integer.toString(res);
    intent.putExtra(EXTRA_MESSAGE, message);
    startActivity(intent);

  }
}