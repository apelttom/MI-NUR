package com.example.hifi_prototyp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class LogIn2 extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in2);
	}
	
	/** Called when the user clicks the Password reset button */
	public void displayPasswReset(View view) {
		EditText username = (EditText)findViewById(R.id.editText_register_username);
		Intent displayPasswResetForm = new Intent(this, PasswordReset.class);
		displayPasswResetForm.putExtra("USERNAME", username.getText().toString());
		startActivity(displayPasswResetForm);
	}
	
	/** Called when the user clicks the Login button */
	public void displayMainMenu(View view) {
		EditText username = (EditText)findViewById(R.id.editText_register_username);
		EditText password = (EditText)findViewById(R.id.editText_register_passw);
		if(username.getText().toString().equals("")){
			username.setError("Doesn't exist");
		} else if (password.getText().toString().equals("")){
			password.setError("Not valid");
		}else{
			Intent displayMainMenu = new Intent(this, MainMenu.class);
			startActivity(displayMainMenu);
		}
	}
	
	/** Called when the user clicks the Login button */
	public void displayRegistration(View view) {
		Intent displayRegistration = new Intent(this, RegisterUser.class);
		startActivity(displayRegistration);
	}

}
