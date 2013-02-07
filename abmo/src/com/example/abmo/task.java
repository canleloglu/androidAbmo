package com.example.abmo;

public class task {
	public String desc;
	public String taskDetail;
	public int progress;
	public String imageURL;
	public String videoURL;	
	
	public task(String newDesc, String newTaskDetail, int newProgress, String newImageURL, String newVideoURL){
		desc = newDesc;
		taskDetail = newTaskDetail;
		progress = newProgress;
		imageURL = newImageURL;
		videoURL = newVideoURL;
	}
}
