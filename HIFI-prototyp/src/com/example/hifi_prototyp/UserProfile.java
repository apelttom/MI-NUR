package com.example.hifi_prototyp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class UserProfile extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);
	}
	
	/** Called when the user clicks the Back reset button */
	public void closeActivity(View view) {
		finish();
	}
	
	/** Called when the user clicks the Help reset button */
	public void displayHelp(View view) {
		Intent displayHelp = new Intent(this, Help.class);
		startActivity(displayHelp);
	}
}
