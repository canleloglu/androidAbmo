package com.example.abmo;

import android.os.Parcel;
import android.os.Parcelable;

public class task implements Parcelable{
	public String desc;
	public String taskDetail;
	public int progress;
	public String imageURL;
	public String videoURL;
	
	public task(){}
	
	public task(String newDesc, String newTaskDetail, int newProgress, String newImageURL, String newVideoURL){
		desc = newDesc;
		taskDetail = newTaskDetail;
		progress = newProgress;
		imageURL = newImageURL;
		videoURL = newVideoURL;
	}
	
	public task(Parcel in){		
		desc = in.readString();
		taskDetail = in.readString();
		imageURL = in.readString();
		videoURL = in.readString();
		progress = in.readInt();
	}
	
	// write your object's data to the passed-in Parcel
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(desc);
        out.writeString(taskDetail);
        out.writeString(imageURL);
        out.writeString(videoURL);
        out.writeInt(progress);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<task> CREATOR = new Parcelable.Creator<task>() {
        public task createFromParcel(Parcel in) {
            return new task(in);
        }

        public task[] newArray(int size) {
            return new task[size];
        }
    };

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
}
