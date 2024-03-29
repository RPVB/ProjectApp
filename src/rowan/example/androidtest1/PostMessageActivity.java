package rowan.example.androidtest1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class PostMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_message);
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		
	    HttpClient httpclient = new DefaultHttpClient();
	       HttpPost httppost = new HttpPost("http://thomassio.nl:2002");
	       try {
	       httppost.setHeader("Content-type", "application/json");  
	       List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	       nameValuePairs.add(new BasicNameValuePair("data","{ 'type':'tip','location':'51.91737 4.48481','description':'"+message+"'}"));
	       httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	       
	       httpclient.execute(httppost);

	     } catch (ClientProtocolException e) {
	         // TODO Auto-generated catch block
	     } catch (IOException e) {
	         // TODO Auto-generated catch block
	     }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.post_message, menu);
		return true;
	}

}
