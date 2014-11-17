package com.example.hifi_prototyp;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class PickCard extends Activity {

	private int x,y;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pick_card);
		
		ImageView img = (ImageView)findViewById(R.id.imageView1);
		img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
            	x = (int)event.getX();
        	    y = (int)event.getY();
        		return false;
            }
		});
	}
	
	public void pickCard(View view) {
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		view.getX();
		int clickX = x / (width / 13);
	    int clickY = y / (height / 4);
	    Log.d("pick card", "x="+clickX+", y="+clickY+", size="+width+"x"+height+", touch x="+x+", y="+y);
	    
	    String card = "";
	    switch (clickY) {
	    case 0: card = "h"; break;
	    case 1: card = "c"; break;
	    case 2: card = "d"; break;
	    case 3: card = "s"; break;
	    }
	    switch (clickX) {
	    case 9: card = card+"j"; break;
	    case 10: card = card+"q"; break;
	    case 11: card = card+"k"; break;
	    case 12: card = card+"1"; break;
	    default: card = card + String.valueOf(clickX+2);
	    }
	    PokerTable.setCard(card);
	    Log.d("pick card", "picked "+card);
	    finish();
	}
	
	/** Called when the user clicks the Back reset button */
	public void closeActivity(View view) {
		Log.d("pick card", "BACK");
		finish();
	}
}
