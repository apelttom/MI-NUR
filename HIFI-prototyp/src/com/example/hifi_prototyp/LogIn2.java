package com.example.hifi_prototyp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LogIn2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in2);
	}
	
	/** Called when the user clicks the Password reset button */
	public void displayPasswReset(View view) {
		//TODO add context from login form = username
		Intent displayPasswResetForm = new Intent(this, PasswordReset.class);
		startActivity(displayPasswResetForm);
	}
	
	/** Called when the user clicks the Login button */
	public void displayMainMenu(View view) {
		Intent displayPasswResetForm = new Intent(this, MainMenu.class);
		startActivity(displayPasswResetForm);
	}
}
