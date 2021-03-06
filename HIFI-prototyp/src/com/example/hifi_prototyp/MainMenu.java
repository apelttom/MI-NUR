package com.example.hifi_prototyp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void clickPlay(View view) {
		Intent main = new Intent(this, PokerTable.class);
		startActivity(main);
	}
	
	public void clickProfile(View view) {
		Intent main = new Intent(this, UserProfile.class);
		startActivity(main);
	}
	
	public void clickHelp(View view) {
//		Intent main = new Intent(this, MainMenu.class);
//		startActivity(main);
	}
	
	/** Called when the user clicks the Back button */
	public void closeActivity(View view) {
		finish();
	}
	
	/** Called when the user clicks the Feedback button */
	public void clickFeedback(View view) {
		Intent feedback = new Intent(this, Feedback.class);
		startActivity(feedback);
	}
	
	/** Called when the user clicks the Help button */
	public void displayHelp(View view) {
		Intent displayHelp = new Intent(this, Help.class);
		startActivity(displayHelp);
	}
}
