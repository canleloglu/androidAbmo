package com.example.abmo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity {
	public int i = 1;
	public List<Person> personList = new ArrayList<Person>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void submit (View target){
		EditText editName = (EditText)findViewById(R.id.editText1);
		EditText editSurname = (EditText)findViewById(R.id.editText2);
		
		Person p = new Person();
		p.name = editName.getText().toString();
		p.surname = editSurname.getText().toString();
		personList.add(p);
		
		editName.setText("");
		editSurname.setText("");
		
		editName.setOnEditorActionListener(new OnEditorActionListener() {
		    @Override
		    public boolean onEditorAction(TextView v, int keyCode,
		            KeyEvent event) {
		         if ( (event.getAction() == KeyEvent.ACTION_DOWN  ) &&
		             (keyCode           == KeyEvent.KEYCODE_ENTER)   )
		        {               
		        	 InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		        	 EditText _editText = (EditText)findViewById(R.id.editText1);
		        	 imm.hideSoftInputFromWindow(_editText.getWindowToken(), 0);
		        	 return true;
		        }
		        return false;
		    }
		});
		editSurname.setOnEditorActionListener(new OnEditorActionListener() {
		    @Override
		    public boolean onEditorAction(TextView v, int keyCode,
		            KeyEvent event) {
		         if ( (event.getAction() == KeyEvent.ACTION_DOWN  ) &&
		             (keyCode           == KeyEvent.KEYCODE_ENTER)   )
		        {               
		        	 InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		        	 EditText _editText = (EditText)findViewById(R.id.editText2);
		        	 imm.hideSoftInputFromWindow(_editText.getWindowToken(), 0);
		        	 return true;
		        }
		        return false;
		    }
		});

		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(editName.getWindowToken(), 0);
		imm.hideSoftInputFromWindow(editSurname.getWindowToken(), 0);
		
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(this, newActivity.class));
		startActivity(intent);
	}
	
	public void log (View target){
		for(int i = 0; i < personList.size(); i++){	
			Log.i("tag", personList.get(i).name + " " + personList.get(i).surname);
		}
	}
}
