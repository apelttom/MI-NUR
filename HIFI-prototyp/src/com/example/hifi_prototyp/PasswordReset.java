package com.example.hifi_prototyp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PasswordReset extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_password_reset);
	}
	
	/** Called when the user clicks the Back reset button */
	public void closeActivity(View view) {
		finish();
	}
}
