package com.example.abmo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class newActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.newactivity);
	    
	    getActionBar().setDisplayHomeAsUpEnabled(true);
	    
	    Bundle bundle = getIntent().getExtras();
	    String value = bundle.getString("name");
	    Log.i("tag", value);	
	    
	    String[] items={"can","suna", "zerrin"};
	    ListView listView = (ListView)findViewById(R.id.listView1);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, items);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(),
						"Click ListItem Number " + position, Toast.LENGTH_LONG)
						.show();
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
