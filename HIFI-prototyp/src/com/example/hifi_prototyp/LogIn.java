package com.example.hifi_prototyp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class LogIn extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.log_in, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
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
