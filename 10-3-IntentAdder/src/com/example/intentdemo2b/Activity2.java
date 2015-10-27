package com.example.intentdemo2b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends Activity implements OnClickListener{
    EditText dataReceived;
    Button  btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        dataReceived = (EditText) findViewById(R.id.etDataReceived);
        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);

        // pick call made to Activity1 via Intent
        Intent myLocalIntent = getIntent();

        // look into the bundle sent to Activity1 for data items
        Bundle myBundle =  myLocalIntent.getExtras();

        double [] array = myBundle.getDoubleArray("array");

        double min = 0.0;
        double max = 1.0;

        //Double v2 = myBundle.getDouble("val2");

        // operate on the input data
        //Double vResult =  v1 + v2;
        //Double v1 = 1.0;
        //Double v2 = 2.0;

        // for illustration purposes. show data received & result
        dataReceived.setText("Data in array :   \n"
                + "val1= " + array[0] + "\nval2= " + array[1]
                        + "\nval3= " + array[2] + "\nval4= " + array[3]
                        + "\nval4= " + array[4]);


     //   );
              //  + "\n\nMinus result= " + vResult);

        double sum = array [0] + array[1] + array [2] + array[3] + array [4];


        max = array [0];
        for(int i = 0; i < 5; i ++){
            if (max < array[i])
                max = array [i];
        }

        min = array[0];
        for(int i = 0; i < 5; i ++){
            if (min > array[i])
                min = array [i];
        }

        // add to the bundle the computed result
        myBundle.putDouble("sum", sum);
        myBundle.putDouble("maxResult", max);
        myBundle.putDouble("minResult", min);

        // attach updated bumble to invoking intent
        myLocalIntent.putExtras(myBundle);

        // return sending an OK signal to calling activity
        setResult(Activity.RESULT_OK, myLocalIntent);

        // experiment: remove comment
        // finish();

    }//onCreate

    @Override
    public void onClick(View v) {
        // close current screen - terminate Activity1
        finish();
    }

}
