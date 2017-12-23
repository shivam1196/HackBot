package com.example.shivam.hackbot;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextView,mTextView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView=(TextView)findViewById(R.id.txtView1);
        mTextView1=(TextView)findViewById(R.id.txtView2);
//        Uri uri = Uri.parse("content://sms/inbox");
//        Cursor c = getContentResolver().query(uri,null,null,null,null);
//      if(  c.moveToFirst())
//      {
//          mTextView.setText(c.getString(c.getColumnIndexOrThrow("body")).toString());
//      }
        mTextView.setText("Hello");
        Intent intent = new Intent(MainActivity.this,MyService.class);
        startService(intent);
    }
}
