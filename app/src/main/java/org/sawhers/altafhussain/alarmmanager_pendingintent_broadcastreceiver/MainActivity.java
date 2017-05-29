package org.sawhers.altafhussain.alarmmanager_pendingintent_broadcastreceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.sawhers.altafhussain.alarmmanager_pendingintent_broadcastreceiver.recivers.audioListner;

public class MainActivity extends AppCompatActivity {
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);



        Intent  intent=new Intent(MainActivity.this,audioListner.class);
        //here in pending intent we put our intent mean we need to pass the this intent in future
        //PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,10,intent,0);
        intent.putExtra("SILENT",true);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,10,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+5*1000,pendingIntent);
//++++++++++++++++++++++++++++++++++++++++++
        intent.putExtra("SILENT",false);
        PendingIntent pendingIntent2=PendingIntent.getBroadcast(MainActivity.this,20,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+10*1000,pendingIntent2);




    }
}
