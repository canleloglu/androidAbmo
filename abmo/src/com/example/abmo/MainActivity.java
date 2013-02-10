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
	public myApp appd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		appd = (myApp)getApplication();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void submit (View target){
		EditText editName = (EditText)findViewById(R.id.editText1);
		EditText editPass = (EditText)findViewById(R.id.editText2);
		
		if(appd.login(editName.getText().toString(), editPass.getText().toString())){
			appd.getTasks();
			Intent intent = new Intent();
			intent.setComponent(new ComponentName(this, taskList.class));
			startActivity(intent);
		}
		editName.setText("");
		editPass.setText("");
		
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
		editName.setOnEditorActionListener(new OnEditorActionListener() {
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
		imm.hideSoftInputFromWindow(editPass.getWindowToken(), 0);
	}
}
