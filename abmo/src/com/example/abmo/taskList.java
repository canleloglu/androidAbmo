package com.example.abmo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class taskList extends Activity {
	public myApp appd;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.tasklist);
	    
	    getActionBar().setDisplayHomeAsUpEnabled(true);
	   	appd = (myApp)getApplication();
	    appd.generateTask();

	    ListView listView = (ListView)findViewById(R.id.listView1);
	    taskAdapter adapter = new taskAdapter(this, appd.taskList);
		listView.setAdapter(adapter);
        
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(taskList.this, taskDetail.class);
				task t = taskList.this.appd.taskList.get(position);
				intent.putExtra("task", t);
				intent.putExtra("index", position);
			    startActivity(intent);
			}
		});
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
	    if(item.getItemId()==android.R.id.home){
	        finish();
	    }
	    return super.onMenuItemSelected(featureId, item);
	}
}
