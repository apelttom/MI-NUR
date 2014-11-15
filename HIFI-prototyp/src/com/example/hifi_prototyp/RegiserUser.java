package com.example.hifi_prototyp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class RegiserUser extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}
	
	/** Called when the user clicks the Back reset button */
	public void closeActivity(View view) {
		finish();
	}
}
