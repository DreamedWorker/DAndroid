package com.dream.dandroid;

import android.os.*;
import android.support.v7.app.*;
import android.widget.*;
import java.util.*;
import android.content.*;

public class MainActivity extends AppCompatActivity
 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		//Hide ActionBar
		ActionBar abr = getSupportActionBar();
		if(abr.isShowing()) abr.hide();
		Toast.makeText(getApplicationContext(),"Loading…",Toast.LENGTH_SHORT).show();
		//Go to next page
		TimerTask t = new TimerTask(){

			@Override
			public void run()
			{
				// TODO: Implement this method
				startActivity(new Intent(getApplicationContext(),HomeActivity.class));
				finish();
			}
		};
		Timer timer = new Timer();
		timer.schedule(t,2500);
    }
    
}
