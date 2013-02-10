package com.example.abmo;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import android.R.bool;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.util.Log;

public class myApp extends Application {
	
	private static myApp m_Instance;
	public ArrayList<task> taskList = new ArrayList<task>();
	public user u = new user();
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
	
	public Document apiCall(String url){
		Document doc = null;
		HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url); 	    
	    try {
	        HttpResponse response = httpClient.execute(httpPost);
	        HttpEntity r_entity = response.getEntity();
	        String xmlString = EntityUtils.toString(r_entity);
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = factory.newDocumentBuilder();
	        InputSource inStream = new InputSource();
	        inStream.setCharacterStream(new StringReader(xmlString));
	        doc = db.parse(inStream);
	        doc.getDocumentElement().normalize();
	        return doc;
	    }catch (Exception e) {}
	    return doc;	    
	}
	
	public Document apiCall(String url, List<NameValuePair> nameValuePairs){
		Document doc = null;
		HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url); 	    
        try {
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	    try {
	        HttpResponse response = httpClient.execute(httpPost);
	        HttpEntity r_entity = response.getEntity();
	        String xmlString = EntityUtils.toString(r_entity);
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = factory.newDocumentBuilder();
	        InputSource inStream = new InputSource();
	        inStream.setCharacterStream(new StringReader(xmlString));
	        doc = db.parse(inStream);
	        doc.getDocumentElement().normalize();
	        return doc;
	    }catch (Exception e) {}
	    return doc;	    
	}
	
	public void getTasks(){
		HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://www.estenerji.com/webservice/WebService1.asmx/getTasks"); 	    
	    try {
	        HttpResponse response = httpClient.execute(httpPost);
	        HttpEntity r_entity = response.getEntity();
	        String xmlString = EntityUtils.toString(r_entity);
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = factory.newDocumentBuilder();
	        InputSource inStream = new InputSource();
	        inStream.setCharacterStream(new StringReader(xmlString));
	        Document doc = db.parse(inStream);
	        doc.getDocumentElement().normalize();

	        NodeList staffNodeList = doc.getElementsByTagName("task");
	        taskList.clear();
	        for (int i = 0; i < staffNodeList.getLength(); i++)
	        {
	            Node taskNode = staffNodeList.item(i);
	            task t = new task();	            	           
	            t.taskid = Integer.parseInt(constants.getNodeValueByTagName(taskNode, "taskid"));
	            t.desc = constants.getNodeValueByTagName(taskNode, "desc");
	            t.taskDetail = constants.getNodeValueByTagName(taskNode, "detail");
	            t.imageURL = constants.getNodeValueByTagName(taskNode, "image");
	            t.videoURL = constants.getNodeValueByTagName(taskNode, "video");
	            t.progress = Integer.parseInt(constants.getNodeValueByTagName(taskNode, "progress"));	            
	            taskList.add(t);
	        }
	    } catch (Exception e) {
	    	Log.e("tag", e.toString());
	    }
	}
	
	public void updateTask(int taskid, int progress){
		
		HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://www.estenerji.com/webservice/WebService1.asmx/updateTask");        
        try {
        	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("taskid", Integer.toString(taskid)));
            nameValuePairs.add(new BasicNameValuePair("progress", Integer.toString(progress)));
			httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	    try {
	        httpClient.execute(httpPost);
	    }catch (Exception e) {
	    	Log.e("tag", e.toString());
		}
        
	}
	
	public boolean login(String username, String password){
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		nameValuePairs.add(new BasicNameValuePair("username", username));
        nameValuePairs.add(new BasicNameValuePair("password", password));
		Document doc = apiCall("http://www.estenerji.com/webservice/WebService1.asmx/login", nameValuePairs);
		NodeList user = doc.getElementsByTagName("user");
        Node userNode = user.item(0);
        String usr = constants.getNodeValueByTagName(userNode, "username");
        String psw = constants.getNodeValueByTagName(userNode, "password");
        if(usr != "" && psw != ""){
        	u.username = usr;
        	u.password = psw;
        	return true;
        }else{
        	return false;
        }		
	}
}
