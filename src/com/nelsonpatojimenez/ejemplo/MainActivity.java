package com.nelsonpatojimenez.ejemplo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private final static String TAG = "Debug";
	private String status_message;
	private TextView txt_msg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txt_msg = (TextView)findViewById(R.id.txt_msg);
		
		status_message = "Estado: OnCreate";
		txt_msg.setText(status_message);
		
		Log.e(TAG, status_message);

		Button btn_open = (Button)findViewById(R.id.btn_open);
		Button btn_close = (Button)findViewById(R.id.btn_close);
		
		btn_open.setOnClickListener(new OpenButtonOnClickListener());
		btn_close.setOnClickListener(new CloseButtonOnClickListener());
		
		
		Button btn_submit = (Button) findViewById(R.id.btn_submit);
		btn_submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e(TAG, "hizo click");
				Toast.makeText(getApplicationContext(), "hizo click", Toast.LENGTH_SHORT).show();
				
				EditText edit_name = (EditText)findViewById(R.id.edit_name);
				TextView txt_name = (TextView)findViewById(R.id.txt_msg);
				
				txt_name.setText("Hola " + edit_name.getText());

			}
		});
	}
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		status_message = "Estado: onDestroy";
		txt_msg.setText(status_message); 
		Log.e(TAG, status_message);
		
		super.onDestroy();
	}


	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		status_message = "Estado: onRestart";
		txt_msg.setText(status_message);
		Log.e(TAG, status_message);
		
		super.onRestart();
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		status_message = "Estado: onResume";
		txt_msg.setText(status_message);
		Log.e(TAG, status_message);
		
		super.onResume();
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		status_message = "Estado: onStart";
		txt_msg.setText(status_message);
		Log.e(TAG, status_message);
		super.onStart();
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		status_message = "Estado: onStop";
		txt_msg.setText(status_message);
		Log.e(TAG, status_message);
		
		super.onStop();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	class CloseButtonOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();
			
		}
		
	}
	
	class OpenButtonOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(getApplicationContext(), SecondActivity.class);
			startActivity(i);
		}
		
	}
}
