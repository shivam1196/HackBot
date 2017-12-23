package com.example.shivam.hackbot;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.security.Provider;

/**
 * Created by shivam on 30/11/17.
 */

public class MyService extends Service {
    Runnable mRunnable;
    Handler mHandler;
    String body;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
      mHandler = new Handler();
      mRunnable = new Runnable() {
          @Override
          public void run() {
              Uri uri = Uri.parse("content://sms/inbox");
            //  String   backup = Environment.getExternalStorageDirectory().getAbsolutePath()+ "/WhatsApp/Databases/msgstore.db.crypt5";
        //      Uri uri1 = Uri.parse(backup);
            //  Cursor cursor1 = getContentResolver().query(uri1,null,null,null,null);
              Cursor cursor=getContentResolver().query(uri,null,null,null,null);

              if(cursor.moveToFirst())
              {
                  do {
                       body = cursor.getString(cursor.getColumnIndex("body"));
                   //   Toast.makeText(MyService.this, body+"", Toast.LENGTH_SHORT).show();
                  }while (cursor.moveToNext());
              }
              //Toast.makeText(MyService.this, cursor.toString()+"", Toast.LENGTH_SHORT).show();
              Toast.makeText(MyService.this, body+"", Toast.LENGTH_SHORT).show();
              mHandler.postDelayed(this,1000);
          }
      };
        mHandler.postDelayed(mRunnable,1000);
        return  START_STICKY;
    }
}

