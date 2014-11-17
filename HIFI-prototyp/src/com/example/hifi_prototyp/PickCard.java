package com.example.hifi_prototyp;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class PickCard extends Activity {

	public static String picked = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pick_card);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		
		int x = (int)event.getX();
	    int y = (int)event.getY();
	    
	    int clickX = x / (width / 13);
	    int clickY = y / (height / 4);
		return true;
	}

	public void pickCard(View view) {
//		view
	}
	
	/** Called when the user clicks the Back reset button */
	public void closeActivity(View view) {
		finish();
	}
}
