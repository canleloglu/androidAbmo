package com.example.abmo;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity {
	public int i = 1;
	public List<Person> personList = new ArrayList<Person>();
	
	
	public String getNodeValueByTagName(Node parentNode, String tagNameOfNode)
	{
	    String nodeValue = "";
	    if (((Element) parentNode).getElementsByTagName(tagNameOfNode).getLength() != 0)
	        if (((Element) ((Element) parentNode).getElementsByTagName(tagNameOfNode).item(0)).hasChildNodes())
	        {
	            nodeValue = ((Node) ((Element) ((Element) parentNode).getElementsByTagName(tagNameOfNode).item(0)).getChildNodes().item(0)).getNodeValue();
	        }
	    return nodeValue;
	}

	public String getNodeAttributeByTagName(Node parentNode, String tagNameOfAttr)
	{
	    String nodeValue = "";

	    NamedNodeMap questNodeAttr = parentNode.getAttributes();

	    if (questNodeAttr.getLength() != 0)
	        nodeValue = questNodeAttr.getNamedItem(tagNameOfAttr).getTextContent();

	    return nodeValue;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy); 
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void connect(String url)
	{
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
	        Document doc = db.parse(inStream);
	        doc.getDocumentElement().normalize();

	        NodeList staffNodeList = doc.getElementsByTagName("task");

	        for (int i = 0; i < staffNodeList.getLength(); i++)
	        {
	            Node taskNode = staffNodeList.item(i);
	            task t = new task();
	            t.desc = getNodeValueByTagName(taskNode, "desc");
	            t.taskDetail = getNodeValueByTagName(taskNode, "detail");
	            t.imageURL = getNodeValueByTagName(taskNode, "image");
	            t.videoURL = getNodeValueByTagName(taskNode, "video");
	            t.progress = Integer.parseInt(getNodeValueByTagName(taskNode, "progress"));	            
	        }
	    } catch (Exception e) {
	    	Log.e("tag", e.toString());
	    }
	}
	
	public void request (View target) throws ClientProtocolException, IOException{
		connect("http://www.estenerji.com/webservice/WebService1.asmx/getTasks");
	}
	
	public void submit (View target){
		EditText editName = (EditText)findViewById(R.id.editText1);
		EditText editSurname = (EditText)findViewById(R.id.editText2);
		
		Person p = new Person();
		p.name = editName.getText().toString();
		p.surname = editSurname.getText().toString();
		personList.add(p);
		
		editName.setText("");
		editSurname.setText("");
		
		editName.setOnEditorActionListener(new OnEditorActionListener() {
		    @Override
		    public boolean onEditorAction(TextView v, int keyCode,
		            KeyEvent event) {
		         if ( (event.getAction() == KeyEvent.ACTION_DOWN  ) &&
		             (keyCode           == KeyEvent.KEYCODE_ENTER)   )
		        {               
		        	 InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		        	 EditText _editText = (EditText)findViewById(R.id.editText1);
		        	 imm.hideSoftInputFromWindow(_editText.getWindowToken(), 0);
		        	 return true;
		        }
		        return false;
		    }
		});
		editSurname.setOnEditorActionListener(new OnEditorActionListener() {
		    @Override
		    public boolean onEditorAction(TextView v, int keyCode,
		            KeyEvent event) {
		         if ( (event.getAction() == KeyEvent.ACTION_DOWN  ) &&
		             (keyCode           == KeyEvent.KEYCODE_ENTER)   )
		        {               
		        	 InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		        	 EditText _editText = (EditText)findViewById(R.id.editText2);
		        	 imm.hideSoftInputFromWindow(_editText.getWindowToken(), 0);
		        	 return true;
		        }
		        return false;
		    }
		});

		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(editName.getWindowToken(), 0);
		imm.hideSoftInputFromWindow(editSurname.getWindowToken(), 0);
		
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(this, taskList.class));
		startActivity(intent);
	}
	
	public void log (View target){
		for(int i = 0; i < personList.size(); i++){	
			Log.i("tag", personList.get(i).name + " " + personList.get(i).surname);
		}
	}
}
