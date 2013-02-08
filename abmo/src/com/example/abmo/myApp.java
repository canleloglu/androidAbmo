package com.example.abmo;

import java.util.ArrayList;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public class myApp extends Application {
	
	private static myApp m_Instance;
	public ArrayList<task> taskList = new ArrayList<task>();
	
	private ConnectivityManager cMgr;
	
	public myApp() {
		super();
		m_Instance = this;
	}
	
	public static myApp getInstance() {
		if(m_Instance == null) {
			synchronized(myApp.class) {
				if(m_Instance == null) new myApp();
			}
		}
	 
		return m_Instance;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		this.cMgr = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

	}
	
	@Override
	public void onTerminate() {
	    // not guaranteed to be called
	    super.onTerminate();
	}
	
	public boolean connectionPresent() {
	    NetworkInfo netInfo = cMgr.getActiveNetworkInfo();
	    if ((netInfo != null) && (netInfo.getState() != null)) {
	        return netInfo.getState().equals(State.CONNECTED);
	    }
	    return false;
	}
	
	public void generateTask(){
		task t = new task("Gorev 1", "1. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		task t2 = new task("Gorev 2", "2. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		task t3 = new task("Gorev 3", "3. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		task t4 = new task("Gorev 4", "4. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		task t5 = new task("Gorev 5", "5. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		task t6 = new task("Gorev 6", "6. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		task t7 = new task("Gorev 7", "7. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		task t8 = new task("Gorev 8", "8. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		task t9 = new task("Gorev 9", "9. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		task t10 = new task("Gorev 10", "10. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		task t11 = new task("Gorev 11", "11. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		task t12 = new task("Gorev 12", "12. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		task t13 = new task("Gorev 13", "13. odada problem var. Git oradaki problemi coz.", 0, "image", "video");
		
		taskList.add(t);
		taskList.add(t2);
		taskList.add(t3);
		taskList.add(t4);
		taskList.add(t5);
		taskList.add(t6);
		taskList.add(t7);
		taskList.add(t8);
		taskList.add(t9);
		taskList.add(t10);
		taskList.add(t11);
		taskList.add(t12);
		taskList.add(t13);	
	}
	
}
