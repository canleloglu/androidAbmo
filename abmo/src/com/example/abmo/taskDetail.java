package com.example.abmo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.VideoView;

public class taskDetail extends Activity {
	public task t;
	public int index;
	myApp appd;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.taskdetail);
	    getActionBar().setDisplayHomeAsUpEnabled(true);
	    
	    appd = (myApp)getApplication();
	    
	    Intent i = getIntent();
	    t = (task) i.getParcelableExtra("task");
	    Bundle b = getIntent().getExtras();
	    index = b.getInt("index");
	    
	    TextView titleView = (TextView)findViewById(R.id.tasktitle);
	    TextView detailView = (TextView)findViewById(R.id.taskdetail);
	    TextView progressText = (TextView)findViewById(R.id.progresstext);
	    SeekBar taskprogress = (SeekBar)findViewById(R.id.taskprogress);
	    
	    titleView.setText(t.desc);
	    detailView.setText(t.taskDetail);
	    taskprogress.setMax(100);
	    taskprogress.setProgress(t.progress);
	    progressText.setText(constants.stringForProgress(t.progress));
	    
	    if(!t.imageURL.equals("")){
	    	ImageView imageView = (ImageView)findViewById(R.id.imageView1);
	    	imageView.setVisibility(0);
	    	Bitmap bit = constants.loadImage(t.imageURL);
	    	imageView.setImageBitmap(bit);
	    }
	    if(!t.videoURL.equals("")){
	    	VideoView videoView = (VideoView)findViewById(R.id.videoView2);
	    	videoView.setVisibility(0);
	    	showVideo(t.videoURL);
	    }
	    
	    taskprogress.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
		    public void onStopTrackingTouch(SeekBar arg0) {
		    	appd.updateTask(t.taskid, arg0.getProgress());
		    }
		    public void onStartTrackingTouch(SeekBar arg0) {}
		    public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
		    	TextView progressText = (TextView)findViewById(R.id.progresstext);
		        progressText.setText(constants.stringForProgress(progress));
		        appd.taskList.get(index).progress = progress;
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
	
	public void showVideo(String src){				
		VideoView videoView = (VideoView)findViewById(R.id.videoView2);
		videoView.setVisibility(1);
	    MediaController mediaController= new MediaController(this);
	    mediaController.setAnchorView(videoView);        
	    Uri uri= Uri.parse(src);        
	    videoView.setMediaController(mediaController);
	    videoView.setVideoURI(uri);        
	    videoView.requestFocus();

	    videoView.start();
	}
}
