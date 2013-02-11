package com.example.abmo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

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
	
	public static String getNodeValueByTagName(Node parentNode, String tagNameOfNode)
	{
	    String nodeValue = "";
	    if (((Element) parentNode).getElementsByTagName(tagNameOfNode).getLength() != 0)
	        if (((Element) ((Element) parentNode).getElementsByTagName(tagNameOfNode).item(0)).hasChildNodes())
	        {
	            nodeValue = ((Node) ((Element) ((Element) parentNode).getElementsByTagName(tagNameOfNode).item(0)).getChildNodes().item(0)).getNodeValue();
	        }
	    return nodeValue;
	}

	public static String getNodeAttributeByTagName(Node parentNode, String tagNameOfAttr)
	{
	    String nodeValue = "";

	    NamedNodeMap questNodeAttr = parentNode.getAttributes();

	    if (questNodeAttr.getLength() != 0)
	        nodeValue = questNodeAttr.getNamedItem(tagNameOfAttr).getTextContent();

	    return nodeValue;
	}
	
	public static Bitmap loadImage(String image_location)
	{    	 
          URL imageURL = null;
          
          try {
        	  imageURL = new URL(image_location);
          }
          
          catch (MalformedURLException e) {
              e.printStackTrace();
          }
          
          try {
        	  HttpURLConnection connection= (HttpURLConnection)imageURL.openConnection();
        	  connection.setDoInput(true);
        	  connection.connect();
              InputStream inputStream = connection.getInputStream();
               
              Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
              return bitmap;
          }
          catch (IOException e) {
              Log.e("tag", e.toString());
          }
          return null;
     }
}
