package com.example.intentdemo2b;
// Multi-Activity Application
// mainActivity: collects two data items from the user's UI, places
//			  them into a Bundle, and calls Activity1
// Activity1: accepts two data items, adds them, returns result

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class mainActivity extends Activity {
    EditText txtValue1;
    EditText txtValue2;
	EditText txtValue3;
	EditText txtValue4;
	EditText txtValue5;

    TextView txtResult;
	TextView txtMaxResult;
	TextView txtMinResult;
    Button   btnAdd;
	Button   btnMinus;
    Button   btn3;
    Uri uri = Uri.parse("mdp://gmit.computer.ie/pe1");
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        txtValue1 = (EditText)findViewById(R.id.EditText01);
        txtValue2 = (EditText)findViewById(R.id.EditText02);
		txtValue3 = (EditText)findViewById(R.id.EditText03);
		txtValue4 = (EditText)findViewById(R.id.EditText04);
		txtValue5 = (EditText)findViewById(R.id.EditText05);


        txtResult = (TextView) findViewById(R.id.txtResult);
		txtMaxResult  = (TextView) findViewById(R.id.maxResult);
		txtMinResult  = (TextView) findViewById(R.id.minResult);
        
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// get values from the UI
				//Double v1 = Double.parseDouble(txtValue1.getText().toString());
				//Double v2 = Double.parseDouble(txtValue2.getText().toString());
				
				// create intent to call Activity1
				Intent myIntentA1A2 = new Intent (mainActivity.this,
												  Activity1.class);
				// create a Bundle (MAP) container to ship data
				Bundle myDataBundle = new Bundle();
				
				// add <key,value> data items to the container
				myDataBundle.putDouble("val1", 1.0);
				myDataBundle.putDouble("val2", 2.0);
				myDataBundle.putDouble("val3", 3.0);
				myDataBundle.putDouble("val4", 4.0);
				myDataBundle.putDouble("val5", 5.0);
				
				// attach the container to the intent
				myIntentA1A2.putExtras(myDataBundle);
				
				// call Activity1, tell your local listener to wait a
				// response sent to a listener known as 101
				startActivityForResult(myIntentA1A2, 101);
				
			}
				
		});

		btnMinus = (Button) findViewById(R.id.btnMinus);
		btnMinus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// get values from the UI
				Double v1 = 1.0;
				Double v2 = 2.0;
				Double v3 = 3.0;
				Double v4 = 4.0;
				Double v5 = 5.0;
                //Double [] swap = new Double [5];

//				 v1 = Double.parseDouble(txtValue1.getText().toString());
//                 v2 = Double.parseDouble(txtValue2.getText().toString());
//				 v3 = Double.parseDouble(txtValue3.getText().toString());
//				 v4 = Double.parseDouble(txtValue4.getText().toString());
//				 v5 = Double.parseDouble(txtValue5.getText().toString());

                String v1s = (txtValue1.getText().toString());
                if( v1s == null)
                    v1 = 0.0;
                else
                    v1 = Double.parseDouble(txtValue1.getText().toString());

                String v2s = (txtValue2.getText().toString());
                if( v2s == null)
                    v2 = 0.0;
                else
                    v2 = Double.parseDouble(txtValue2.getText().toString());

                String v3s = (txtValue3.getText().toString());
                if( v3s == null)
                    v3 = 0.0;
                else
                    v3 = Double.parseDouble(txtValue3.getText().toString());

                String v4s = (txtValue3.getText().toString());
                if( v4s == null)
                    v4 = 0.0;
                else
                    v4 = Double.parseDouble(txtValue4.getText().toString());

                String v5s = (txtValue3.getText().toString());
                if( v5s == null)
                    v5 = 0.0;
                else
                    v5 = Double.parseDouble(txtValue5.getText().toString());


				double [] array = new double [5];

				array[0] = v1;
				array[1] = v2;
				array[2] = v3;
				array[3] = v4;
				array[4] = v5;

				// create intent to call Activity2
				Intent myIntentA1A2 = new Intent (mainActivity.this,
						Activity2.class);
				// create a Bundle (MAP) container to ship data
				Bundle myDataBundle = new Bundle();

				myDataBundle.putDouble("val1", v1);
				myDataBundle.putDouble("val2", 2.0);
				myDataBundle.putDouble("val3", 3.0);
				myDataBundle.putDouble("val4", 4.0);
				myDataBundle.putDouble("val5", 5.0);

				myDataBundle.putDoubleArray("array", array);

				// attach the container to the intent
				myIntentA1A2.putExtras(myDataBundle);

				// call Activity1, tell your local listener to wait a
				// response sent to a listener known as 101
				startActivityForResult(myIntentA1A2, 102);

			}

		});

        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("mdp://gmit.computer.ie/pe1");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setType("Activity3");
               // startActivity(intent);

                txtResult.setText("Sum from act3: " );
                txtMaxResult.setText("max from act 3: " );
                txtMinResult.setText("min from act 3: " );

            }

        });
    }//onCreate

    //////////////////////////////////////////////////////////////////////////////
    // local listener receives callbacks from other activities
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		try	{
			if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
				Bundle myResultBundle = data.getExtras();
				Double sumResult = myResultBundle.getDouble("sumResult");
				Double maxResult = myResultBundle.getDouble("maxResult");
				Double minResult = myResultBundle.getDouble("minResult");

				txtResult.setText("Sum from act1: " + sumResult);
				txtMaxResult.setText("max from act 1: " + maxResult);
				txtMinResult.setText("min from act 1: " + minResult);
			}
			if ((requestCode == 102 ) && (resultCode == Activity.RESULT_OK)){
				Bundle myResultBundle = data.getExtras();
				Double sumResult = myResultBundle.getDouble("sum");
                Double maxResult = myResultBundle.getDouble("maxResult");
                Double minResult = myResultBundle.getDouble("minResult");

                txtMaxResult.setText("max from act 2: " + maxResult);
                txtMinResult.setText("min from act 2: " + minResult);
				txtResult.setText("sum from act 2: " + sumResult);
			}
		}
		catch (Exception e) {
			txtResult.setText("Problems - " + requestCode + " " + resultCode);
		}
	}//onActivityResult
    
}//mainActivity