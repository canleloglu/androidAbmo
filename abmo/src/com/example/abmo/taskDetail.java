package com.example.abmo;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class taskDetail extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.taskdetail);
	    getActionBar().setDisplayHomeAsUpEnabled(true);
	    
	    Intent i = getIntent();
	    task t= (task) i.getParcelableExtra("task");
	    
	    TextView titleView = (TextView)findViewById(R.id.tasktitle);
	    TextView detailView = (TextView)findViewById(R.id.taskdetail);
	    SeekBar taskprogress = (SeekBar)findViewById(R.id.taskprogress);
	    
	    titleView.setText(t.desc);
	    detailView.setText(t.taskDetail);
	    taskprogress.setMax(100);
	    taskprogress.setProgress(t.progress);
	    
	    taskprogress.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
		    public void onStopTrackingTouch(SeekBar arg0) {}	
		    public void onStartTrackingTouch(SeekBar arg0) {}
		    public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
		    	TextView progressText = (TextView)findViewById(R.id.progresstext);
		        progressText.setText(constants.stringForProgress(progress));
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
