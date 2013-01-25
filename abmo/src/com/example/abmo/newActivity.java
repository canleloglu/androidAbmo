package com.example.abmo;

import java.sql.Struct;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class newActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.newactivity);
	    
	    getActionBar().setDisplayHomeAsUpEnabled(true);
	    
	    String[] items={"can","suna", "zerrin", "seden", "deniz", "birce", "aysin", "suleyman", "suleyman", "osman", "batu", "mert", "hasancan", "ekin"};
	    ListView listView = (ListView)findViewById(R.id.listView1);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, items);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(newActivity.this, taskDetail.class);
			    startActivity(intent);
			}
		});
	    
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
	    if(item.getItemId()==android.R.id.home){
	        finish();//finish your activity
	    }
	    return super.onMenuItemSelected(featureId, item);
	}
}
