package com.example.abmo;

enum taskProcess{
	TASKPROCESSJUSTSTARTED,
	TASKPROCESSMEDIUMPROCESS,
	TASKPROCESSFINISHED
}

public class constants {
	
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
