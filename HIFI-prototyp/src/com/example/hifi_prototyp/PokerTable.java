package com.example.hifi_prototyp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PokerTable extends Activity {
	
	private static ImageButton active = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poker_table);
	}
	
	public void pickFlop1(View view) {
		Intent displayPasswResetForm = new Intent(this, PickCard.class);
		startActivity(displayPasswResetForm);
		active = (ImageButton)findViewById(R.id.imageButton_card_flop_1);
	}
	public void pickFlop2(View view) {
		Intent displayPasswResetForm = new Intent(this, PickCard.class);
		startActivity(displayPasswResetForm);
		active = (ImageButton)findViewById(R.id.imageButton_card_flop_2);
	}
	public void pickFlop3(View view) {
		Intent displayPasswResetForm = new Intent(this, PickCard.class);
		startActivity(displayPasswResetForm);
		active = (ImageButton)findViewById(R.id.imageButton_card_flop_3);
	}
	public void pickTurn(View view) {
		Intent displayPasswResetForm = new Intent(this, PickCard.class);
		startActivity(displayPasswResetForm);
		active = (ImageButton)findViewById(R.id.imageButton_card_turn);
	}
	public void pickRiver(View view) {
		Intent displayPasswResetForm = new Intent(this, PickCard.class);
		startActivity(displayPasswResetForm);
		active = (ImageButton)findViewById(R.id.imageButton_card_river);
	}
	
	/** Called when the user clicks the Back reset button */
	public void closeActivity(View view) {
		finish();
	}

	public static void setCard(String card) {
		if (active != null) {
			active.setImageURI(Uri.parse("android.resource://com.example.hifi_prototyp/drawable//"+card));
			active = null;
		}
	}
}
