package com.example.hifi_prototyp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PokerTable extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poker_table);
	}
	
	/** Called when the user clicks the Back reset button */
	public void closeActivity(View view) {
		finish();
	}
}
