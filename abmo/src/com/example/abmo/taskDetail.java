package com.example.abmo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class taskDetail extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.taskdetail);
	    getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
	    if(item.getItemId()==android.R.id.home){
	        finish();//finish your activity
	    }
	    return super.onMenuItemSelected(featureId, item);
	}
}
