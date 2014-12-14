package com.example.hifi_prototyp;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class PokerTable extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poker_table);
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		Random randomGenerator = new Random();
		int prob1 = randomGenerator.nextInt(100);
		int prob2 = 100 - prob1;
		TextView myProbability = (TextView)findViewById(R.id.textView_win_prob_2);
		TextView enemyProbability = (TextView)findViewById(R.id.textView_win_prob_1);
		myProbability.setText("Win: "+Integer.toString(prob1)+"%");
		enemyProbability.setText("Win: "+Integer.toString(prob2)+"%");
		setCards();
	}

	public void pickFlop1(View view) {
		goToWheel(false, view.getId());
	}
	public void pickFlop2(View view) {
		goToWheel(false, view.getId());
	}
	public void pickFlop3(View view) {
		goToWheel(false, view.getId());
	}
	public void pickTurn(View view) {
		goToWheel(false, view.getId());
	}
	public void pickRiver(View view) {
		goToWheel(false, view.getId());
	}
	public void pickMyCard1(View view) {
		goToWheel(true, view.getId());
	}
	public void pickMyCard2(View view) {
		goToWheel(true, view.getId());
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
		setCard(R.id.imageButton_card_flop_1, "card_undef_big");
		setCard(R.id.imageButton_card_flop_2, "card_undef_big");
		setCard(R.id.imageButton_card_flop_3, "card_undef_big");
		setCard(R.id.imageButton_card_turn, "card_undef_big");
		setCard(R.id.imageButton_card_river, "card_undef_big");
		setCard(R.id.imageButton_card_myCard_1, "card_undef_small");
		setCard(R.id.imageButton_card_myCard_2, "card_undef_small");
	}
	
	private void setCard(int id, String defaultCard) {
		ImageButton img = (ImageButton)findViewById(id);
		String card;
		if (PickCardWheel.getCardsOnTable().containsKey(id)) {
			int[] indexes = PickCardWheel.getCardsOnTable().get(id);
			card = (indexes == null) ? defaultCard : CardUtils.getCard(indexes[0], indexes[1]);
		} else {
			card = defaultCard;
		}
		img.setImageURI(Uri.parse("android.resource://com.example.hifi_prototyp/drawable//"+card));
	}
	
	private void goToWheel(boolean myCards, int buttonId) {
		Intent displayPasswResetForm = new Intent(this, PickCardWheel.class);
		PickCardWheel.myCards = myCards;
		PickCardWheel.cardFrom = buttonId;
		startActivity(displayPasswResetForm);
	}
}
