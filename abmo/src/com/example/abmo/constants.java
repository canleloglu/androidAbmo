package com.example.abmo;

import java.util.ArrayList;
import java.util.List;

enum taskProcess{
	TASKPROCESSJUSTSTARTED,
	TASKPROCESSMEDIUMPROCESS,
	TASKPROCESSFINISHED
}

public class constants {
	public List<task> taskArray = new ArrayList<task>();	
	
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
	}
	
	static String stringForProgress(int progress){
		String progressText;
		if(progress  == 0){
        	progressText = "Henuz Baslanmadi";
        }else if (progress > 0 && progress < 25){
        	progressText = "Goreve baslandi";
        }else if (progress >= 25 && progress < 75){
        	progressText = "Gorev yarilandi";
        }else if(progress >= 75 && progress < 100){
        	progressText = "Gorev bitmek uzere";
        }else{
        	progressText = "Gorev bitti";
        }
		return progressText;
	}
}
