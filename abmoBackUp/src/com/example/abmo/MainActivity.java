package com.example.abmo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

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
	}
	
	public void log (View target){
		for(int i = 0; i < personList.size(); i++){	
			Log.i("tag", personList.get(i).name + " " + personList.get(i).surname);
		}
	}
	
	public void navigate (View target){
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(this, newActivity.class));
		intent.putExtra("name", "value");
		startActivity(intent);
	}
}
