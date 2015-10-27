package com.example.intentdemo2b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends Activity implements OnClickListener{
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
		Double v1 = myBundle.getDouble("val1");
		Double v2 = myBundle.getDouble("val2");
		Double v3 = myBundle.getDouble("val3");
		Double v4 = myBundle.getDouble("val4");
		Double v5 = myBundle.getDouble("val5");

		double[] array = new double [5];
		array[0] = v1;
		array[1] = v2;
		array[2] = v3;
		array[3] = v4;
		array[4] = v5;
		
		// operate on the input data
		Double sumResult =  v1 + v2 + v3 + v4 + v5;
		Double max = array [0];

		for(int i = 0; i < 5; i ++){
			if (max < array[i])
				max = array [i];
		}

		Double min = array[0];
		for(int i = 0; i < 5; i ++){
			if (min > array[i])
				min = array [i];
		}
		
		// for illustration purposes. show data received & result
		dataReceived.setText("Data received is \n"
				+ "val1= " + v1 + "\nval2= " + v2
				+ "\nval3= " + v3 + "\nval4= " + v4
				+ "\nval5= " + v5);
				//+ "\n\nresult= " + vResult);
		
		// add to the bundle the computed result  
		myBundle.putDouble("sumResult", sumResult);

		myBundle.putDouble("maxResult", 5);
		myBundle.putDouble("minResult", 1);
		
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
