package com.example.hifi_prototyp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class RegisterUser extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		final Button btn = (Button)findViewById(R.id.button_register);
		CheckBox mCheckBox= ( CheckBox ) findViewById( R.id.checkBox_register_terms);
		mCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
		    {
		        btn.setEnabled(isChecked);
		     }
		});
	}
	
	public boolean usernameCheck() {
		EditText text = (EditText)findViewById(R.id.editText_register_username);
		if(text.getText().toString().equals("")){
			text.setError("Cant be empty");
			return false;
		}
		return true;
	}
	public boolean emailCheck() {
		EditText text = (EditText)findViewById(R.id.editText_register_email);
		if(text.getText().toString().equals("")){
			text.setError("Cant be empty");
			return false;
		} else if (!text.getText().toString().contains("@") || !text.getText().toString().contains(".")) {
			text.setError("Wrong email");
			return false;
		}
		return true;
	}
	public boolean birthdayCheck() {
		EditText text = (EditText)findViewById(R.id.editText_register_birthday);
		if(text.getText().toString().equals("")){
			text.setError("Cant be empty");
			return false;
		} else {
			boolean ok = false;
			try {
				new SimpleDateFormat("dd/MM/yyyy").parse(text.getText().toString());
				ok = true;
			} catch (ParseException e) {
				// wrong format
			}
			if (!ok) {
				text.setError("Wrong format of date");
			}
			return ok;
		}
	}
	public boolean passwCheck() {
		EditText text1 = (EditText)findViewById(R.id.editText_register_passw);
		EditText text2 = (EditText)findViewById(R.id.editText_register_password_again);
		boolean ok = true;
		if(text1.getText().toString().equals("")){
			text1.setError("Cant be empty");
			ok = false;
		}
		if(text2.getText().toString().equals("")){
			text2.setError("Cant be empty");
			ok = false;
		}
		if(!text1.getText().toString().equals(text2.getText().toString())){
			text1.setError("Passwords differs");
			text2.setError("Passwords differs");
			ok = false;
		}
		return ok;
	}
	
	public void register(View view) {
		emailCheck();
		birthdayCheck();
		passwCheck();
		if (usernameCheck() && emailCheck() && birthdayCheck() && passwCheck()) {
			Intent displayMainMenu = new Intent(this, MainMenu.class);
			startActivity(displayMainMenu);
		}
	}
	
	/** Called when the user clicks the Back reset button */
	public void closeActivity(View view) {
		finish();
	}
}
