package com.example.abmo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class taskList extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.tasklist);
	    
	    getActionBar().setDisplayHomeAsUpEnabled(true);
	    
	    constants c = new constants();
	    c.generateTask();

	    ListView listView = (ListView)findViewById(R.id.listView1);
	    taskAdapter adapter = new taskAdapter(this, c.taskArray);	    
		listView.setAdapter(adapter);		
        
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(taskList.this, taskDetail.class);
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
