package com.example.hifi_prototyp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PasswordReset extends Activity {

	public static String PASSWD_RESET_USERNAME = "PASSWD_RESET_USERNAME";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_password_reset);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    String passedDown = extras.getString("USERNAME");
		    EditText username = (EditText)findViewById(R.id.editText_passres_username);
		    username.setText(passedDown);
		}
	}
	
	/** Called when the user clicks the Back button */
	public void closeActivity(View view) {
		finish();
	}
	
	/** Called when the user clicks the Back button */
	public void resetPasswd(View view) {
		EditText username = (EditText)findViewById(R.id.editText_passres_username);
		EditText email = (EditText)findViewById(R.id.editText_passres_email);
		if(username.getText().toString().equals("")){
			username.setError("Doesn't exist");
		} else if (email.getText().toString().equals("")){
			email.setError("Doesn't exist");
		}else{
//			Intent resultIntent = new Intent();
//			resultIntent.putExtra(PASSWD_RESET_USERNAME, username.getText().toString());
//			setResult(Activity.RESULT_OK, resultIntent);
			new AlertDialog.Builder(this)
		    .setTitle("Confirmation")
		    .setMessage("New password has been sent to your email.")
		    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		        	finish();
		        }
		     })
		    .setIcon(android.R.drawable.ic_dialog_info)
		    .show();
		}
	}
}