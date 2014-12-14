package com.example.hifi_prototyp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Help extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
	}
	
	/** Called when the user clicks the Back button */
	public void closeActivity(View view) {
		finish();
	}
}
