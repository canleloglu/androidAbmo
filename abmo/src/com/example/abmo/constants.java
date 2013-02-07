package com.example.abmo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

enum taskProcess{
	TASKPROCESSJUSTSTARTED,
	TASKPROCESSMEDIUMPROCESS,
	TASKPROCESSFINISHED
}

public class constants {
	public List<task> taskArray = new ArrayList<task>();	
	ArrayList<HashMap<String, String>> taskList = new ArrayList<HashMap<String, String>>();
	public void generateTask(){
		task t = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		task t2 = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		task t3 = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		task t4 = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		task t5 = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		task t6 = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		task t7 = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		task t8 = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		task t9 = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		task t10 = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		task t11 = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		task t12 = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		task t13 = new task("Gorev 1", "4. odada problem var. Git oradaki problemi coz.", 0, "", "");
		
		taskArray.add(t);
		taskArray.add(t2);
		taskArray.add(t3);
		taskArray.add(t4);
		taskArray.add(t5);
		taskArray.add(t6);
		taskArray.add(t7);
		taskArray.add(t8);
		taskArray.add(t9);
		taskArray.add(t10);
		taskArray.add(t11);
		taskArray.add(t12);
		taskArray.add(t13);
		
		HashMap<String, String> map = new HashMap<String, String>();
	    map.put("desc", t.desc);
	    HashMap<String, String> map2 = new HashMap<String, String>();
	    map2.put("desc", t2.desc);
	    HashMap<String, String> map3 = new HashMap<String, String>();
	    map3.put("desc", t3.desc);
	    HashMap<String, String> map4 = new HashMap<String, String>();
	    map4.put("desc", t4.desc);
	    HashMap<String, String> map5 = new HashMap<String, String>();
	    map5.put("desc", t5.desc);
	    HashMap<String, String> map6 = new HashMap<String, String>();
	    map6.put("desc", t6.desc);
	    HashMap<String, String> map7 = new HashMap<String, String>();
	    map7.put("desc", t7.desc);
	    HashMap<String, String> map8 = new HashMap<String, String>();
	    map8.put("desc", t8.desc);
	    HashMap<String, String> map9 = new HashMap<String, String>();
	    map9.put("desc", t9.desc);
	    HashMap<String, String> map10 = new HashMap<String, String>();
	    map10.put("desc", t10.desc);
	    HashMap<String, String> map11 = new HashMap<String, String>();
	    map11.put("desc", t11.desc);
	    HashMap<String, String> map12 = new HashMap<String, String>();
	    map12.put("desc", t12.desc);
	    HashMap<String, String> map13 = new HashMap<String, String>();
	    map13.put("desc", t13.desc);
        
		taskList.add(0, map);
		taskList.add(0, map2);
		taskList.add(0, map3);
		taskList.add(0, map4);
		taskList.add(0, map5);
		taskList.add(0, map6);
		taskList.add(0, map7);
		taskList.add(0, map8);
		taskList.add(0, map9);
		taskList.add(0, map10);
		taskList.add(0, map11);
		taskList.add(0, map12);
		taskList.add(0, map13);		
	}
}
