package com.example.hifi_prototyp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PickCardWheel extends Activity {

	private int cx, cy, inner, border;
	private double angle, distance;
	private final double section = 360.0 / 14;
	private boolean isKind, isValue;
	private int selectedKind = -1, selectedValue = -1;
	private Integer activeId;
	
	private List<Integer> cardButtons = new ArrayList<Integer>();
	private static Map<Integer, int[]> placedCards = new HashMap<>();
	private static Map<String, List<Integer>> unavailableCards;
	static {
		unavailableCards = new HashMap<>(4);
		unavailableCards.put("s", new ArrayList<Integer>(13));
		unavailableCards.put("h", new ArrayList<Integer>(13));
		unavailableCards.put("c", new ArrayList<Integer>(13));
		unavailableCards.put("d", new ArrayList<Integer>(13));
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pick_card_wheel);
		activeId = R.id.imageButton_card_flop_1;
		cardButtons.add(R.id.imageButton_card_flop_1);
		cardButtons.add(R.id.imageButton_card_flop_2);
		cardButtons.add(R.id.imageButton_card_flop_3);
		cardButtons.add(R.id.imageButton_card_turn);
		cardButtons.add(R.id.imageButton_card_river);
		
		ImageView img = (ImageView)findViewById(R.id.card_wheel);
		img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
            	int x = (int) event.getX();
            	int y = (int) event.getY();
            	angle = Math.toDegrees(Math.atan2(y-cy, x-cx));
            	angle += angle < 0 ? 360 : 0;
        		distance = Math.sqrt((x-cx)*(x-cx) + (y-cy)*(y-cy));
        		return false;
            }
		});
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		ImageView img = (ImageView)findViewById(R.id.card_wheel);
		cx = img.getWidth()/2;
		cy = img.getHeight()/2;
		border = Math.min(cx, cy);
		inner = border / 2;
		setCards();
	}

	public void pickCard(View view) {
//		String msg = (distance < inner) ? "inner "+(int)(angle/90) : "outer "+(int)(angle/section);
		if (distance < inner) {
			//inner
			int index = (int)(angle/90);
			if (isValue) {
				if (unavailableCards.get(CardUtils.getKind(index)).contains(new Integer(selectedValue))) {
					//card already used
					resetSelect();
					System.out.println("already selected "+CardUtils.getCard(index, selectedValue));
				} else {
					//play card
					selectedKind = index;
					play(selectedKind, selectedValue);
				}
			} else {
				//select kind
				isKind = true;
				selectedKind = index;
			}
		} else {
			if (distance < border) {
				//outer
				int index = (int) (angle / section);
				if (index == 13) {
					//cancel
					resetCard();
					return;
				}
				if (isKind) {
					if (unavailableCards.get(CardUtils.getKind(selectedKind)).contains(new Integer(index))) {
						//card already used
						resetSelect();
						System.out.println("already selected "+CardUtils.getCard(selectedKind, index));
					} else {
						//play card
						selectedValue = index;
						play(selectedKind, selectedValue);
					}
				} else {
					//select value
					isValue = true;
					selectedValue = index;
				}
			}
		}
		paintSelect();
	}
	
	public void pickFlop1(View view) {
		activeId = R.id.imageButton_card_flop_1;
		resetSelect();
	}
	public void pickFlop2(View view) {
		activeId = R.id.imageButton_card_flop_2;
		resetSelect();
	}
	public void pickFlop3(View view) {
		activeId = R.id.imageButton_card_flop_3;
		resetSelect();
	}
	public void pickTurn(View view) {
		activeId = R.id.imageButton_card_turn;
		resetSelect();
	}
	public void pickRiver(View view) {
		activeId = R.id.imageButton_card_river;
		resetSelect();
	}
	
	private void play(int kind, int value) {
		ImageButton img = (ImageButton)findViewById(activeId);
		if (img != null) {
			String card = CardUtils.getCard(kind, value);
			System.out.println("playing "+card);
			img.setImageURI(Uri.parse("android.resource://com.example.hifi_prototyp/drawable//"+card));
//			active = null;
			int[] prev = placedCards.put(activeId, new int[] {kind, value});
			if (prev != null) {
				unavailableCards.get(CardUtils.getKind(prev[0])).remove(new Integer(prev[1]));
			}
			unavailableCards.get(CardUtils.getKind(kind)).add(new Integer(value));
			activeId = cardButtons.get((cardButtons.indexOf(activeId)+1) % cardButtons.size());
		}
		resetSelect();
	}

	private void resetSelect() {
		isKind = false;
		isValue = false;
		selectedKind = -1;
		selectedValue = -1;
		paintSelect();
	}
	
	private void resetCard() {
		resetSelect();
		ImageButton img = (ImageButton)findViewById(activeId);
		img.setImageURI(Uri.parse("android.resource://com.example.hifi_prototyp/drawable//ec"));
		int[] prev = placedCards.put(activeId, null);
		if (prev != null) {
			unavailableCards.get(CardUtils.getKind(prev[0])).remove(new Integer(prev[1]));
		}
	}
	
	public static Map<Integer, int[]> getCardsOnTable() {
		return placedCards;
	}
	
	private void setCards() {
		for (Integer i : cardButtons) {
			setCard(i);
		}
	}
	
	private void setCard(int id) {
		ImageButton img = (ImageButton)findViewById(id);
		String card;
		if (placedCards.containsKey(id)) {
			int[] indexes = placedCards.get(id);
			card = (indexes == null) ? "card_undef_big" : CardUtils.getCard(indexes[0], indexes[1]);
		} else {
			card = "card_undef_big";
		}
		img.setImageURI(Uri.parse("android.resource://com.example.hifi_prototyp/drawable//"+card));
	}
	
	private void paintSelect() {
		for (Integer i : cardButtons) {
			ImageButton card = (ImageButton)findViewById(i);
			card.setColorFilter(null);
		}
		
		ImageButton card = (ImageButton)findViewById(activeId);
		card.setColorFilter(0xFFA3FFA3, PorterDuff.Mode.MULTIPLY);
		
//		ImageView img = (ImageView)findViewById(R.id.card_wheel);
//		Resources r = getResources();
//		List<Drawable> layers = new ArrayList<Drawable>();;
//		if (isKind) {
//			/*Bitmap bmo = BitmapFactory.decodeResource(r, R.drawable.select_inner);
//			Bitmap bmn = Bitmap.createBitmap(bmo.getWidth(), bmo.getHeight(), Bitmap.Config.ARGB_8888);
//			Canvas c = new Canvas(bmn);
//			c.rotate(selectedKind*90, bmo.getWidth()/2, bmo.getHeight()/2);
//			c.drawBitmap(bmo, 0, 0, null);
//			layers.add(new BitmapDrawable(this.getResources(),"c"));*/
//			layers.add(r.getDrawable(R.drawable.select_inner));
//			Drawable[] layers2 = new Drawable[layers.size()];
//			LayerDrawable layerDrawable = new LayerDrawable(layers.toArray(layers2));
//			img.setBackground(layerDrawable);
//		}
	}
	
	/** Called when the user clicks the Back reset button */
	public void closeActivity(View view) {
		Log.d("pick card", "BACK");
		finish();
	}
}
