package com.example.findingnod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "logs";
  public static final String EXTRA_MESSAGE = "com.example.findingnod.MESSAGE";
  private static final String KEY_NUM1 = "N1";
  private static final String KEY_NUM2 = "N2";
  int n1,n2,nod;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.d(TAG, "Values saved");
    Log.d(TAG, "a = "+ n1);
    Log.d(TAG, "b = " + n2);
    outState.putInt(KEY_NUM1, n1);
    outState.putInt(KEY_NUM2, n2);
  }

  public void onButtonClick(View view) {

    Intent intent = new Intent(this, DisplayMessageActivity.class);
    EditText num1 = (EditText)findViewById(R.id.editText);
    EditText num2 = (EditText)findViewById(R.id.editText2);

    findNOD otvet = new findNOD();

    if( num1.getText().toString().equals("") || num2.getText().toString().equals("") ) {
      Log.d(TAG, "there is no value entered");
      intent.putExtra(EXTRA_MESSAGE, "NOD is " + 0);
      startActivity(intent);
    }
      else {
      n1 = Integer.parseInt(num1.getText().toString());
      n2 = Integer.parseInt(num2.getText().toString());
      Log.d(TAG, "NOD of " + n1 + " " + n2);
      nod = otvet.res(n1,n2);
      Log.d(TAG, "NOD is " + nod);
      intent.putExtra(EXTRA_MESSAGE,"NOD is " + nod);
      startActivity(intent);
      }
      otvet.showMeList();
    }

    public class findNOD {
      private LinkedList <Integer> ListOfNOD = new LinkedList<Integer>();
      public int res (int n1,int n2){
          ListOfNOD.add(n1);
          ListOfNOD.add(n2);
          while (n2 != 0){
              int c = n1 % n2;
              n1 = n2;
              n2 = c;
          }
          ListOfNOD.add(n1);
          return n1;
      }
        public void showMeList(){
            System.out.println(ListOfNOD);
        }
        public void clearMyList(){
            ListOfNOD.clear();
        }
  }
}