package com.example.hifi_prototyp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PokerTable extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poker_table);
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		setCards();
	}

	public void pickFlop1(View view) {
		goToWheel();
	}
	public void pickFlop2(View view) {
		goToWheel();
	}
	public void pickFlop3(View view) {
		goToWheel();
	}
	public void pickTurn(View view) {
		goToWheel();
	}
	public void pickRiver(View view) {
		goToWheel();
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

	private void setCards() {
		setCard(R.id.imageButton_card_flop_1);
		setCard(R.id.imageButton_card_flop_2);
		setCard(R.id.imageButton_card_flop_3);
		setCard(R.id.imageButton_card_turn);
		setCard(R.id.imageButton_card_river);
	}
	
	private void setCard(int id) {
		ImageButton img = (ImageButton)findViewById(id);
		String card;
		if (PickCardWheel.getCardsOnTable().containsKey(id)) {
			int[] indexes = PickCardWheel.getCardsOnTable().get(id);
			card = (indexes == null) ? "card_undef_big" : CardUtils.getCard(indexes[0], indexes[1]);
		} else {
			card = "card_undef_big";
		}
		img.setImageURI(Uri.parse("android.resource://com.example.hifi_prototyp/drawable//"+card));
	}
	
	private void goToWheel() {
		Intent displayPasswResetForm = new Intent(this, PickCardWheel.class);
		startActivity(displayPasswResetForm);
	}
}
